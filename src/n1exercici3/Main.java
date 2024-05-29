package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
                    if(file.isFile()) {
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
}