package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement> {

    public int compare(ApfsElement ele1, ApfsElement ele2) {
        return ele1.getOwnerName().compareTo(ele2.getOwnerName());
    }
}