package com.wipro.eb.exception;

@SuppressWarnings("serial")
public class InvalidReadingException extends Exception{
	public InvalidReadingException(String str)
	{
		super(str);
	}
	public String toString()
	{
		return "Incorrect Reading";
	}
}
