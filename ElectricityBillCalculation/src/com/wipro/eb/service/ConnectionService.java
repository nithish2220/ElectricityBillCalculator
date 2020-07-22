package com.wipro.eb.service;
import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading<previousReading || currentReading<0 || previousReading<0)
			throw new InvalidReadingException("Invalid Reading");
		if(! ( (type.equalsIgnoreCase("Domestic")) || (type.equalsIgnoreCase("Commercial")) ))
			throw new InvalidConnectionException("Invalid Exception");
		else
			return true;
	}
	@SuppressWarnings("unused")
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		try {
			boolean status=validate(currentReading,previousReading,type);
			
				if(type.equals("Domestic"))
				{
					float slabs[]= {2.3f,4.2f,5.5f};
					Domestic d=new Domestic(currentReading,previousReading,slabs);
					return d.computeBill();
				}
				else
				{
					float slabs[]= {5.2f,6.8f,8.3f};
					Commercial c=new Commercial(currentReading,previousReading,slabs);
					return c.computeBill();
				}
		}
		catch(InvalidConnectionException ie)
		{
			return -2;
		}
		catch(InvalidReadingException ie)
		{
			return -1;
		}
	}	
	public String generateBill(int currentReading, int previousReading, String type)
	{
		if((calculateBillAmt(currentReading,previousReading,type))==-1)
			return "Incorrect Reading";
		if((calculateBillAmt(currentReading,previousReading,type))==-2)
			return "Invalid ConnectionType";
	return ("Amount to be paid:"+calculateBillAmt(currentReading,previousReading,type));
	}
	
}
