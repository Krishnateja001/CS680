package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DirectoryTest {

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
	
	static Link x = new Link(null, "x", 0, date1, null);
	static Link y = new Link(null, "y", 0, date2, null);
	
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
	
	private String[] dirToStringArray(Directory dir) {
		String parentName = null;
		Directory parent = dir.getParent();
		
		if (parent != null) 
			parentName = parent.getName();
		
		String[] dirInfo = { 
				String.valueOf(dir.isFile()), 
				dir.getName(), 
				Integer.toString(dir.getSize()),
				dir.getCreationTime().toString(), 
				parentName, 
				String.valueOf(dir.isDirectory()),
				Integer.toString(dir.getTotalSize()), 
				Integer.toString(dir.countChildren()) 
		};
		return dirInfo;
	}


	
	@Test
	public void verifyDirectoryEqualityApplications() {
		String[] expected = { "false", "Applications", "0", date1.toString(), "Root", "true", "3", "2" };
		Directory actual = applications;		
		assertArrayEquals(expected,dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "false", "Home", "0", date1.toString(), "Root", "true", "18", "4" };
		Directory actual = home;		
		assertArrayEquals(expected,dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityCode() {
		String[] expected = { "false", "Code", "0", date2.toString(), "Home", "true", "11", "3" };
		Directory actual = code;		
		assertArrayEquals(expected,dirToStringArray(actual));
	}
}