package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;

public abstract class ApfsFSElement extends FSElement{
	private String ownerName;
	private String lastModifiedTime;
	
	public abstract boolean isLink();
	public abstract void accept(ApfsFSVisitor v);

	public ApfsFSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, String lastModifiedTime) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

}
