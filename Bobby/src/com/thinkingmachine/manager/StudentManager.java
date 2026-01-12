package com.thinkingmachine.manager;
import java.util.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.exceptions.*;
import com.io.util.*;
public class StudentManager
{
public void addStudent()
{
char confirm;
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO();
int rollNumber;
String name;
char gender;
System.out.println("Student (Add Module)");
try
{
rollNumber=Keyboard.getInt("Enter roll number : "); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
return;
}
if(rollNumber<=0)
{
System.out.println("Invalid roll number");
return;
}
try
{
if(studentDAOInterface.exists(rollNumber))
{
System.out.println("That roll number exists");
return;
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
return;
}
try
{
name=Keyboard.getString("Enter name : "); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
return;
}
name=name.trim();
if(name.length()==0)
{
System.out.println("Name required");
return;
}
try
{
gender=Keyboard.getChar("Enter gender (M/F) : "); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
return;
}
if(gender!='M' && gender!='m' && gender!='F' && gender!='f')
{
System.out.println("Invalid gender");
return;
}
if(gender>=97 && gender<=122) gender=(char)(((int)gender)-32);
try
{
confirm=Keyboard.getChar("Save (Y/N) : "); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
return;
}
if(confirm!='y' && confirm!='Y')
{
System.out.println("Student not added");
return;
}
try
{
StudentDTOInterface studentDTOInterface;
studentDTOInterface=new StudentDTO();
studentDTOInterface.setRollNumber(rollNumber);
studentDTOInterface.setName(name);
studentDTOInterface.setGender(gender);
studentDAOInterface.add(studentDTOInterface);
System.out.println("Student added");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
System.out.println("Student not added");
}
}
public void editStudent()
{
System.out.println("Student (Edit Module)");
int rollNumber;
try
{
rollNumber=Keyboard.getInt("Enter roll number : ");
if(rollNumber<=0)
{
System.out.println("Invalid roll number");
return;
}
StudentDTOInterface studentDTOInterface;
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO(); 
studentDTOInterface=studentDAOInterface.getByRollNumber(rollNumber); 
System.out.println("Name : "+studentDTOInterface.getName()); 
System.out.println("Gender : "+studentDTOInterface.getGender());
char yesNo;
yesNo=Keyboard.getChar("Edit (Y/N) : ");
if(yesNo!='y' && yesNo!='Y')
{
System.out.println("Student not updated");
return;
}
String name;
char gender;
name=Keyboard.getString("Enter name : ");
gender=Keyboard.getChar("Enter gender : ");
yesNo=Keyboard.getChar("Update (Y/N) : ");
if(yesNo!='y' && yesNo!='Y')
{
System.out.println("Student not updated");
return;
}
studentDTOInterface.setName(name);
studentDTOInterface.setGender(gender);
studentDAOInterface.update(studentDTOInterface);
System.out.println("Student updated");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
return; }catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
}
}
public void deleteStudent()
{
System.out.println("Student (Delete Module)");
int rollNumber;
try
{
rollNumber=Keyboard.getInt("Enter roll number : ");
if(rollNumber<=0)
{
System.out.println("Invalid roll number");
return;
}
StudentDTOInterface studentDTOInterface;
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO(); 
studentDTOInterface=studentDAOInterface.getByRollNumber(rollNumber); 
System.out.println("Name : "+studentDTOInterface.getName()); 
System.out.println("Gender : "+studentDTOInterface.getGender());
char yesNo;
yesNo=Keyboard.getChar("Delete (Y/N) : ");
if(yesNo!='y' && yesNo!='Y')
{
System.out.println("Student not deleted");
return;
}
studentDAOInterface.remove(rollNumber);
System.out.println("Student deleted");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
return; 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
}
}
public void searchStudent()
{
System.out.println("Student (Search Module)");
int rollNumber;
try
{
rollNumber=Keyboard.getInt("Enter roll number : "); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
return;
}
if(rollNumber<=0)
{
System.out.println("Invalid roll number");
return;
}
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO();
StudentDTOInterface studentDTOInterface;
try
{
studentDTOInterface=studentDAOInterface.getByRollNumber(rollNumber); 
System.out.println("Name : "+studentDTOInterface.getName()); 
System.out.println("Gender : "+studentDTOInterface.getGender());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
public void displayListOfStudents()
{
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO();
try
{
List<StudentDTOInterface> students;
students=studentDAOInterface.get();
StudentDTOInterface studentDTOInterface;
for(int i=0;i<students.size();i++)
{
studentDTOInterface=students.get(i); 
System.out.println("Roll number : "+studentDTOInterface.getRollNumber()); 
System.out.println("Name : "+studentDTOInterface.getName()); 
System.out.println("Gender : "+studentDTOInterface.getGender());
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}