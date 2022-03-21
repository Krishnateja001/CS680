package edu.umb.cs680.hw04;

//import java.nio.file.Path;
import java.util.Map;

public abstract class FileCache {
	protected Map<String, String> cache;

	public String fetch(String String) {
		if (isCached(String)) {
			return cache.get(String);
		} else {
			if (!isCacheFull()) {
				cacheFile(String);
				return cache.get(String);
			} else {
				replace(String);
				return cache.get(String);
			}
		}
	}

	protected abstract boolean isCached(String String);
	protected abstract boolean isCacheFull();
	protected abstract void cacheFile(String String);
	protected abstract void replace(String String);

}