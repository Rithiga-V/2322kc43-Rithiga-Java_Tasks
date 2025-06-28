package Task3;

import java.io.*;

public class WriteFileExample {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Hello");
            writer.newLine();
            writer.write("World");
            writer.newLine();
            writer.close();
            System.out.println("file written!");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }
}