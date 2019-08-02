package assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AppendtoFile {
    public static void main(String[] args) {
        try {
            String test = "Testing. This was generated after compiling. ";
            String dirPath = "C:\\Users\\jose9\\Desktop\\";
            String file = "Test.txt";
            File directory = new File(dirPath);
            File newFile = new File(file);
            File actualFile = new File(directory, file);
                String absolute = actualFile.getAbsolutePath();
                System.out.println("Original  path: " + actualFile.getPath());
                System.out.println("Absolute  path: " + absolute);

                FileWriter fileWriter = new FileWriter(actualFile.getPath(), true);

                BufferedWriter syncString = new BufferedWriter(fileWriter);
                syncString.write(test);
                syncString.close();
                System.out.println("Successfully appended!");
        }
        catch(IOException e){
                e.printStackTrace();
            }
        System.out.println("Check to see that the file successfully appended text!");
        }
    }