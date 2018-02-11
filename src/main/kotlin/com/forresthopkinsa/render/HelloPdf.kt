package com.forresthopkinsa.render

import com.forresthopkinsa.loadBuffer
import com.forresthopkinsa.makeRoundedCorner
import com.forresthopkinsa.model.message.Media
import com.forresthopkinsa.model.message.Message
import com.forresthopkinsa.model.message.Text
import org.apache.pdfbox.pdmodel.font.PDType1Font
import rst.pdfbox.layout.elements.*
import rst.pdfbox.layout.elements.render.VerticalLayoutHint
import rst.pdfbox.layout.shape.RoundRect
import rst.pdfbox.layout.text.Alignment
import rst.pdfbox.layout.text.NewLine
import rst.pdfbox.layout.text.StyledText
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

class HelloPdf {
	
	private val document = Document(40F, 50F, 40F, 60F)
	private val fgColor = Color.WHITE
	private val bgColor = Color(86, 181, 111)
	private val radius = 13F
	
	fun append(message: Message) {
		val align = when {
			message.sender.name == "Forrest" -> Alignment.Left
			message.sender.name == "Serena " -> Alignment.Right
			else -> throw IllegalArgumentException()
		}
		
		when (message) {
			is Media -> {
				val image = loadBuffer(message.imageUrl)
				append(makeRoundedCorner(image, image.height/10), align)
			}
			is Text -> append(message.text, align)
		}
	}
	
	private fun append(text: String, align: Alignment) {
		if (text.isBlank()) return
		
		val paragraph = Paragraph()
		
		// StyledText doesn't allow line feeds
		text.lines().forEach {
			paragraph.add(StyledText(it, 14F, PDType1Font.HELVETICA, fgColor))
			paragraph.add(NewLine())
		}
		
		val frame = getFrame(paragraph)
		
		document.add(frame, VerticalLayoutHint(align))
	}
	
	private fun append(image: BufferedImage, align: Alignment) {
		val frame = getFrame(ImageElement(image))
		
		document.add(frame, VerticalLayoutHint(align))
	}
	
	fun getFrame(inner: Drawable) = Frame(inner).apply {
		shape = RoundRect(radius)
		backgroundColor = bgColor
		setPadding(10F, 10F, 5F, 5F)
		setMargin(0F, 0F, 2F, 2F)
		
		if (inner is ImageElement) {
			backgroundColor = null
		}
	}
	
	fun close() {
		document.save(File("output/helloworld.pdf"))
	}
	
}