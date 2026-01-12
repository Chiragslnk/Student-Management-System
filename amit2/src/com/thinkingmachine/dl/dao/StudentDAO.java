package com.thinkingmachine.dl.dao;
import java.sql.*;
import java.util.*;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.exceptions.*;
import com.thinkingmachine.dl.dto.*; 
public class StudentDAO implements StudentDAOInterface
{
public void add(StudentDTOInterface studentDTOInterface) throws DAOException
{
int rollNumber;
String name;
char gender;
rollNumber=studentDTOInterface.getRollNumber();
name=studentDTOInterface.getName();
gender=studentDTOInterface.getGender();
if(rollNumber<=0)
{
throw new DAOException("Invalid roll number : "+rollNumber);
}
if(name==null)
{
throw new DAOException("Name required");
}
name=name.trim();
if(name.length()==0)
{
throw new DAOException("Name required");
}
if(gender!='M' && gender!='F' && gender!='m' && gender!='f')
{
throw new DAOException("Invalid gender : "+gender);
}
if(gender>=97 && gender<=122) gender=(char)(((int)gender)-32);
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement; 
preparedStatement=connection.prepareStatement("select gender from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber); 
ResultSet resultSet=preparedStatement.executeQuery();
boolean exists=resultSet.next();
resultSet.close();
preparedStatement.close();
if(exists)
{
connection.close(); 
throw new DAOException("Roll number : "+rollNumber+" exists");
}
preparedStatement=connection.prepareStatement("insert into stud values(?,?,?)");
preparedStatement.setInt(1,rollNumber);
preparedStatement.setString(2,name); 
preparedStatement.setString(3,String.valueOf(gender));
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public boolean exists(int rollNumber) throws DAOException
{
String rollNumberString;
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement; 
preparedStatement=connection.prepareStatement("select gender from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber); 
ResultSet resultSet=preparedStatement.executeQuery();
boolean exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return exists;
}
catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public void update(StudentDTOInterface studentDTOInterface) throws DAOException
{
int rollNumber;
String name;
char gender;
rollNumber=studentDTOInterface.getRollNumber();
name=studentDTOInterface.getName();
gender=studentDTOInterface.getGender();
if(rollNumber<=0)
{
throw new DAOException("Invalid roll number : "+rollNumber);
}
if(name==null)
{
throw new DAOException("Name required");
}
name=name.trim();
if(name.length()==0)
{
throw new DAOException("Name required");
}
if(gender!='M' && gender!='F' && gender!='m' && gender!='f')
{
throw new DAOException("Invalid gender : "+gender);
}
if(gender>=97 && gender<=122) gender=(char)(((int)gender)-32);
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement; 
preparedStatement=connection.prepareStatement("select gender from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber); 
ResultSet resultSet=preparedStatement.executeQuery();
boolean exists=resultSet.next();
resultSet.close();
preparedStatement.close();
if(!exists)
{
connection.close(); throw new DAOException("Roll number : "+rollNumber+" does not exists");
}
preparedStatement=connection.prepareStatement("update stud set name=?,gender=? where roll_number=?")
;
preparedStatement.setString(1,name); 
preparedStatement.setString(2,String.valueOf(gender));
preparedStatement.setInt(3,rollNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public void remove(int rollNumber) throws DAOException
{
if(rollNumber<=0)
{
throw new DAOException("Invalid roll number : "+rollNumber);
}
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement; 
preparedStatement=connection.prepareStatement("select gender from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber); 
ResultSet resultSet=preparedStatement.executeQuery();
boolean exists=resultSet.next();
resultSet.close();
preparedStatement.close();
if(!exists)
{
connection.close(); 
throw new DAOException("Roll number : "+rollNumber+" does not exists");
}
preparedStatement=connection.prepareStatement("delete from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public StudentDTOInterface getByRollNumber(int rollNumber) throws DAOException
{
if(rollNumber<=0)
{
throw new DAOException("Invalid roll number : "+rollNumber);
}
try
{
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement; 
preparedStatement=connection.prepareStatement("select * from stud where roll_number=?");
preparedStatement.setInt(1,rollNumber); 
ResultSet resultSet=preparedStatement.executeQuery();
boolean exists=resultSet.next();
if(!exists)
{
resultSet.close();
preparedStatement.close();
connection.close(); 
throw new DAOException("Roll number : "+rollNumber+" does not exists");
}
StudentDTOInterface studentDTO=new StudentDTO();
studentDTO.setRollNumber(rollNumber); 
studentDTO.setName(resultSet.getString("name").trim()); 
studentDTO.setGender(resultSet.getString("gender").charAt(0));
resultSet.close();
preparedStatement.close();
connection.close();
return studentDTO;
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public List<StudentDTOInterface> get() throws DAOException
{
List<StudentDTOInterface> students;
students=new ArrayList<StudentDTOInterface>();
StudentDTOInterface studentDTO;
try
{
Connection connection;
connection=DAOConnection.getConnection();
Statement statement=connection.createStatement(); 
ResultSet resultSet=statement.executeQuery("select * from stud order by name");
while(resultSet.next())
{
studentDTO=new StudentDTO(); 
studentDTO.setRollNumber(resultSet.getInt("roll_number")); 
studentDTO.setName(resultSet.getString("name").trim()); 
studentDTO.setGender(resultSet.getString("gender").charAt(0));
students.add(studentDTO);
}
resultSet.close();
statement.close();
connection.close();
return students;
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}