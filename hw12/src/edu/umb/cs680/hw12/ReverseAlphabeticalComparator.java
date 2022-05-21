package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {

    public int compare(ApfsElement element1, ApfsElement element2) {
        return element2.getName().compareTo(element1.getName());
    }

}