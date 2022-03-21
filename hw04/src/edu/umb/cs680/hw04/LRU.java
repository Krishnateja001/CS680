package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class LRU extends FileCache{
	private int capacity;
	
	public LRU(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>(capacity, 0.75f, true);
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

	@Override
	protected void cacheFile(String path) {
		try {
			String content = Files.readString(path);
			cache.put(path, content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void replace(String path) {
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