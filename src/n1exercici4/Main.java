package n1exercici4;

import java.io.*;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You need to provide a directory");
        } else {
            String path = args[0];
            File dir = new File(path);
            long lastModified = dir.lastModified();
            Date date = new Date(lastModified);
            sortTreeDirectory(dir, date);
        }

    }

    public static void sortTreeDirectory(File path, Date date) {
        if(path.isDirectory()) {
            writeDirectories("D: " + path + date);

            try (Stream<Path> stream = Files.list(Paths.get(path.getAbsolutePath()))) {
                stream.sorted().toList().forEach(pth -> {
                    File file = new File(String.valueOf(pth));
                    if(file.isFile() && (file.getAbsolutePath()).contains(".txt")) {
                        readTxt(file);
                    }
                    else if(file.isFile()) {
                        writeDirectories("  F: " + file + date);
                    } else {
                        sortTreeDirectory(file, date);
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void writeDirectories(String line) {

        try {
            FileWriter fw = new FileWriter("directories.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(line);
            bw.close();

        } catch (IOException e) {
            System.out.println("Could not write file");
        }
    }

    public static void readTxt(File text) {
        try {
            FileReader fr = new FileReader(text);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
    }
}