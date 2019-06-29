package pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	public static void main(String[] args) {
		Document document = new Document();
		String fileName = "image" + System.currentTimeMillis();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName+".pdf"));
			document.open();
			
			Image image1 = Image.getInstance("D:/A_TeachingMaterial/3.HighJava/workspace/MakeIT/src/pdf/NBNB.pdf");
			image1.scaleAbsolute(250f, 150f);
			document.add(image1);
			
			document.add(new Paragraph("mungchi is love..."));
			Desktop.getDesktop().open(new File(fileName+".pdf"));
		} catch(DocumentException de) {
			System.err.println(de.getMessage());
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}
}
