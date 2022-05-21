package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApfsDirectoryTest {

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

	private String[] dirToStringArray(ApfsDirectory dir) {
		String[] dirInfo = { 
				String.valueOf(dir.isFile()), 
				dir.getName(), dir.getCreationTime().toString(),
				String.valueOf(dir.isDirectory()), 
				Integer.toString(dir.getTotalSize()),
				Integer.toString(dir.countChildren()), 
				dir.getOwnerName(), 
				dir.getlastModifiedDate().toString() 
		};
		return dirInfo;
	}

	@Test
	public void verifyEqualityOfDirectoryRoot() {
		String[] expected = { "false", "root", date1.toString(), "true", "21", "2", "Admin", date2.toString() };
		String[] actual = dirToStringArray(root);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyEqualityOfDirectoryApplications() {
		String[] expected = { "false", "Applications", date1.toString(), "true", "3", "2", "Admin", date2.toString() };
		String[] actual = dirToStringArray(applications);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfDirectoryHome() {
		String[] expected = { "false", "Home", date1.toString(), "true", "18", "4", "Admin", date2.toString() };
		String[] actual = dirToStringArray(home);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfDirectoryCode() {
		String[] expected = { "false", "Code", date2.toString(), "true", "11", "3", "Admin", date2.toString() };
		String[] actual = dirToStringArray(code);
		assertArrayEquals(expected, actual);
	}
}