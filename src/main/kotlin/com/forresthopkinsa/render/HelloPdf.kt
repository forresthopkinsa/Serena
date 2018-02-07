package com.forresthopkinsa.render

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font

class HelloPdf {
	
	val document = PDDocument()
	val page = PDPage()
	val contentStream = PDPageContentStream(document, page)
	
	init {
		val font = PDType1Font.HELVETICA
		document.addPage(page)
		contentStream.beginText()
		contentStream.setFont(font, 14F)
		contentStream.setLeading(14.5)
		contentStream.newLineAtOffset(40F, 730F)
	}
	
	fun append(text: String) {
		contentStream.showText(text)
		contentStream.newLine()
	}
	
	fun close() {
		contentStream.endText()
		contentStream.close()
		document.save("helloworld.pdf")
		document.close()
	}
}