package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.Engineer;
import com.masaischool.DTO.Problems;
import com.masaischool.Exception.NoEngineerFoundException;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public class HOD_OperationImpl implements HOD_Operation {

	@Override
	public void RegisternewEngineer(Engineer ex) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Engineer> getallEngineer() throws NoEngineerFoundException, SomeThingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteEmployee(String username) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Problems> getallProblems() throws NoProblemsFoundException, SomeThingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignProblemToEngineer(Problems px) throws NoProblemsFoundException, SomeThingWentWrongException {
		// TODO Auto-generated method stub

	}

}
