package com.agreeya.CollectionData;

import java.util.Comparator;

public class EmailComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        StudentInfo si1=(StudentInfo) o1;
        StudentInfo si2=(StudentInfo) o2;
        return si1.emailid.compareTo(si2.emailid);
    }
}


