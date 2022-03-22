package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class FIFO extends FileCache{
	private int capacity;
	
	public FIFO(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>();
	}

	protected boolean isCached(Path path) {
		if(cache.containsKey(path)) {
			return true;
		}else {
			return false;
		}
	}

	protected boolean isCacheFull() {
		if(cache.size() == capacity) {
			return true;
		}else {
			return false;
		}
	}

	protected void cacheFile(Path path) {
		try {
			String content = Files.readString(path);
			cache.put(path, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void replace(Path path) {
		try {
			String content = Files.readString(path);
			Path removeKey = cache.keySet().iterator().next();
			cache.remove(removeKey);
			cache.put(path, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}