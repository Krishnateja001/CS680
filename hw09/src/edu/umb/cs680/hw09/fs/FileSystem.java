package edu.umb.cs680.hw09.fs;

import java.util.LinkedList;

public abstract class FileSystem {
	protected String name;
	protected int capacity;
	protected int id;
	private LinkedList<FSElement> rootDirs = new LinkedList<>();
	
	public FSElement init(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && capacity >= root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		}else {
			return null;
		}
	}
	
	protected abstract FSElement createDefaultRoot();
	
	protected void setRoot(FSElement root) {
		rootDirs.add(root);
	}

	protected String getName() {
		return name;
	}

	protected int getCapacity() {
		return capacity;
	}

	protected int getId() {
		return id;
	}

	protected LinkedList<FSElement> getRootDirs() {
		return rootDirs;
	}
	
}
