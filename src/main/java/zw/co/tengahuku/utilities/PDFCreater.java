package zw.co.tengahuku.utilities;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import javax.swing.text.StyleConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PDFCreater {
	
	   private OutputStream fos;
	   private PdfWriter writer;
	   private PdfDocument pdfdoc;
	   private Document doc;
	   private String filename;
	
	   
	   public void printPDF() throws IOException{
		   		
		      fos = new FileOutputStream(new File(filename));
		      writer = new PdfWriter(fos);
		      pdfdoc = new PdfDocument(writer);
		      doc = new Document(pdfdoc);
		      createSimpleTextReport();
		      createTabularReport();
		      doc.close();
		      writer.close();
		   
	   }
	
	
	public void createSimpleTextReport() {
		doc.add(new Paragraph("Available Processors: " + Runtime.getRuntime().availableProcessors() + " Cores"));
		doc.add(new Paragraph("Free Memory :" + Runtime.getRuntime().freeMemory() + " bytes"));
		doc.add(new Paragraph("Maximum Memory used by JVM :" + Runtime.getRuntime().maxMemory() + " bytes"));
		doc.add(new Paragraph("Total Memory available :" + Runtime.getRuntime().totalMemory() + " bytes"));
		doc.add(new Paragraph("File System Roots"));
		File roots[] = File.listRoots();
		List list = new List();
		for (File root : roots) {
			list.add(new ListItem("File system root: " + root.getAbsolutePath()))
					.add(new ListItem("Total space: " + root.getTotalSpace() + " bytes"))
					.add(new ListItem("Free space: " + root.getFreeSpace() + " bytes"))
					.add(new ListItem("Usable space: " + root.getUsableSpace() + " bytes"));
			doc.add(list);
		}
	}
	
	private void createTabularReport(){
		   Table table=new Table(3);
		   table.addHeaderCell(new Cell().add(new
		      Paragraph("Caption")));
		   table.addHeaderCell(new Cell().add(new
		      Paragraph("Value")));
		   table.addHeaderCell(new Cell().add(new
		      Paragraph("Unit")));
		   table.addCell(new Cell().add(new
		      Paragraph("Available Processors")));
		   table.addCell(new Cell().add(new
		      Paragraph(String.valueOf(Runtime.getRuntime()
		      .availableProcessors()))));
		   table.addCell(new Cell().add(new
		      Paragraph("")));
		   table.addCell(new Cell().add(new
		      Paragraph("Free Memory")));
		   table.addCell(new Cell().add(new
		      Paragraph(String.valueOf(Runtime.getRuntime()
		      .freeMemory()))));
		   table.addCell(new Cell().add(new
		      Paragraph("bytes")));
		   table.addCell(new Cell().add(new
		      Paragraph("Maximum Memory")));
		   table.addCell(new Cell().add(new
		      Paragraph(String.valueOf(Runtime.getRuntime()
		      .maxMemory()))));
		   table.addCell(new Cell().add(new
		      Paragraph("bytes")));
		   File roots[] = File.listRoots();
		   for (File root : roots) {
		      table.addCell(new Cell().add(new
		         Paragraph("File System root")));
		      table.addCell(new Cell().add(new
		         Paragraph(root.getAbsolutePath())));
		      table.addCell(new Cell().add(new
		         Paragraph("bytes")));
		      table.addCell(new Cell().add(new
		         Paragraph("Total space")));
		      table.addCell(new Cell().add(new Paragraph(
		         String.valueOf(root.getTotalSpace()))));
		      table.addCell(new Cell().add(new
		         Paragraph("bytes")));
		      table.addCell(new Cell().add(new
		         Paragraph("Free space")));
		      table.addCell(new Cell().add(new Paragraph(
		         String.valueOf(root.getFreeSpace()))));
		      table.addCell(new Cell().add(new
		      Paragraph("bytes")));
		      table.addCell(new Cell().add(new
		         Paragraph("Usable space")));
		      table.addCell(new Cell().add(new Paragraph(
		         String.valueOf(root.getUsableSpace()))));
		      table.addCell(new Cell().add(new
		         Paragraph("bytes")));
		   }
		   doc.add(table);
		}

}