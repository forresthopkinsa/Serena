package com.forresthopkinsa.render

import org.apache.pdfbox.pdmodel.font.PDType1Font
import rst.pdfbox.layout.elements.Document
import rst.pdfbox.layout.elements.Paragraph
import java.io.File

class HigherPdf {

	val document = Document(40F, 50F, 40F, 60F)
	
	fun append(text: String) {
		val paragraph = Paragraph()
		paragraph.addText(text, 14F, PDType1Font.HELVETICA)
		document.add(paragraph)
	}
	
	fun close() {
		document.save(File("higherworld.pdf"))
	}

}