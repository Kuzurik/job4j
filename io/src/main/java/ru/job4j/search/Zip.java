package ru.job4j.search;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Kuzura Alexandr
 * 13.07.2020
 * Main Pack Files
 */

public class Zip {

    /**
     * Packing files to zip
     * @param sources List of paths to pack
     * @param target output file name
     */

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method
     * @param args list of arguments
     */

    public static void main(String[] args) {
        Zip zip = new Zip();
        ArgZip argZip = new ArgZip(args);
        List<Path> paths = Search.search(Path.of(argZip.directory()), argZip.exclude());
        zip.packFiles(paths, new File(argZip.output()));
    }

}
