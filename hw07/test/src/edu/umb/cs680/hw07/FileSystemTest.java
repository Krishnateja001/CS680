package edu.umb.cs680.hw07;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import java.util.LinkedList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileSystemTest {

	private LocalDateTime date1 = LocalDateTime.now();

	private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
		
		Directory[] rootArray = new Directory[rootList.size()];
		int index = 0;
		
		for (Directory root : rootList) {
			rootArray[index++] = root;
		}
		return rootArray;
	}

	@Order(1)
	@Test
	public void getRootDirsTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		Directory[] expected = {};
		Directory[] actual = this.LinkedListToArray(fileSystem.getRootDirs());
		assertArrayEquals(expected, actual);
	}

	@Order(2)
	@Test
	public void sameFileSystemTest() {
		FileSystem fileSystem1 = FileSystem.getFileSystem();
		FileSystem fileSystem2 = FileSystem.getFileSystem();
		assertSame(fileSystem1, fileSystem2);
	}

	@Order(3)
	@Test
	public void addRootDirTest() {
		Directory root = new Directory(null, "Root", 0, this.date1);
		FileSystem fileSystem = FileSystem.getFileSystem();
		fileSystem.addRootDir(root);
		LinkedList<Directory> rootsRes = fileSystem.getRootDirs();
		Directory[] expected = { root };
		Directory[] actual = this.LinkedListToArray(rootsRes);
		assertArrayEquals(expected, actual);
	}
}