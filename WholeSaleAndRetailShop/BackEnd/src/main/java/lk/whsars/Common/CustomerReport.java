package lk.whsars.Common;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lk.whsars.DTO.CustomerRDto;
import lk.whsars.DTO.LowStockLevelDto;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerReport {

    String fileName = getCurrentDate() + "_" + getCurrentTime() + ".pdf";
    String FILE = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + fileName;

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    /*-------------------Generate Current Date -----------------*/
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String newDate = dateFormat.format(date);

        return newDate;
    }

    /*-------------------Generate Current Time -----------------*/
    public static String getCurrentTime() {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");

        return (sdf.format(cal.getTime()));

    }

    public void generateReport(){

    }
    public void generateCustomerReportPdf(List<CustomerRDto> CustomerRDto){


        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            createTable(document,CustomerRDto);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private  void addMetaData(Document document) {

        document.addTitle("Customer Report");

    }


    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Customer Report", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 3);

        document.add(preface);

    }

    private static void createTable(Document subCatPart,List<CustomerRDto> CustomerRDto) throws BadElementException {
        PdfPTable table1 = new PdfPTable(5);

        PdfPCell c1 = new PdfPCell(new Phrase("User Name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c1);

        c1 = new PdfPCell(new Phrase("NIC"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c1);

        c1 = new PdfPCell(new Phrase("Email"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c1);

        c1 = new PdfPCell(new Phrase("Type"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c1);


        c1 = new PdfPCell(new Phrase("Loyalty Points"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(c1);


        table1.setHeaderRows(1);

        for (CustomerRDto c:CustomerRDto
        ) {
            table1.addCell(c.getUserName());
            table1.addCell(c.getNic());
            table1.addCell(c.getEmail());
            table1.addCell(c.getType());
            table1.addCell(String.valueOf(c.getLoyaltyPoints()));

        }


        try {
            subCatPart.add(table1);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }



    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
