package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public abstract class FIFO extends FileCache{
	private int capacity;
	
	public FIFO(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>();
	}

	protected boolean isCached(String String) {
		if(cache.containsKey(String)) {
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

	protected void cacheFile(String String) {
		try {
			String content = String;
			cache.put(String, content);
		} /*catch (IOException e) {
			e.printStackTrace();
		}*/
		finally {
			//e.printStackTrace();
			System.out.println("Here");
		}
	

		try {
			String content = String;
			String removeKey = cache.keySet().iterator().next();
			cache.remove(removeKey);
			cache.put(String, content);
		} /*catch (IOException e) {
			e.printStackTrace();
		}*/
		finally {
			//e.printStackTrace();
			System.out.println("There");
		}
		
	}

}