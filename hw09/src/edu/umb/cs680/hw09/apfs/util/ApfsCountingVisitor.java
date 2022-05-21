package edu.umb.cs680.hw09.apfs.util;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsCountingVisitor implements ApfsFSVisitor{
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	public void visit(ApfsLink link) {
		linkNum++;
	}

	public void visit(ApfsDirectory dir) {
		dirNum++;
	}

	public void visit(ApfsFile file) {
		fileNum++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

}
