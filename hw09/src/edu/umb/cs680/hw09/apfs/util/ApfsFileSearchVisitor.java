package edu.umb.cs680.hw09.apfs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsFileSearchVisitor implements ApfsFSVisitor{
	private String fileName;
	private LinkedList<ApfsFile> foundFiles;
	
	public ApfsFileSearchVisitor(String fileName) {
		foundFiles = new LinkedList<>();
		this.fileName = fileName;
	}
	
	public void visit(ApfsLink link) {
		return;
	}

	public void visit(ApfsDirectory dir) {
		return;
	}

	public void visit(ApfsFile file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LinkedList<ApfsFile> getFoundFiles() {
		return foundFiles;
	}

}
