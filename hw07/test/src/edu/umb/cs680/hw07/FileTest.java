package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class FileTest {
	
	private LocalDateTime date1 = LocalDateTime.now();
	private LocalDateTime date2 = LocalDateTime.now();
	
	Directory root = new Directory(null, "Root", 0, date1);
	
	Directory applications = new Directory(root, "Applications", 0, date1);
	File a = new File(applications, "a", 1, date1);
	File b = new File(applications, "b", 2, date2);
	
	Directory home = new Directory(root, "Home", 0, date1);
	File c = new File(home, "c", 3, date1);
	File d = new File(home, "d", 4, date2);
	
	Directory code = new Directory(home, "Code", 0, date2);	
	File e = new File(code, "e", 5, date2);
	File f = new File(code, "f", 6, date2);
	
	Link x = new Link(home, "x", 0, date1, this.applications);
	Link y = new Link(code, "y", 0, date2, this.b);

	private String[] fileToStringArray(File f) {
		String[] fileInfo = { 
				String.valueOf(f.isFile()), 
				f.getName(), 
				Integer.toString(f.getSize()),
				f.getCreationTime().toString(), 
				f.getParent().getName(), 
				String.valueOf(f.isDirectory()) 
		};
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "true", "a", "1", date1.toString(), "Applications", "false" };
		File actual = this.a;
		assertArrayEquals(expected,  fileToStringArray(actual));
	}

	@Test
	public void verifyFileEqualityB() {
		String[] expected = { "true", "b", "2", date2.toString(), "Applications", "false" };
		File actual = this.b;
		assertArrayEquals(expected,  fileToStringArray(actual));
	}

	@Test
	public void verifyFileEqualityC() {
		String[] expected = { "true", "c", "3", date1.toString(), "Home", "false" };
		File actual = this.c;
		assertArrayEquals(expected,  fileToStringArray(actual));
	}

}