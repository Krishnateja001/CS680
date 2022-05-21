package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApfsLinkTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsFile a = new ApfsFile(null, "a", 1, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(null, "b", 2, date2, "Admin", date2);
	
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsFile c = new ApfsFile(null, "c", 3, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(null, "d", 4, date2, "Admin", date2);
	
	static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, date2, "Admin", date2);
	static ApfsFile e = new ApfsFile(null, "e", 5, date2, "Admin", date2);
	static ApfsFile f = new ApfsFile(null, "f", 6, date2, "Admin", date2);
	
	static ApfsLink x = new ApfsLink(null, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(null, "y", 0, date2, null, "Admin", date2);

	@BeforeAll
	static void init() {

		root.appendChild(applications);
		applications.appendChild(a);
		applications.appendChild(b);
		
		root.appendChild(home);
		home.appendChild(c);
		home.appendChild(d);
		
		home.appendChild(code);
		code.appendChild(e);
		code.appendChild(f);

		home.appendChild(x);
		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}

	@Order(1)
	@Test
	public void verifyLinkTest() {
		Boolean real = x.isLink();
		Boolean estimated = true;
		assertSame(estimated, real);
	}

	@Order(2)
	@Test
	public void verifyTargetSizeTest() {
		int real = x.getTargetSize();
		int estimated = 0;
		assertSame(estimated, real);
	}

	@Order(3)
	@Test
	public void verifyTargetIsLinkTest() {
		Boolean real = x.targetisLink();
		Boolean estimated = false;
		assertSame(estimated, real);
	}

	@Order(4)
	@Test
	public void verifyTargetIsFileTest() {
		Boolean real = x.targetisFile();
		Boolean estimated = false;
		assertSame(estimated, real);
	}

	@Order(5)
	@Test
	public void verifyTargetIsDirectoryTest() {
		Boolean real = x.targetisDirectory();
		Boolean estimated = true;
		assertSame(estimated, real);
	}

	@Order(6)
	@Test
	public void setTargetTest() {
		x.setTarget(code);
		ApfsElement real = x.getTarget();
		ApfsDirectory estimated = code;
		assertSame(estimated, real);
	}

	@Order(7)
	@Test
	public void verifyIfEqualLinkX() {
		ApfsDirectory estimated = code;
		ApfsElement real = x.getTarget();
		assertSame(estimated, real);
	}

	@Order(8)
	@Test
	public void verifyIfEqualLinkY() {
		ApfsFile estimated = b;
		ApfsElement real = y.getTarget();
		assertSame(estimated, real);
	}
}