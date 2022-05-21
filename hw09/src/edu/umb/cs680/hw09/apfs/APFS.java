package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

public class APFS extends FileSystem{
	private static APFS instance = null;

	private APFS(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public static APFS getApfs() {
		if (instance == null) {
			instance = new APFS("SingletonAPFS", 1000);
		}
		return instance;
	}
	
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "default_root", 200, LocalDateTime.now(), "default owner", "default time");
	}
	
	public ApfsDirectory getRootDir() {
		return (ApfsDirectory)this.getRootDirs().get(0);
	}

}
