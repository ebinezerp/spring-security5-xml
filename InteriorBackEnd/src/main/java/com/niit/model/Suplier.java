package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Suplier 
{
	@Id
	@GeneratedValue
	private int suplierId;
	
	private String suplierName;
	private String suplierDesc;
	
	public int getsuplierId() 
	{
		return suplierId;
	}
	public void setsuplierId(int suplierId) 
	{
		this.suplierId = suplierId;
	}
	public String getsuplierName() 
	{
		return suplierName;
	}
	public void setsuplierName(String suplierName) 
	{
		this.suplierName = suplierName;
	}
	public String getsuplierDesc() 
	{
		return suplierDesc;
	}
	public void setSuplierDesc(String suplierDesc) 
	{
		this.suplierDesc = suplierDesc;
	}
}