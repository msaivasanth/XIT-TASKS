// Copy text file to another text file

import java.util.*;
import java.io.*;

public class Assignment2 {
    public static void helper(File src, File dst) throws Exception {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dst);

        try {
            int n;

            while ((n = in.read()) != -1) {
                out.write(n);
            }
        }
        finally {
            if(in != null) in.close();

            if(out != null) out.close();
        }

        System.out.println("File Copied Successfully");
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the source filename to read: ");
        String source = s.nextLine();

        File src = new File(source);

        System.out.print("Enter the destination filename to write: ");
        String destination = s.nextLine();

        File dst = new File(destination);

        try {
            helper(src, dst);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
