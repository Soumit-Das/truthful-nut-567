package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.Engineer;
import com.masaischool.Exception.NoEngineerFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public interface EngineerOperation {

	public void RegisternewEngineer(Engineer ex)throws SomeThingWentWrongException;
	public List<Engineer> getallEngineer()throws NoEngineerFoundException,SomeThingWentWrongException;
	public void DeleteEmployee(String username)throws SomeThingWentWrongException;
//	public List<Problems> getallProblems()throws NoEngineerFoundException,SomeThingWentWrongException;
//    public
}
