package ru.job4j.search;

import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.io.IOException;

public class SearchFiles implements FileVisitor<Path>  {
    private final String ext;
    private final List<Path> paths = new ArrayList<>();

    public SearchFiles(String ext) {
        this.ext = ext;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)  {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toFile().getName().endsWith(ext)) {
            paths.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return paths;
    }

}
