package as.project;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map;
import me.tongfei.progressbar.*;

public class task_pt4 {

    public static void main(String[] args) {

        BufferedReader br = null;
        Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<String, Integer>();

        try {
            br = new BufferedReader(new FileReader("url_response.txt"));
            String line;
            String words[] = null;

            while ((line = br.readLine()) != null) {
                words = line.split(" ");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        Integer frequency = frequencies.get(word);

                        if (frequency == null) {
                            frequency = 0;
                        }

                        ++frequency;
                        frequencies.put(word, frequency);
                    }
                }
                }

            frequencies.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

            reverseSortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
            //}
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e);
            }


        }
    }
}

