package com.thinkingmachine.dl.dao;

public class DatabaseConfiguration
{
private String driver;
private String connectionString;
private String username;
private String password;

public DatabaseConfiguration(String connectionString, String driver, String username, String password)
{
this.connectionString = connectionString;
this.driver = driver;
this.username = username;
this.password = password;
}

public void setDriver(java.lang.String driver)
{
this.driver = driver;
}

public java.lang.String getDriver()
{
return this.driver;
}

public void setConnectionString(java.lang.String connectionString)
{
this.connectionString = connectionString;
}

public java.lang.String getConnectionString()
{
return this.connectionString;
}

public void setUsername(java.lang.String username)
{
this.username = username;
}

public java.lang.String getUsername()
{
return this.username;
}

public void setPassword(java.lang.String password)
{
this.password = password;
}

public java.lang.String getPassword()
{
return this.password;
}
}