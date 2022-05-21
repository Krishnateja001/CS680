package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LinkTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	
	static Directory root = new Directory(null, "Root", 0, date1);
	
	static Directory applications = new Directory(null, "Applications", 0, date1);
	static File a = new File(null, "a", 1, date1);
	static File b = new File(null, "b", 2, date2);
	
	static Directory home = new Directory(null, "Home", 0, date1);
	static File c = new File(null, "c", 3, date1);
	static File d = new File(null, "d", 4, date2);
	
	static Directory code = new Directory(null, "Code", 0, date2);
	static File e = new File(null, "e", 5, date2);
	static File f = new File(null, "f", 6, date2);
	
	static Link x = new Link(null, "x", 6, date1, null);
	static Link y = new Link(null, "y", 6, date2, null);
	
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
	
	@Test
	public void verifyLinkEqualityX() {
		Directory expected = applications;
		FSElement actual = x.getTarget();
		assertSame(expected, actual);
	}

	@Test
	public void verifyLinkEqualityY() {
		File expected = b;
		FSElement actual = y.getTarget();
		assertSame(expected, actual);
	}
}