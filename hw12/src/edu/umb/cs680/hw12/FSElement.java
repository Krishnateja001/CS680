package edu.umb.cs680.hw12;

import java.time.LocalDateTime;



public abstract class FSElement {
    private ApfsDirectory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    public FSElement(String name, int size, LocalDateTime creationTime,ApfsDirectory parent ) {
        this.name= name;
        this.size=size;
        this.creationTime=creationTime;
        this.parent = parent;
    }

    public ApfsDirectory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setParent(ApfsDirectory parent) {
        this.parent = parent;

    }

    protected abstract  boolean isDirectory();

    protected abstract  boolean isFile();

    protected abstract  boolean isLink();

}