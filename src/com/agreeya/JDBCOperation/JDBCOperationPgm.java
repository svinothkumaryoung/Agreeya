package com.agreeya.JDBCOperation;

import java.io.*;
import java.sql.*;

public class JDBCOperationPgm {

    int registerNo;
    String name;
    String emailid;
    StudentRegisteration studentRegisteration=new StudentRegisteration();
    InputStreamReader datas=new InputStreamReader(System.in);
    BufferedReader buff=new BufferedReader(datas);

    void getData() throws IOException {
        System.out.println("Enter the Name ");
        name=buff.readLine();
        studentRegisteration.setName(name);
        System.out.println("Enter the Email id");
        emailid=buff.readLine();
        studentRegisteration.setEmailid(emailid);
        System.out.println("Enter the Register No");
        registerNo=Integer.parseInt(buff.readLine());
        studentRegisteration.setRegisterNo(registerNo);
    }

    void InsertTheData() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
        PreparedStatement preparedStatement=c1
                .prepareStatement("insert into registerNo (registerNo,name,emailid) values(?,?,?)");
        preparedStatement.setInt(1,studentRegisteration.getRegisterNo());
        preparedStatement.setString(2,studentRegisteration.getName());
        preparedStatement.setString(3,studentRegisteration.getEmailid());
        int result=preparedStatement.executeUpdate();
        if(result>0)
        {
            System.out.println("Inserted Successfully");
        }
        else
        {
            System.out.println("Error In Insertion");
        }


    }



    void ReteriveRecords()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
            PreparedStatement ps=con.prepareStatement("select registerNo,name,emailid from registerNo");
           ResultSet resultSet= ps.executeQuery();
           while(resultSet.next())
           {
               System.out.println(" Register No "+resultSet.getInt(1));
               System.out.println(" Name "+resultSet.getString(2));
               System.out.println(" Emailid "+resultSet.getString(3));
           }
        }

        catch(ClassNotFoundException classNotFoundException)
        {
            System.out.println("Class Not Found ");
        }
        catch (SQLException sqlException)
        {
            System.out.println("Error in SQL ");
        }



    }

    void getStudentInfoBasedOnCondition() throws IOException,ClassNotFoundException,SQLException
    {
        System.out.println("Enter the Serial No ");
        int val1=Integer.parseInt(buff.readLine());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
        PreparedStatement preparedStatement=connection.prepareStatement("select registerNo,name,emailid from registerNo where sno=? ");
        preparedStatement.setInt(1,val1);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
            System.out.println(" Register No "+resultSet.getInt(1));
            System.out.println(" Name "+resultSet.getString(2));
            System.out.println(" Emailid "+resultSet.getString(3));
        }

    }
    void getStudentInfo() throws IOException,ClassNotFoundException,SQLException
    {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
        PreparedStatement preparedStatement=connection.prepareStatement("select sno,registerNo,name,emailid from registerNo ");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next())
        {
            System.out.println(" *******++++******************************************++++++*****");
            System.out.println(" ******* Reterive Student Record Started *****");
            System.out.println(" Serial No "+resultSet.getInt(1));
            System.out.println(" Register No "+resultSet.getInt(2));
            System.out.println(" Name "+resultSet.getString(3));
            System.out.println(" Emailid "+resultSet.getString(4));
            System.out.println(" ******* Reterive Student Record Ended *****");
        }

    }
    void DeleteRecords()
    {
        try{
            System.out.println("Enter the Register Number u Want to Delete ");
            int id=Integer.parseInt(buff.readLine());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
            PreparedStatement preparedStatement=connection.prepareStatement("delete from registerNo where registerNo=?");
            preparedStatement.setInt(1,id);
           int i= preparedStatement.executeUpdate();
           if(i>0)
           {
               System.out.println("Successfully Deleted");

           }
           else
           {
               System.out.println("Error in Deletion");
           }
        }
        catch(IOException ioException)
        {
            System.out.println("Input type Mismatching");
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            System.out.println("Driver File Is Missing");
        }
        catch (SQLException sqlException)
        {
            System.out.println("Error in SQL");
        }

    }
    public void UpdateRecords() throws IOException, ClassNotFoundException,SQLException
    {

        System.out.println("Enter the Serial Number of Student u Want to Update ");
        int s=Integer.parseInt(buff.readLine());

        System.out.println("Enter the Name u want to change");
        name=buff.readLine();

        System.out.println("Enter the Email id u want to change");
        emailid=buff.readLine();

        System.out.println("Enter the Register No u want to change");
        registerNo=Integer.parseInt(buff.readLine());

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeyaSys","root","12345678");
        PreparedStatement preparedStatement=connection.prepareStatement("update registerNo set registerNo=?,name=?,emailid=? where sno=?");
        preparedStatement.setInt(1,registerNo);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,emailid);
        preparedStatement.setInt(4,s);
        int val=preparedStatement.executeUpdate();
        if(val>0)
        {
            System.out.println("Update Successfully");
        }
        else
        {
            System.out.println("Error in Updation");
        }
    }
    void getUserRequest() throws IOException,ClassNotFoundException,SQLException
    {
        System.out.println("1.Insert\n2.Delete\n3.Reterive Based on Condition\n4.Update\n5.Reterive Records");
        System.out.println("Enter Your Choice ");
        int r=Integer.parseInt(buff.readLine());
        switch (r)
        {
            case 1:
                this.getData();
                this.InsertTheData();
                this.getStudentInfo();
                break;
            case 2:
                this.DeleteRecords();
                this.getStudentInfo();
                break;
            case 3:
                this.getStudentInfoBasedOnCondition();
                this.getUserRequest();
                break;
            case 4:
                this.UpdateRecords();
                this.getStudentInfo();
                break;
            case 5:
                this.getStudentInfo();
                break;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException,SQLException{
        JDBCOperationPgm jop=new JDBCOperationPgm();
        jop.getUserRequest();
    }
}
