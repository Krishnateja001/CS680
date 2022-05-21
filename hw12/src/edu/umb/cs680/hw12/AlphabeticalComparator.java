
package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {

    public int compare(ApfsElement apfsElement1, ApfsElement apfsElement2) {
        return apfsElement1.getName().compareTo(apfsElement2.getName());
    }


}