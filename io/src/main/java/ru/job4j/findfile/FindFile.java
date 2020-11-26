package ru.job4j.findfile;

import ru.job4j.search.SearchFiles;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class FindFile {

    public List<Path> listFiles(Path dir, Predicate<Path> predicate) throws IOException {
        SearchFiles search = new SearchFiles(predicate);
        Files.walkFileTree(dir, search);
        return search.getPaths();
    }

    public void writeFile(List<Path> paths, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Path value : paths) {
                    out.println(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(String[] args) throws IOException {
        ArgFind argFind = new ArgFind(args);
        if (argFind.valid()) {
                List<Path> paths = this.listFiles(Path.of(argFind.directory()),
                        new SelectPredicate(argFind, argFind.getMatch()).select());
                this.writeFile(paths, argFind.output());
        }

    }

    public static void main(String[] args) throws IOException {
            new FindFile().start(args);
    }
}
