package choijungyoon;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;  

public class File {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
         FileWriter fw = new FileWriter("20191016-������.txt");
         fw.write(System.getProperties().toString());
         fw.close();
      }
      catch(IOException e) {
         e.printStackTrace();
         System.out.println("File ���⿡ �����߽��ϴ�.");
      }
   }

}