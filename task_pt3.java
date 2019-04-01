package as.project;


import java.io.*;
import java.io.BufferedReader;
import me.tongfei.progressbar.*;

public class task_pt3 {

    public static void main(String[] args) {

        ProgressBarBuilder pbb = new ProgressBarBuilder()
                .setTaskName("Reading")
                .setUnit(" MB", 1048576);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(ProgressBar.wrap(new FileInputStream("nginx.log"), pbb)))) {
            String line;
            String cvsSplitBy = ",";


            File file = new File("url_response.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);

            boolean firstLine = true;


            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] url = line.split(cvsSplitBy);
                if (!url[url.length - 4].isEmpty()) {
                    if (((Float.valueOf(url[url.length - 4])) < 0.050)) {
                        pw.println(url[url.length - 6] + url[url.length - 5]);
                    }
                }
                }

            pw.close();
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
