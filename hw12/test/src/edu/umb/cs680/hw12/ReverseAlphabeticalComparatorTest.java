package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class ReverseAlphabeticalComparatorTest {

    LocalDateTime date = LocalDateTime.now();
    APFS getInstance = APFS.getInstance();
    ApfsDirectory root = (ApfsDirectory) getInstance.initFileSystem("APFSDirectory", 2);
    ApfsDirectory home = new ApfsDirectory( "home", 0, date,root,"APFS",date);
    ApfsDirectory code = new ApfsDirectory( "code", 0, date,home,"APFS",date);
    ApfsDirectory applications = new ApfsDirectory( "applications", 0, date,root,"APFS",date);
    ApfsFile f1 = new ApfsFile( "f1", 100, date,applications,"APFS",date);
    ApfsFile f2 = new ApfsFile( "f2", 200, date,applications,"APFS",date);
    ApfsFile f3 = new ApfsFile( "f3", 300, date,home,"APFS",date);
    ApfsFile f4 = new ApfsFile( "f4", 400, date,home,"APFS",date);
    ApfsFile f5 = new ApfsFile( "f5", 500, date,code,"APFS",date);
    ApfsFile f6 = new ApfsFile( "f6", 600, date,code,"APFS",date);
    ApfsLink l1 = new ApfsLink("l1",0, date, home,"APFS",date,applications);
    ApfsLink l2 = new ApfsLink("l2",0,date,code,"APFS",date,f5);

    @Test
    public void Test_getChildren() {
        ApfsElement[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsElement> element = directory.getChildren(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void Test_getSubDirectories() {
        ApfsDirectory[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsDirectory> element = directory.getSubDirectories(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void Test_getFiles() {
        ApfsFile[] expected = { f6,f5};
        ApfsDirectory directory = code;
        List<ApfsFile> element = directory.getFiles(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray());
    }

}