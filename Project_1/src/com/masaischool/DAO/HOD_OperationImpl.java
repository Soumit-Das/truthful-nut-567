package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.Engineer;
import com.masaischool.DTO.EngineerImpl;
import com.masaischool.DTO.Problems;
import com.masaischool.DTO.ProblemsImpl;
import com.masaischool.Exception.NoEngineerFoundException;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public class HOD_OperationImpl implements HOD_Operation {

	@Override
	public void RegisternewEngineer(Engineer ex) throws SomeThingWentWrongException {
		// Register with INSERT QUERY
       
		Connection connection = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
            final String insert_query = "INSERT INTO engineer (username,password,category)VALUES(?,?,?)";
			
            PreparedStatement ps = connection.prepareStatement(insert_query);
            
            ps.setString(1, ex.getUsername());
            ps.setString(2, ex.getPassword());
            ps.setString(3, ex.getCategory());
            
            System.out.println(ps.executeUpdate() > 0?"Engineer added successfully":"Engineer not added");
            
            
            
		}catch(SQLException ep) {
			throw new SomeThingWentWrongException();
		}finally {
			try {
				DButils.CloseConnection(connection);
			}catch(SQLException e) {
				throw new SomeThingWentWrongException();
			}
		}
		
		
	}

	private boolean isResultsetEmpty(ResultSet rs)throws SQLException {
			return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;	
	}
	
	private List<Engineer> getResultSet(ResultSet rs)throws SQLException{
		
		List<Engineer> list = new ArrayList<>();
		
		while(rs.next()) {
			
			Engineer eg = new EngineerImpl();
			eg.setUsername(rs.getString("username"));
			eg.setPassword(rs.getString("password"));
			eg.setCategory(rs.getString("category"));
			list.add(eg);
			
		}	
		return list;
	}
	
	
	private List<Problems> getProblemsResultSet(ResultSet ps)throws SQLException{
		
		List<Problems> listP = new ArrayList<>();
		
		while(ps.next()) {
			
			Problems pg = new ProblemsImpl();
			pg.setEmployee_id(ps.getInt("Employee_id"));
			pg.setEngineer_name(ps.getString("Engineer"));
			pg.setProblem_id(ps.getInt("Problem_id"));
			pg.setProblem(ps.getString("Problem"));
			pg.setStatus(ps.getString("Status"));
			listP.add(pg);
			
		}	
		return listP;
	}
	
	@Override
	public List<Engineer> getallEngineer() throws NoEngineerFoundException, SomeThingWentWrongException {
		// Get all with SELECT QUERY
		
		Connection connection = null;
		List<Engineer> list = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
			final String Select_query = "SELECT * FROM engineer";
			
			PreparedStatement ps = connection.prepareStatement(Select_query);
			
			ResultSet resultset = ps.executeQuery();
			
			if(isResultsetEmpty(resultset)) {
				throw new NoEngineerFoundException("No Engineer Found");
			}else {
				
				list = getResultSet(resultset);
			}
			
			
			
		}catch(SQLException es) {
			throw new NoEngineerFoundException("");
		}
		finally {
			try {
				DButils.CloseConnection(connection);
			}catch(SQLException es) {
				throw new NoEngineerFoundException("");
			}
		}
		
		return list;
	}

	@Override
	public void DeleteEngineer(String username) throws SomeThingWentWrongException {
		// Use DELETE query
		
		Connection connection = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
			final String Delete_query = "DELETE FROM engineer WHERE username = ?";
			
			PreparedStatement ps = connection.prepareStatement(Delete_query);
			
			ps.setString(1, "username");
			
			ps.executeUpdate();
			
		}catch(SQLException sx) {
			throw new SomeThingWentWrongException();
		}finally {
			try {
                 DButils.CloseConnection(connection);
			}catch(SQLException sx) {
				throw new SomeThingWentWrongException();
			}
		}
		

	}

	@Override
	public List<Problems> getallProblems() throws NoProblemsFoundException, SomeThingWentWrongException {
		// get data from problems table
		
		Connection connection = null;
		List<Problems> listP = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
			final String AllProblem_query = "SELECT Problem FROM Problems";
			
			PreparedStatement ps = connection.prepareStatement(AllProblem_query);
			
			ResultSet resultset = ps.executeQuery();
			
			if(isResultsetEmpty(resultset)) {
				throw new NoProblemsFoundException("");
			}else{
				listP = getProblemsResultSet(resultset);
				
			}
			
			
			
		}catch(SQLException sx) {
			throw new NoProblemsFoundException("");
		}
		finally {
			try {
				
                   DButils.CloseConnection(connection);
				
			}catch(SQLException sx) {
				throw new NoProblemsFoundException("");
			}
		}
		
		return listP;
	}

	@Override
	public void assignProblemToEngineer(Problems px) throws NoProblemsFoundException, SomeThingWentWrongException {
		// Not completed

	}

}
