package ru.job4j.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Search {

	public static void main(String[] args) throws IOException {
		Path startDir = Paths.get("/home/alex/project/job4j/io");
		search(startDir, "html").forEach(System.out::println);
	}
	
	public static List<Path> search(Path root, String ext) throws IOException {
		SearchFiles searcher = new SearchFiles(ext);
		Files.walkFileTree(root, searcher);
		return searcher.getPaths();
	}

}
