package n1exercici1;

import java.io.File;
import java.io.IOException;
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
            sortFiles(dir);
        }
    }

    public static void sortFiles(File path) {
        try (Stream<Path> stream = Files.list(Paths.get(path.getAbsolutePath()))) {
            stream.sorted().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}