package com.agreeya.CollectionData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListImplPojo {
    StudentInfo si=new StudentInfo();
    ArrayList<StudentInfo> studentInfos=new ArrayList<StudentInfo>();
    void addValues()
    {
        studentInfos.add(new StudentInfo(1301,"Vinoth","svinoth@gmail,.com"));
        studentInfos.add(new StudentInfo(2301,"Ashok","dsashok@gmail,.com"));
        studentInfos.add(new StudentInfo(2211,"Roshan","vroshan@gmail,.com"));
        studentInfos.add(new StudentInfo(1101,"Niranjan","vniranjan@gmail,.com"));
    }

    void reteriveData()
    {
        Collections.sort(studentInfos);
       for(StudentInfo si:studentInfos)
       {
            System.out.println(" Register No is "+si.getRegisterNo()+" Name "+si.getName()+" Email id "+si.getEmailid());
        }
    }

    public static void main(String[] args) {
        ArrayListImplPojo alp=new ArrayListImplPojo();
        alp.addValues();
        alp.reteriveData();

    }
}
