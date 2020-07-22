package com.wipro.eb.entity;

public class Domestic extends Connection{
	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		// TODO Auto-generated method stub
		if(currentReading<=50)
			return currentReading*slabs[0];
		if(currentReading>50 && currentReading<=100)
			return currentReading*slabs[1];
		else
			return (50*slabs[0])+(50*slabs[1])+((currentReading-100)*slabs[2]);
	}
	
}
