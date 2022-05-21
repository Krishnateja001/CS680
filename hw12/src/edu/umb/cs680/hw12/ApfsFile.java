package edu.umb.cs680.hw12;

import java.time.LocalDateTime;



public class ApfsFile extends ApfsElement {

    public ApfsFile( String name, int size, LocalDateTime createdTime,ApfsDirectory parent,String ownerName
            , LocalDateTime modifiedTime) {
        super( name, size, createdTime,parent,ownerName,modifiedTime);
        parent.appendChild(this);
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return true;
    }

    public boolean isLink() {
        return false;
    }

}