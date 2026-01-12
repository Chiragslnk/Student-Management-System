package com.thinkingmachine;
import com.thinkingmachine.manager.*;
import com.io.util.*;
public class SchoolApplication
{
public static void main(String gg[])
{
int choice; 
StudentManager studentManager=new StudentManager();
while(true)
{
try
{
System.out.println("1. Add");
System.out.println("2. Edit");
System.out.println("3. Delete");
System.out.println("4. Search");
System.out.println("5. List");
System.out.println("6. Exit");
choice=Keyboard.getInt("Enter your choice : ");
if(choice==1) studentManager.addStudent();
else if(choice==2) studentManager.editStudent();
else if(choice==3) studentManager.deleteStudent();
else if(choice==4) studentManager.searchStudent(); 
else if(choice==5) studentManager.displayListOfStudents();
else if(choice==6) break;
else System.out.println("Invalid Choice"); 
}catch(KeyboardInputException keyboardInputException)
{
System.out.println(keyboardInputException.getMessage());
}
}
}
}