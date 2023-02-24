package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.Problems;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public interface Engineer_Operation {

	public void viewAssignedProblem(Problems px)throws NoProblemsFoundException;
	public void UpdateStatus(Problems px)throws SomeThingWentWrongException;
	public List<Problems> viewAllAttendedProblems()throws NoProblemsFoundException;
	
}
