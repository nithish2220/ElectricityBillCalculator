package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		// TODO Auto-generated method stub
		float billamt=0.0f;
		if(currentReading<=50)
			billamt=currentReading*slabs[0];
		if(currentReading>50 && currentReading<=100)
			billamt=currentReading*slabs[1];
		else
			billamt= (50*slabs[0])+(50*slabs[1])+((currentReading-100)*slabs[2]);
		double eduity = 0;
		if(billamt>=10000)
			eduity=billamt*0.09;
		if(billamt>=5000)
			eduity=billamt*0.06;
		else if(billamt<5000)
			eduity=billamt*0.02;
		return (float) (billamt+eduity);
	}
	

}
