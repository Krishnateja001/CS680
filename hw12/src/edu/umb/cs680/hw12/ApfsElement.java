package edu.umb.cs680.hw12;

import java.time.LocalDateTime;



public abstract class ApfsElement extends FSElement {

    private String ownerName;
    private LocalDateTime modifiedTime;

    public ApfsElement( String name, int size, LocalDateTime createdTime, ApfsDirectory parent,String ownerName,
                        LocalDateTime modifiedTime) {
        super( name, size, createdTime,parent);
        this.ownerName = ownerName;
        this.modifiedTime = modifiedTime;
    }


    public boolean isDirectory() {
        return false;
    };

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return false;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}