/*
We are expecting that the user must have
created database.cfg and kept it in working folder,
from where the application is being run and the
user has written the following 4 line in it
driver=com.mysql.cj.jdbc.Driver 
connection_string=mysql:jdbc://localhost:3306/java730ammwf
username=j730ammwf
password=javabatch
*/
package com.thinkingmachine.dl.dao;
import com.thinkingmachine.dl.exceptions.*;
import java.sql.*;
import java.io.*;
public class DAOConnection
{
private DAOConnection()
{
}
private static DatabaseConfiguration databaseConfiguration;
static
{
// code to load data from database.cfg into
// an object of DatabaseConfiguration
// 4 properties as decided are require 
// if not found, DatabaseConfigurationException should be generated
try
{
File file=new File("database.cfg");
if(file.exists()==false)
{
throw new DatabaseConfigurationException("database.cfg not found");
}
String driver=null;
String connectionString=null;
String username=null;
String password=null;
String line=null;
String splits[];
// example of try with resources
try( RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw"))
{
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
line=randomAccessFile.readLine();
splits=line.split("=");
if(splits.length==2)
{
if(splits[0].equals("driver")) driver=splits[1]; 
else if(splits[0].equals("connection_string")) connectionString=splits[1]; 
else if(splits[0].equals("username")) username=splits[1]; 
else if(splits[0].equals("password")) password=splits[1];
}
}
if(driver==null) throw new DatabaseConfigurationException("[driver] configuration missing in database.cfg"); 
else if(connectionString==null) throw new DatabaseConfigurationException("[connection_string] configuration missing in database.cfg"); 
else if(username==null) throw new DatabaseConfigurationException("[username] configuration missing in database.cfg"); 
else if(password==null) throw new DatabaseConfigurationException("[password] configuration missing in database.cfg"); 
databaseConfiguration=new DatabaseConfiguration(connectionString,driver,username,password);
}catch(IOException ioException)
{
throw new DatabaseConfigurationException(ioException.getMessage());
}
}catch(Throwable throwable)
{
System.out.println(throwable.getMessage());
System.exit(0);
}
}
public static Connection getConnection()
{
Connection connection=null;
try
{
Class.forName(databaseConfiguration.getDriver()); 
connection=DriverManager.getConnection(databaseConfiguration.getConnectionString(),databaseConfiguration.getUsername(),databaseConfiguration.getPassword());
}catch(Throwable throwable)
{
System.out.println(throwable.getMessage());
System.exit(0);
}
return connection;
}
}