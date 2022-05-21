package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsFile a = new ApfsFile(null, "a", 1, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(null, "b", 2, date2, "Admin", date2);
	
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsFile c = new ApfsFile(null, "c", 3, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(null, "d", 4, date2, "Admin", date2);
	
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
		
		home.appendChild(x);
//		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}
	
	private String[] fileToStringArray(ApfsFile file) {
		String[] fileInfo = { 
				String.valueOf(file.isFile()), 
				file.getName(), Integer.toString(file.getSize()),
				file.getCreationTime().toString(), 
				file.getParent().getName(), 
				String.valueOf(file.isDirectory()),
				d.getOwnerName(), 
				d.getlastModifiedDate().toString() 
		};
		return fileInfo;
	}

	@Test
	public void verifyEqualityOfFileA() {
		String[] expected = { "true", "a", "1", date1.toString(), "Applications", "false", "Admin", date2.toString() };
		String[] actual = fileToStringArray(a);
		System.out.println(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileB() {
		String[] expected = { "true", "b", "2", date2.toString(), "Applications", "false", "Admin", date2.toString() };
		String[] actual = fileToStringArray(b);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileC() {
		String[] expected = { "true", "c", "3", date1.toString(), "Home", "false", "Admin", date2.toString() };
		String[] actual = fileToStringArray(c);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileD() {
		String[] expected = { "true", "d", "4", date2.toString(), "Home", "false", "Admin", date2.toString() };
		String[] actual = fileToStringArray(d);
		assertArrayEquals(expected, actual);
	}
}