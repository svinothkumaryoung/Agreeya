package com.agreeya.CollectionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListPgm {
    String name;
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> arrayList=new ArrayList<String>();
    void AddData() throws IOException
    {
        System.out.println("Enter the No of Elements u want to add ");
        int n;
        n=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the Name u Want to Add in "+(i+1)+" Location");
            name=bufferedReader.readLine();
            arrayList.add(name);
        }
    }
    void ReteriveVal()
    { this.sortTheData();
        Iterator<String> iterator=arrayList.iterator();
        while(iterator.hasNext())
        {
            System.out.println( iterator.next());
        }
    }
    void sortTheData()
    {
        Collections.sort(arrayList);
    }
    public static void main(String[] args) throws IOException{
        ArrayListPgm alp=new ArrayListPgm();
        alp.AddData();
        alp.ReteriveVal();
    }
}
