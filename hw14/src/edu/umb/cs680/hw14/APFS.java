package edu.umb.cs680.hw14;

import java.time.LocalDateTime;



public class APFS extends FileSystem {



    private static APFS instance = null;

    private ApfsDirectory root;

    public static APFS getInstance() {
        if (instance == null)
            instance = new APFS();
        return instance;
    }

    protected FSElement createDefaultRoot() {
        LocalDateTime localTime = LocalDateTime.now();
        root = new ApfsDirectory( "root", 0, localTime,null, "APFS", localTime);
        return root;
    }

    public ApfsDirectory getRootDirs() {
        return root;
    }

}