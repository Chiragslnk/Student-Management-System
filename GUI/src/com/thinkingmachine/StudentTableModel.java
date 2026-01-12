package com.thinkingmachine;
import java.util.*;
import javax.swing.table.*;
import com.thinkingmachine.dl.dto.*;
import com.thinkingmachine.dl.dao.*;
import com.thinkingmachine.dl.exceptions.*;
import com.thinkingmachine.dl.interfaces.dao.*;
import com.thinkingmachine.dl.interfaces.dto.*; 
public class StudentTableModel extends AbstractTableModel
{
private java.util.List<StudentDTOInterface> students; 
String title[]={"S.No.","Roll number","Name","Gender"};
public StudentTableModel()
{
populateDataStructures();
}


private void populateDataStructures()
{
try
{
StudentDAOInterface studentDAOInterface;
studentDAOInterface=new StudentDAO();
students=studentDAOInterface.get();
}catch(DAOException daoException)
{
students=new ArrayList<>();
}
}
public int getRowCount()
{
return students.size();
}
public int getColumnCount()
{
return title.length;
}
public String getColumnName(int index)
{
return title[index];
}
public boolean isCellEditable(int rowIndex,int columnIndex)
{
return false;
}


public Object getValueAt(int rowIndex,int columnIndex)
{
StudentDTOInterface studentDTO;
if(columnIndex==0) return rowIndex+1;
studentDTO=students.get(rowIndex); 
if(columnIndex==1) return studentDTO.getRollNumber();
if(columnIndex==2) return studentDTO.getName();
char gender=studentDTO.getGender();
if(gender=='m' || gender=='M') return "Male";
else return "Female";
}


public Class getColumnClass(int index)
{
if(index==0 || index==1) return java.lang.Integer.class;
if(index>1) return java.lang.String.class;
return null; // logically unreachable statement
}

public int SearchPartialName(String partialName) 
{
partialName = partialName.toUpperCase();
for (int i = 0; i < students.size(); i++) 
{
if (students.get(i).getName().toUpperCase().startsWith(partialName)) 
{
return i;
}
}
return -1;
}

}