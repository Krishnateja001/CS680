package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
	private LinkedList<Directory> rootDirs = new LinkedList<Directory>();

	private FileSystem() {
	}

	private static FileSystem fileSystem = null;

	public static FileSystem getFileSystem() {
		if (fileSystem == null)
			fileSystem = new FileSystem();
		return fileSystem;
	}

	public LinkedList<Directory> getRootDirs() {
		return rootDirs;
	}

	public void addRootDir(Directory dir) {
		this.rootDirs.add(dir);
	}
}