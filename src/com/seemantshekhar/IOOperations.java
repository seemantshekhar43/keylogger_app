package com.seemantshekhar;

public interface IOOperations
{
	public void initWriter(String fileName);
	public void writeString(String content);
	public void closeWriter();
	public void writeChar(int c);	
	public void writeEnter();
}
