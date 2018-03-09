package com.niit.dao;

import java.util.List;
import com.niit.model.Suplier;
public interface SuplierDAO 
{
	public boolean addSuplier(Suplier suplier);
	public Suplier getSuplier(int suplierId);
	public boolean deleteSuplier(Suplier suplier);
	public boolean updateSuplier(Suplier Suplier);
	public List<Suplier> getsupliers();
	
}
