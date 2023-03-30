package AiSD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StoogeSort2 {
       public static void stoogesort(int arr[], int l, int h){

            if (l >= h) {
                return;
            }

            if (arr[l] > arr[h]) {
                int t = arr[l];
                arr[l] = arr[h];
                arr[h] = t;
            }

            if (h-l+1 > 2) {
                int t = (h-l+1) / 3;
                stoogesort(arr, l, h-t);
                stoogesort(arr, l+t, h);
                stoogesort(arr, l, h-t);
            }
        }

        public static void main(String args[]) throws IOException {
            int arr[] = {2, 4, 5, 3, 1};
            int n = arr.length;

            stoogesort(arr, 0, n-1);
            File file = new File("input.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("input.txt");
            for (int i = 0; i < Math.random()*50 + 50; i++) {
                fileWriter.write((int) (Math.random()* Integer.MAX_VALUE)
                        + "," + (int) (Math.random()* Integer.MAX_VALUE)
                        + "," + (int) (Math.random()*Integer.MAX_VALUE - Integer.MAX_VALUE/2));
                for (int j = 0; j < Math.random()*9900 + 99; j++) {
                    fileWriter.write("," + (int) (Math.random()*Integer.MAX_VALUE)
                            + "," + (int) (Math.random()*Integer.MAX_VALUE)
                            + "," + (int) (Math.random()*Integer.MAX_VALUE - Integer.MAX_VALUE/2));
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()){
                String[] str = scanner.nextLine().split(",");
                int[] numbers = new int[str.length];
                for (int i = 0; i < str.length; i++) {
                    numbers[i] = Integer.parseInt(str[i]);
                }
                stoogesort(numbers, 0, numbers.length - 1);
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
                }
                System.out.println("/n");
            }
        }
    }




