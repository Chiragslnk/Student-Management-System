package com.thinkingmachine.dl.interfaces.dao;
import com.thinkingmachine.dl.interfaces.dto.*;
import com.thinkingmachine.dl.exceptions.*;
import java.util.*;
public interface StudentDAOInterface
{
public void add(StudentDTOInterface studentDTO) throws DAOException; 
public void update(StudentDTOInterface studentDTO) throws DAOException; 
public void remove(int rollNumber) throws DAOException; 
public StudentDTOInterface getByRollNumber(int rollNumber) throws DAOException; 
public boolean exists(int rollNumber) throws DAOException; 
public List<StudentDTOInterface> get() throws DAOException;
}