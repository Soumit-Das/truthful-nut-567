package com.masaischool.DAO;

import com.masaischool.DTO.Employee;
import com.masaischool.DTO.Problems;
import com.masaischool.Exception.SomeThingWentWrongException;

public interface Employee_Operations {

	public void registeremployee(Employee em) throws SomeThingWentWrongException;
	public void raiseComplain(Problems pb)throws SomeThingWentWrongException;
	public void checkStatus(Problems pb)throws SomeThingWentWrongException;
	
}
