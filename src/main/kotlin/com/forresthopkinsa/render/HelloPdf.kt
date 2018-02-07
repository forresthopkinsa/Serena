package com.forresthopkinsa.render

import org.apache.pdfbox.pdmodel.font.PDType1Font
import rst.pdfbox.layout.elements.Document
import rst.pdfbox.layout.elements.Frame
import rst.pdfbox.layout.elements.Paragraph
import rst.pdfbox.layout.shape.RoundRect
import rst.pdfbox.layout.text.Alignment
import rst.pdfbox.layout.text.StyledText
import java.awt.Color
import java.io.File

class HelloPdf {
	
	private val document = Document(40F, 50F, 40F, 60F)
	private val fgColor = Color.WHITE
	private val bgColor = Color(86, 181, 111)
	private val radius = 13F
	
	fun append(text: String, align: Alignment) {
		val paragraph = Paragraph()
		paragraph.add(StyledText(text, 14F, PDType1Font.HELVETICA, fgColor))
		paragraph.alignment = align
		
		val frame = Frame(paragraph)
		frame.shape = RoundRect(radius)
		frame.backgroundColor = bgColor
		
		frame.setPadding(10F, 10F, 5F, 5F)
		frame.setMargin(0F, 0F, 2F, 2F)
		
		document.add(frame)
	}
	
	fun close() {
		document.save(File("helloworld.pdf"))
	}
	
}