package lk.whsars.Common;

import lk.whsars.entity.Item;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class BarCode {


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

    /*--------------------- To generate the barcode pdf -------------------------------------*/

    public static void generateBarcodePdf(Item code,int itemQty) {

        System.out.println("kkkkk"+code.getItemName());
        System.out.println("kkkkk"+itemQty);


//        for (Item item : itemList) {
//            System.out.println("item " + item.getBarCode() );
//            System.out.println("item " + item.getRetailPrice() );
//        }

        String fileName = "BAR_" + getCurrentDate() + "_" + getCurrentTime() + ".pdf";
        String filePath = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + fileName;

        Document doc = new Document();
        PdfWriter docWriter = null;

        try {
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.addAuthor("BarCode");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("");
            doc.addTitle("");
            doc.setPageSize(PageSize.A4);
            doc.open();
            PdfContentByte cb = docWriter.getDirectContent();

            PdfPTable pdfPTable = new PdfPTable(4);

            /*
             * PdfPCell pdfCell1 = new PdfPCell(new Phrase("")); PdfPCell pdfCell2 = new
             * PdfPCell(new Phrase("")); PdfPCell pdfCell3 = new PdfPCell(new Phrase(""));
             * PdfPCell pdfCell4 = new PdfPCell(new Phrase(""));
             *
             * pdfPTable.addCell(pdfCell1); pdfPTable.addCell(pdfCell2);
             * pdfPTable.addCell(pdfCell3); pdfPTable.addCell(pdfCell4);
             */

            //float paddingCount = 20;
            //int hopCount = 1;

//            for (Item code : itemList) {
            for(int i=0 ;i<itemQty ;i++) {
                Font cjk = new Font();

                Barcode128 code128 = new Barcode128();
                code128.setCode(code.getBarCode().trim());
                code128.setCodeType(Barcode128.CODE128);
                Image code128Image = code128.createImageWithBarcode(cb, null, null);

                code128Image.scalePercent(180);

                if (code.getBarCode() == null || code.getBarCode() == "") {
                    PdfPCell cell = new PdfPCell();

                    pdfPTable.addCell(cell);
                } else {
                    PdfPCell cell = new PdfPCell();

                    Paragraph p = new Paragraph();

                    //System.out.println("Round OFf " + Math.round(code.getPrice() * 100.0) / 100.0);

                    p.add(new Chunk(code128Image, 0, 0));
                    p.add(new Phrase("\t\t\nRs: " + code.getRetailPrice() + "0",
                            new Font(Font.FontFamily.HELVETICA, 10)));


                    // cell.setBorderWidth(5);

						/*
						cell.setPaddingLeft(13);

						if (hopCount > 20) {
							cell.setPaddingTop(9);
						} else if (hopCount > 4) {
							cell.setPaddingTop(8);
						} else {
							cell.setPaddingTop(paddingCount);
						}

						++hopCount;
						if (hopCount == 85) {
							hopCount = 1;
						}
						*/
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.addElement(p);
                    cell.setPaddingTop(20);
                    cell.setPaddingLeft(8);

                    pdfPTable.addCell(cell);
                }

                pdfPTable.setWidthPercentage(110);

//            }
            }
            doc.add(pdfPTable);
            doc.close();

            /*
             * BarcodeEAN codeEAN = new BarcodeEAN(); codeEAN.setCode(myString.trim());
             * codeEAN.setCodeType(BarcodeEAN.EAN13); Image codeEANImage =
             * code128.createImageWithBarcode(cb, null, null);
             * codeEANImage.setAbsolutePosition(10, 600); codeEANImage.scalePercent(125);
             * doc.add(codeEANImage);
             */

        } catch (Exception e) {
            System.out.println("Exception in generateItemCodeBarcodePdf : " + e);
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (docWriter != null) {
                docWriter.close();
            }
        }
    }




    /////////////////////////////////////////////////////////////////

//    public static void generateBarcodePdf(List<Item> itemList) {
//
//        System.out.println("kkkkk"+itemList);
//
//        for (Item item : itemList) {
//            System.out.println("item " + item.getBarCode() );
//            System.out.println("item " + item.getRetailPrice() );
//        }
//
//        String fileName = "BAR_" + getCurrentDate() + "_" + getCurrentTime() + ".pdf";
//        String filePath = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + fileName;
//
//        Document doc = new Document();
//        PdfWriter docWriter = null;
//
//        try {
//            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(filePath));
//            doc.addAuthor("BarCode");
//            doc.addCreationDate();
//            doc.addProducer();
//            doc.addCreator("");
//            doc.addTitle("");
//            doc.setPageSize(PageSize.A4);
//            doc.open();
//            PdfContentByte cb = docWriter.getDirectContent();
//
//            PdfPTable pdfPTable = new PdfPTable(4);
//
//            /*
//             * PdfPCell pdfCell1 = new PdfPCell(new Phrase("")); PdfPCell pdfCell2 = new
//             * PdfPCell(new Phrase("")); PdfPCell pdfCell3 = new PdfPCell(new Phrase(""));
//             * PdfPCell pdfCell4 = new PdfPCell(new Phrase(""));
//             *
//             * pdfPTable.addCell(pdfCell1); pdfPTable.addCell(pdfCell2);
//             * pdfPTable.addCell(pdfCell3); pdfPTable.addCell(pdfCell4);
//             */
//
//            //float paddingCount = 20;
//            //int hopCount = 1;
//
//            for (Item code : itemList) {
//                Font cjk = new Font();
//
//                Barcode128 code128 = new Barcode128();
//                code128.setCode(code.getBarCode().trim());
//                code128.setCodeType(Barcode128.CODE128);
//                Image code128Image = code128.createImageWithBarcode(cb, null, null);
//
//                code128Image.scalePercent(180);
//
//                if (code.getBarCode() == null || code.getBarCode() == "") {
//                    PdfPCell cell = new PdfPCell();
//
//                    pdfPTable.addCell(cell);
//                } else {
//                    PdfPCell cell = new PdfPCell();
//
//                    Paragraph p = new Paragraph();
//
//                    //System.out.println("Round OFf " + Math.round(code.getPrice() * 100.0) / 100.0);
//
//                    p.add(new Chunk(code128Image, 0, 0));
//                    p.add(new Phrase("\t\t\nRs: " +code.getRetailPrice() +"0",
//                            new Font(Font.FontFamily.HELVETICA, 10)));
//
//
//
//                    // cell.setBorderWidth(5);
//
//						/*
//						cell.setPaddingLeft(13);
//
//						if (hopCount > 20) {
//							cell.setPaddingTop(9);
//						} else if (hopCount > 4) {
//							cell.setPaddingTop(8);
//						} else {
//							cell.setPaddingTop(paddingCount);
//						}
//
//						++hopCount;
//						if (hopCount == 85) {
//							hopCount = 1;
//						}
//						*/
//                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell.addElement(p);
//                    cell.setPaddingTop(20);
//                    cell.setPaddingLeft(8);
//
//                    pdfPTable.addCell(cell);
//                }
//
//                pdfPTable.setWidthPercentage(110);
//
//            }
//
//            doc.add(pdfPTable);
//            doc.close();
//
//            /*
//             * BarcodeEAN codeEAN = new BarcodeEAN(); codeEAN.setCode(myString.trim());
//             * codeEAN.setCodeType(BarcodeEAN.EAN13); Image codeEANImage =
//             * code128.createImageWithBarcode(cb, null, null);
//             * codeEANImage.setAbsolutePosition(10, 600); codeEANImage.scalePercent(125);
//             * doc.add(codeEANImage);
//             */
//
//        } catch (Exception e) {
//            System.out.println("Exception in generateItemCodeBarcodePdf : " + e);
//        } finally {
//            if (doc != null) {
//                doc.close();
//            }
//            if (docWriter != null) {
//                docWriter.close();
//            }
//        }
//    }
}
