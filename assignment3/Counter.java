package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counter {
    private final char lookFor;
    private FileReader dFile = new FileReader("C:\\Users\\jose9\\Desktop\\Test.txt");

    Counter(FileReader file, char lookFor) throws IOException {
        file = dFile;
        this.lookFor = lookFor;
    }

    public String readFile() throws IOException {
        String everything;
        try (BufferedReader br = new BufferedReader(dFile)) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        return everything;
    }

    public int count(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == lookFor) {
                count++;
            }
        }
        return count;
    }
}
