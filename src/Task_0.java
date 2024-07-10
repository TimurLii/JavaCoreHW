import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Task_0 {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        writeFile(arr);
        System.out.println(Arrays.toString(readFile("src/test/Task_01.txt")));


    }

    public static void writeFile(int[] arr) throws IOException {

        try (FileWriter fw = new FileWriter("src/kaka/Task_0.txt")) {
            fw.write(String.valueOf(writeZero(arr)));
        }
    }

    public static StringBuilder writeZero(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append('0');
        }
        return sb;
    }

    public static int[] readFile(String path) {
        ArrayList<Integer> arr = new ArrayList<>();
        try (FileReader fr = new FileReader(path)) {
            int n;
            boolean flag = true;
            while ((n = fr.read()) != -1) {
                char temp = (char) n;
                if (temp == '0' && flag) {
                    flag = false;
                } else if (temp != '0' || (temp == '0' && !flag)){
                    flag = true;
                    arr.add(Integer.parseInt(String.valueOf(temp)));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] newArr = new int[arr.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr.get(i);
        }
        return newArr;
    }
}
