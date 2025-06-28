package Task4;

import java.io.*;

public class ResultProcessor {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("marks.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                int total = m1 + m2 + m3;
                String result = (total / 3 >= 40) ? "Pass" : "Fail";

                writer.write(name + " - Total: " + total + " - Result: " + result);
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Results processed and written!");
        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        }
    }
}
