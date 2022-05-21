package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

	private ApfsElement target;

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target,
			String ownerName, LocalDateTime lastModifiedTime) {
		super(parent, name, size, creationTime, ownerName, lastModifiedTime);
		this.target = target;
	}

	public ApfsElement getTarget() {
		return this.target;
	}

	public int getTargetSize() {
		return target.getSize();
	}
	
	public boolean targetisDirectory() {
		return target.isDirectory();
	}

	public boolean targetisFile() {
		return target.isFile();
	}

	public boolean targetisLink() {
		return target.isLink();
	}

	public void setTarget(ApfsElement target) {
		this.target = target;
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return true;
	}
}