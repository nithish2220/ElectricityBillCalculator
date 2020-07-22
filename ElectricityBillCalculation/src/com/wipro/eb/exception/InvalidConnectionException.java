package com.wipro.eb.exception;

@SuppressWarnings("serial")
public class InvalidConnectionException extends Exception {
	public InvalidConnectionException(String str)
	{
		super(str);
	}
	public String toString()
	{
		return "Invalid Connection Type";
	}
}
