package p0;

import java.io.File;
import net.sourceforge.tess4j.*;

public class TesseractExample {

    public static void main(String[] args) {
    	
        File imageFile = new File("sample4.png");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        
        // For Chinese
        instance.setLanguage("chi_tra");
        
        // Set datapath
//        instance.setDatapath("C:\\Users\\User\\eclipse-workspace\\Java Software Development Spring\\Project\\20240522\\tessdata"); // path to tessdata directory
        instance.setDatapath("C:\\Users\\User\\eclipse-workspace\\Java Software Development Spring\\Project\\20240522\\tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}