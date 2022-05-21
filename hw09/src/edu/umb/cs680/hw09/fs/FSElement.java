package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;

public abstract class FSElement {
	protected ApfsDirectory parent;
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public ApfsDirectory getParent() {
		return parent;
	}

	public void setParent(ApfsDirectory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public abstract boolean isDirectory();
	public abstract boolean isFile();
	
}
