import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


public class Main {

    public static void main(String[] args) throws IOException, DocumentException {

        boolean passCheck = false;

        String toFile = "";
        String passInput = "";
        Scanner input = new Scanner(System.in);

        while(!passCheck) {
            System.out.println("Enter password");
            passInput = input.nextLine();

            Password yourPass = new Password(passInput);
            passCheck = yourPass.check();

            if (passCheck)
                System.out.println("Password accepted, type your message");
            else {
                System.out.println("Password rejected. Type '1' to continue");

                while (!"1".equals(input.nextLine())) {
                    System.out.println("Control sign rejected. Type '1' to continue");
                }
            }
        }

        Stack<String> stack = new Stack<String>();

//        Push message to stack
        do {
            stack.push(toFile);
            toFile = input.nextLine();
        }while (!"exit".equals(toFile));

//        Prepare to create txt
        String path = System.getProperty("user.home") + "/Pulpit/PassFile.txt";
        File file = new File(path);
        FileWriter fr = new FileWriter(file, true);

//        Prepare to create PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextPDF.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        String toPDF = "";
        Phrase phrase = new Phrase();

//        write to both files
        while (!stack.isEmpty()) {
            toPDF = stack.pop();
            fr.write(toPDF + "\n");
            Chunk chunk = new Chunk(toPDF+"\n", font);
            phrase.add(chunk);
        }

        document.add(phrase);
        fr.close();
        document.close();
    }
}