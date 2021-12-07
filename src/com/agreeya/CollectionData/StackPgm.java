package com.agreeya.CollectionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class StackPgm {
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    Stack<String> stack=new Stack<String>();
    void pushData() throws IOException
    {
        System.out.println("Enter the No. of Elements u want to add");
        int n=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the Value u want to add ");
            stack.push(bufferedReader.readLine());
        }
    }
    void popData()
    {
        String name=stack.pop();
        System.out.println("Element Removed is "+name);
    }
    void topStack()
    {
        String name=stack.peek();
        System.out.println("The Value on the Top is "+name);
    }
    void reteriveData()
    {
        Iterator iterator=stack.iterator();
        while(iterator.hasNext())
        {
            System.out.println("The Element Present in the Stack is "+iterator.next());
        }
    }

    public static void main(String[] args) throws IOException {
        StackPgm sp=new StackPgm();
        sp.pushData();
        sp.reteriveData();
        sp.popData();
        sp.topStack();
        sp.reteriveData();
    }

}
