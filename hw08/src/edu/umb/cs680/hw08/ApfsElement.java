package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsElement extends FSElement {
	
	private String ownerName;
	private LocalDateTime lastModifiedTime;
	private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime lastModifiedTime) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModifiedTime = lastModifiedTime;
	}

	public LinkedList<ApfsElement> getChildren() {
		return this.ApfsChildren;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public LocalDateTime getlastModifiedDate() {
		return lastModifiedTime;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setlastModifiedDate(LocalDateTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
	public void appendChild(FSElement child) {
		this.ApfsChildren.add((ApfsElement) child);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}
}