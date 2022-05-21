package edu.umb.cs680.hw09.apfs;

public interface ApfsFSVisitor {
	
	public abstract void visit(ApfsLink apfsLink);
	public abstract void visit(ApfsDirectory apfsDirectory);
	public abstract void visit(ApfsFile apfsFile);

}
