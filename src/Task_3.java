import java.io.*;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        changeFile('а', "src/test/Task_3.txt");

    }

    public static String makeString(String path) throws IOException {

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }

    public static void changeFile(char ch, String path) throws IOException {
        String string = makeString(path);
        string = string.replaceAll(String.valueOf(ch), " ");
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(string);

        }

    }
}
