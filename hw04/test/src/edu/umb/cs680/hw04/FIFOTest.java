package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.FIFO;

class FIFOTest {
	private static FIFO cache;
	private static Path p1;
	private static Path p2;
	private static Path p3;
	private static Path p4;
	
	@BeforeAll
	static void Classset() throws Exception {
		cache = new FIFO(3);
		p1 = Paths.get("/Users/kt/eclipse-workspace/hw04/filesfortesting/file1.txt");
		p2 = Paths.get("/Users/kt/eclipse-workspace/hw04/filesfortesting/file2.txt");
		p3 = Paths.get("/Users/kt/eclipse-workspace/hw04/filesfortesting/file3.txt");
		p4 = Paths.get("/Users/kt/eclipse-workspace/hw04/filesfortesting/file4.txt");
		cache.fetch(p1);
		cache.fetch(p2);
		cache.fetch(p3);
	}

	@Test
	public void verifypath1() throws IOException {
		assertEquals(Files.readString(p1), cache.fetch(p1));
	}
	
	@Test
	public void verifypath2() throws IOException {
		assertEquals(Files.readString(p2), cache.fetch(p2));
	}
	
	@Test
	public void verifypath3() throws IOException {
		assertEquals(Files.readString(p3), cache.fetch(p3));
	}
	
	@Test
	public void verifypath4() throws IOException {
		assertEquals(Files.readString(p4), cache.fetch(p4));
		
	}

}

	
				