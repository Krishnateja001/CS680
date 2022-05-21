package edu.umb.cs680.hw12;

import java.time.LocalDateTime;



public class ApfsLink extends ApfsElement {
    public ApfsElement target;

    public ApfsLink(String name, int size,LocalDateTime creationTime,ApfsDirectory parent
            ,String ownerName, LocalDateTime modifiedTime, ApfsElement target) {
        super(name,size,creationTime,parent, ownerName, modifiedTime);
        this.target = target;
        parent.appendChild(this);
    }


    public boolean isDirectory() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public boolean isFile() {
        return false;
    }

    public int getTargetSize() {
        if (target.isDirectory()) {
            return ((ApfsDirectory) target).getTotalSize();
        } else if (target.isLink()) {
            return 0;
        } else {
            return target.getSize();
        }
    }

    public ApfsElement getTarget() {
        return this.target;
    }
}