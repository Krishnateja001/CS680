package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class APFSTest {

	private String[] apfsElementToArray(ApfsElement apfsElement) {
		String[] info = { 
				apfsElement.getName(), 
				apfsElement.getOwnerName(), 
				Integer.toString(apfsElement.getSize()) 
		};
		return info;
	}

	@Test
	public void sameAPFSTest() {
		APFS APFS1 = APFS.getInstance();
		APFS APFS2 = APFS.getInstance();
		assertSame(APFS1, APFS2);
	}
	
	@Test
	public void createDefaultRootTest() {
		APFS APFS1 = APFS.getInstance();
		String[] expected = { "apfsRootDir", "Admin", "0" };
		String[] actual = this.apfsElementToArray(APFS1.getRootDir());
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getRootDirTest() {
		APFS APFS1 = APFS.getInstance();
		APFS1.initFileSystem("apfsRootDir", 100);
		String[] expected = { "apfsRootDir", "Admin", "0" };
		String[] actual = this.apfsElementToArray(APFS1.getRootDir());
		assertArrayEquals(expected, actual);
	}	
}