package com.company;
import me.tongfei.progressbar.*;

import java.io.*;
import java.util.Arrays;

public class task_pt2 {

    public static void main(String[] args) {
        BufferedReader br = null;
        long [] array = new long[100];
        Arrays.fill(array, 0);

        try {
            br = new BufferedReader(new FileReader("server_response.txt"));
            String line;

            while((line = br.readLine()) != null) {
                int result = (int) (Float.valueOf(line) / 0.05);

                for (int i = 0; i < array.length; i++) {
                    if (result == i) {
                        array[i] += 1;
                    }
                }

            }
            } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e);
            }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        }
    }
}
