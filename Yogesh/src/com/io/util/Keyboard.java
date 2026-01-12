package com.io.util;
import java.io.*;
public final class Keyboard
{
    private Keyboard(){}
    private static BufferedReader bufferedReader;
    static
    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    public static long getLong() throws KeyboardInputException
    {
        long x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            x=Long.parseLong(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid long value :" +str);
        }
        return x;
    }

    public static int getInt() throws KeyboardInputException
    {
        int x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            x=Integer.parseInt(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid Int value :"+str);
        }
        return x;
    }

    public static short getShort() throws KeyboardInputException
    {
        short x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            x=Short.parseShort(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid short value :"+str);
        }
        return x;
    }

    public static byte getByte() throws KeyboardInputException
    {
        Byte x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            x=Byte.parseByte(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid byte value :"+str);
        }
        return x;
    }

    public static double getDouble() throws KeyboardInputException
    {
        Double x;
        String str="";
        try 
        {
            str=bufferedReader.readLine();
            x=Double.parseDouble(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid double value :"+str);
        }
        return x;
    }

    public static float getFloat() throws KeyboardInputException
    {
        Float x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            x=Float.parseFloat(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        catch(NumberFormatException numberFormatException)
        {
            throw new KeyboardInputException("Invalid float valie :"+str);
        }
        return x;
    }

    public static char getChar() throws KeyboardInputException
    {
        char x;
        String str="";
        try
        {
            x=(char)bufferedReader.read();
            while(bufferedReader.ready()) bufferedReader.read();
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        return x;
    }

    public static boolean getBoolean() throws KeyboardInputException
	{
        boolean x;
        String str="";
        try
        {
            str=bufferedReader.readLine();
            String str2=str; 
            str2=str2.trim().toUpperCase(); // a new String objectt will be created trim to cut spaces 
            if(str2.equals("TRUE")==false && str2.equals("FALSE")==false)
            {
                throw new KeyboardInputException("Invalid boolean value : "+str);
            }
            x=Boolean.parseBoolean(str);
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        return x;				
    }

    public static String getString() throws KeyboardInputException
    {
        String str;
        try
        {
            str=bufferedReader.readLine();
        }
        catch(IOException ioException)
        {
            throw new KeyboardInputException(ioException.getMessage());
        }
        return str;
    }

    public static long getLong(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getLong();
    }

    public static int getInt(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getInt();
    }

    public static short getShort(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getShort();
    }

    public static byte getByte(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getByte();
    }

    public static double getDouble(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getDouble();
    }

    public static float getFloat(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getFloat();
    }

    public static char getChar(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getChar();
    }

    public static boolean getBoolean(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getBoolean();
    }

    public static String getString(String prompt) throws KeyboardInputException
    {
        System.out.println(prompt);
        return getString();
    }
}
