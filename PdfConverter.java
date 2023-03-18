package com.example.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfConverter {

    public static void main(String[] args) throws Exception {

        // Load input document
        PDDocument document = PDDocument.load(new File("input.docx"));

        // Create PDF renderer
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        // Render document to BufferedImage
        BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300);

        // Write BufferedImage to PDF
        FileOutputStream fileOutputStream = new FileOutputStream(new File("output.pdf"));
        ImageIO.write(bim, "pdf", fileOutputStream);

        // Close document
        document.close();
    }
}
