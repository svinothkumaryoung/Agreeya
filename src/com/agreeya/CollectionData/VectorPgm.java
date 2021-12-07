package com.agreeya.CollectionData;

import java.util.Iterator;
import java.util.Vector;

public class VectorPgm {
    Vector<String> StudentName=new Vector<String>();
    void AddData()
    {

        StudentName.add("vinoth");
        StudentName.add("Vinoth");
        StudentName.add("Ashok");
        StudentName.add("roshan");
        StudentName.add("Niranjan");
    }
    void printInfo()
        {

            Iterator<String> iterator=StudentName.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        }

    public static void main(String[] args) {
        VectorPgm vp=new VectorPgm();
        vp.AddData();
        vp.printInfo();
    }
}
