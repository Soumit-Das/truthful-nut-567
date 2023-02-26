package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.Engineer;
import com.masaischool.DTO.Problems;
import com.masaischool.Exception.NoEngineerFoundException;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public interface HOD_Operation {

	public void RegisternewEngineer(Engineer ex)throws SomeThingWentWrongException;
	public List<Engineer> getallEngineer()throws NoEngineerFoundException,SomeThingWentWrongException;
	public void DeleteEmployee(String username)throws SomeThingWentWrongException;
	public List<Problems> getallProblems()throws NoProblemsFoundException,SomeThingWentWrongException;
    public void assignProblemToEngineer(Problems px) throws NoProblemsFoundException,SomeThingWentWrongException;
    
}
