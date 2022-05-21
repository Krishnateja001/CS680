package edu.umb.cs680.hw09.apfs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor{
	private LinkedList<ApfsFile> files = new LinkedList<>();
	
	public void visit(ApfsLink link) {
		return;
	}

	public void visit(ApfsDirectory dir) {
		return;
	}

	public void visit(ApfsFile file) {
		files.add(file);
	}

	public LinkedList<ApfsFile> getFiles() {
		return files;
	}

}
