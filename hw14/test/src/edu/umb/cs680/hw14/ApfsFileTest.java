package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;



class ApfsFileTest {

    LocalDateTime date = LocalDateTime.now();
    APFS getInstance = APFS.getInstance();
    ApfsDirectory root = (ApfsDirectory) getInstance.initFileSystem("APFSDirectory", 2);
    ApfsDirectory home = new ApfsDirectory( "home", 0, date,root,"APFS",date);
    ApfsDirectory code = new ApfsDirectory( "code", 0, date,home,"APFS",date);
    ApfsDirectory applications = new ApfsDirectory( "applications", 0, date,root,"APFS",date);
    ApfsFile a = new ApfsFile( "a", 100, date,applications,"APFS",date);
    ApfsFile b = new ApfsFile( "b", 200, date,applications,"APFS",date);
    ApfsFile c = new ApfsFile( "c", 300, date,home,"APFS",date);
    ApfsFile d = new ApfsFile( "d", 400, date,home,"APFS",date);
    ApfsFile e = new ApfsFile( "e", 500, date,code,"APFS",date);
    ApfsFile f = new ApfsFile( "f", 600, date,code,"APFS",date);
    ApfsLink x = new ApfsLink("x",0, date, home,"APFS",date,applications);
    ApfsLink y = new ApfsLink("y",0,date,code,"APFS",date,e);

    @Test
    public void verify_getChildren() {
        ApfsElement[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsElement> element = directory.getChildren((ApfsElement ele1, ApfsElement ele2) -> ele2.getName().compareTo(ele1.getName()));
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getSubDirectories() {
        ApfsDirectory[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsDirectory> element = directory.getSubDirectories((ApfsElement ele1, ApfsElement ele2) -> ele2.getName().compareTo(ele1.getName()));
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getFiles() {
        ApfsFile[] expected = { f,e};
        ApfsDirectory directory = code;
        List<ApfsFile> element = directory.getFiles((ApfsElement ele1, ApfsElement ele2) -> ele2.getName().compareTo(ele1.getName()));
        assertArrayEquals(expected,element.toArray());
    }
    @Test
    public void verify_getChildrenHome() {
        ApfsElement[] expected = {x,d,code,c};
        ApfsDirectory directory = home;
        List<ApfsElement> element = directory.getChildren((ApfsElement ele1, ApfsElement ele2) -> ele2.getName().compareTo(ele1.getName()));
        assertArrayEquals(expected,element.toArray() );
    }

}