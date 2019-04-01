package as.project;

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.Map;
import me.tongfei.progressbar.*;

public class task_pt4 {

    public static void main(String[] args) {

        ProgressBarBuilder pbb = new ProgressBarBuilder()
                .setTaskName("Reading")
                .setUnit("MB", 1048576);

        Map<String, Integer> frequencies = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<String, Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                ProgressBar.wrap(new FileInputStream("url_response.txt"), pbb)
        ))) {
            String line;
            String words[];

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
        }
    }
}

