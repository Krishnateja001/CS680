package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;

public class ApfsCountingVisitorTest {
	private static ApfsDirectory root;
	private static ApfsDirectory apps;
	private static ApfsDirectory bin;
	private static ApfsDirectory home;
	private static ApfsDirectory pictures;
	private static ApfsFile x;
	private static ApfsFile y;
	private static ApfsFile a;
	private static ApfsFile b;
	private static ApfsFile c;
	private static ApfsLink m;
	private static ApfsLink n;
	private static ApfsCountingVisitor rootVisitor;
	private static ApfsCountingVisitor homeVisitor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "krishna", "timenow");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "krishna", "timenow");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "krishna", "timenow");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "krishna", "timenow");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "krishna", "timenow");
		x = new ApfsFile(apps, "x", 10, LocalDateTime.now(), "krishna", "timenow");
		y = new ApfsFile(bin, "y", 20, LocalDateTime.now(), "krishna", "timenow");
		a = new ApfsFile(pictures, "a", 30, LocalDateTime.now(), "krishna", "timenow");
		b = new ApfsFile(pictures, "b", 40, LocalDateTime.now(), "krishna", "timenow");
		c = new ApfsFile(home, "c", 50, LocalDateTime.now(), "krishna", "timenow");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "krishna", "timenow", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "krishna", "timenow", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
		rootVisitor = new ApfsCountingVisitor();
		homeVisitor = new ApfsCountingVisitor();
		root.accept(rootVisitor);
		home.accept(homeVisitor);
	}

	@Test
	public void verifyDirectoryNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberRoot() {
		int expected = 2;
		int actual = rootVisitor.getLinkNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyDirectoryNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberHome() {
		int expected = 3;
		int actual = homeVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getLinkNum();
		assertEquals(expected, actual);
	}

}

