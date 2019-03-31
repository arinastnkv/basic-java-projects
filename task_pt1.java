package com.company;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_pt1 {

    public static void main(String[] args) {

        try{
            FileInputStream logfile = new FileInputStream("nginx.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(logfile));
            String line;

            File file = new File("server_response.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            Pattern p = Pattern.compile("\\d{1,2}\\.(?!168)\\d{3}");

            while ((line = br.readLine()) != null) {
                Matcher m1 = p.matcher(line);
                while (m1.find()) {
                    pw.println(m1.group());
                }
            }

            pw.close();
            logfile.close();
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
