package DESIGNPATTERN;
interface Document {
    void open();
}

// Word Document
class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Word Document Opened");
    }
}

// PDF Document
class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("PDF Document Opened");
    }
}

// Excel Document
class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Excel Document Opened");
    }
}


// Abstract Factory
abstract class DocumentFactory {

    public abstract Document createDocument();

}


// Concrete Factory for Word
class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }

}


// Concrete Factory for PDF
class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }

}


// Concrete Factory for Excel
class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }

}


// Test Class
public class FactoryMethodPattern {

    public static void main(String[] args) {

        DocumentFactory wordFactory =
                new WordDocumentFactory();

        DocumentFactory pdfFactory =
                new PdfDocumentFactory();

        DocumentFactory excelFactory =
                new ExcelDocumentFactory();

        Document word =
                wordFactory.createDocument();

        Document pdf =
                pdfFactory.createDocument();

        Document excel =
                excelFactory.createDocument();

        word.open();

        pdf.open();

        excel.open();

    }
}