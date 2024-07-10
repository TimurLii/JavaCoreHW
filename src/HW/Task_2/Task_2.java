package HW.Task_2;

import java.io.FileOutputStream;
import java.io.IOException;

public class Task_2 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 2, 0, 2, 0, 1, 3};
        inBin(arr);
//        print(arr);
    }

    private static void inBin(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num |= (arr[i] & 0x3) << (2 * i);
        }

        try (FileOutputStream fos = new FileOutputStream("src/HW/Task_2/game.bin")) {
            fos.write(new byte[]{
                    (byte) (num & 0xFF),
                    (byte) ((num >> 8) & 0xFF),
                    (byte) ((num >> 16) & 0xFF)
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            char ch;
            switch (arr[i]) {
                case 0:
                    ch = '.';
                    break;
                case 1:
                    ch = 'x';
                    break;
                case 2:
                    ch = 'o';
                    break;
                default:
                    ch = '?';
                    break;
            }
            System.out.print(ch + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}
