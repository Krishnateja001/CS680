package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;



class ApfsDirectoryTest {

    LocalDateTime date = LocalDateTime.now();
    APFS getInstance = APFS.getInstance();
    ApfsDirectory root = (ApfsDirectory) getInstance.initFileSystem("APFSDirectory", 2);
    ApfsDirectory home = new ApfsDirectory( "home", 0, date,root,"APFS",date);
    ApfsDirectory code = new ApfsDirectory( "code", 0, date,home,"APFS",date);
    ApfsDirectory applications = new ApfsDirectory( "applications", 0, date,root,"APFS",date);
    ApfsFile a = new ApfsFile( "a", 1320, date,applications,"APFS",date);
    ApfsFile b = new ApfsFile( "b", 22300, date,applications,"APFS",date);
    ApfsFile c = new ApfsFile( "c", 35400, date,home,"APFS",date);
    ApfsFile d = new ApfsFile( "d", 46700, date,home,"APFS",date);
    ApfsFile e = new ApfsFile( "e", 87500, date,code,"APFS",date);
    ApfsFile f = new ApfsFile( "f", 6090, date,code,"APFS",date);
    ApfsLink x = new ApfsLink("x",0, date, home,"APFS",date,applications);
    ApfsLink y = new ApfsLink("y",0,date,code,"APFS",date,e);

    @Test
    public void verify_getChildren() {
        ApfsElement[] expected = {applications, home};
        ApfsDirectory directory = root;
        List<ApfsElement> element = directory.getChildren((ApfsElement obj1, ApfsElement obj2) -> obj1.getName().compareTo(obj2.getName()));
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getSubDirectories() {
        ApfsDirectory[] expected = { code};
        ApfsDirectory directory = home;
        List<ApfsDirectory> element = directory.getSubDirectories((ApfsElement ele1, ApfsElement ele2) -> ele1.getName().compareTo(ele2.getName()));
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getFiles() {
        ApfsFile[] expected = { e,f};
        ApfsDirectory directory = code;
        List<ApfsFile> element = directory.getFiles((ApfsElement ele1, ApfsElement ele2) ->  ele1.getName().compareTo(ele2.getName()));
        assertArrayEquals(expected,element.toArray());
    }

}