package HW.Task_1;

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        backUp("src/HW/Task_1/1", "src/HW/Task_1/2");
    }

    public static void backUp(String path, String backUpPath) throws IOException {
        File file = new File(backUpPath );
        if (file.mkdirs()) {
            for (File f : new File(path).listFiles()) {
                if (!f.mkdirs()) {
                    fileWriter(f, file);
                }
            }
        }
    }

    public static StringBuilder readFile(File file) {
        StringBuilder textFile = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            textFile.append(br.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textFile;
    }

    private static void fileWriter(File f, File file) throws IOException {
        try (FileWriter fw = new FileWriter(String.format(file.getAbsolutePath() + "\\" + f.getName()))) {
            fw.write(String.valueOf(readFile(f)));
        }
    }
}