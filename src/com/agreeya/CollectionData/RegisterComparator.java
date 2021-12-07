package com.agreeya.CollectionData;

import java.util.Comparator;

public class RegisterComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        StudentInfo si1=(StudentInfo) o1;
        StudentInfo si2=(StudentInfo) o2;
        if(si1.RegisterNo==si2.RegisterNo)
        {
            return 0;
        }
        else if(si1.RegisterNo>si2.RegisterNo)
        {
            return 1;
        }
        else
        {
            return -1;
        }

    }
}
