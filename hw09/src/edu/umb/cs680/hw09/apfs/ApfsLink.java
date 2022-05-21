package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsFSElement{
	private ApfsFSElement target;

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			String lastModifiedTime, ApfsFSElement target) {
		super(parent, name, size, creationTime, ownerName, lastModifiedTime);
		this.target = target;
	}

	public boolean isLink() {
		return true;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}
	
	public ApfsFSElement getTarget() {
		return target;
	}

	public void setTarget(ApfsFSElement target) {
		this.target = target;
	}

	public void accept(ApfsFSVisitor v) {
		v.visit(this);
	}

}
