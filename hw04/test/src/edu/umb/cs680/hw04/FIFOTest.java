package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.FileCache;

class FIFOTest {
	private static FileCache cache;
	private static String p1;
	private static String p2;
	private static String p3;
	private static String p4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cache = new FileCache(3);
		p1 = "This is file1.";
		p2 = "This is file2.";
		p3 = "This is file3.";
		p4 = "This is file4.";
		cache.fetch(p1);
		cache.fetch(p2);
		cache.fetch(p3);
	}

	@Test
	public void fetchwithp1() throws IOException {
		assertEquals(p1, cache.fetch(p1));
	}
	
	@Test
	public void fetchwithp2() throws IOException {
		assertEquals(p2, cache.fetch(p2));
	}
	
	@Test
	public void fetchwithp3() throws IOException {
		assertEquals(p3, cache.fetch(p3));
	}
	
	@Test
	public void fetchwithp4() throws IOException {
		assertEquals(p4, cache.fetch(p4));
		
	}

}