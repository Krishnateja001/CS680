package edu.umb.cs680.hw12;



public abstract class FileSystem {

    protected abstract FSElement  createDefaultRoot();
    protected  String name;
    protected  int capacity;
    protected  int id;
    protected FSElement rootDirs ;

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if ((root.isDirectory()) && (capacity > root.getSize())) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }


    private int getCapacity() {
        return capacity;
    }

    private String getName() {
        return this.name;
    }
    public int getId() {
        return id;
    }

    public FSElement getRoot() {
        return this.rootDirs;
    }

    private void setRoot(FSElement root) {
        this.rootDirs = root;;
    }



}