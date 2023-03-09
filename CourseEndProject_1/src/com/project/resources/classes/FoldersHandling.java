package com.project.resources.classes;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FoldersHandling {
	private File directory;

	public FoldersHandling(String path) {
		this.directory = new File(path);
	}

	public List<File> listAllFiles() throws NullPointerException {
		List<File> files = Arrays.asList(this.directory.listFiles());
		return files;
	}

	public File getDirectory() {
		return this.directory;
	}
}
