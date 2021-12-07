package com.agreeya.CollectionData;

public class StudentInfo implements Comparable<StudentInfo> {
    public int RegisterNo;
    public String name;
    public String emailid;

    public StudentInfo()
    { }

    public StudentInfo(int registerNo, String name, String emailid) {
        RegisterNo = registerNo;
        this.name = name;
        this.emailid = emailid;
    }

    public int getRegisterNo() {
        return RegisterNo;
    }

    public void setRegisterNo(int registerNo) {
        RegisterNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    @Override
    public int compareTo(StudentInfo si1) {

            return name.compareTo(si1.name);
        }
    }

