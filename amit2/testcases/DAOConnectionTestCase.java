import com.thinkingmachine.dl.dao.*;
import java.sql.*;
class DAOConnectionTestCase
{
public static void main(String gg[])
{
try
{
Connection connection=DAOConnection.getConnection();
System.out.println("Connection established");
connection.close();
System.out.println("Connection closed");
}catch(Exception e)
{
System.out.println(e);
}
}
}