package as.project;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class task_pt3 {

    public static void main(String[] args) {
	// write your code here
        try{
            FileInputStream logfile = new FileInputStream("nginx.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(logfile));
            String line;
            String cvsSplitBy = ",";


            File file = new File("url_response.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);

            boolean firstLine = true;

            //List<String> lines = new ArrayList<String>();

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                //Matcher m1 = p.matcher(line);
                //while (m1.find()) {
                  //  pw.println(m1.group());
                String[] url = line.split(cvsSplitBy);
                if (!url[url.length - 4].isEmpty()) {
                    if (((Float.valueOf(url[url.length - 4])) < 0.050)) {
                        //lines.add(url[url.length - 6] + url[url.length - 5]);
                        pw.println(url[url.length - 6] + url[url.length - 5]);
                    }
                }

                }
            //}

            pw.close();
            logfile.close();
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }


    }
}
