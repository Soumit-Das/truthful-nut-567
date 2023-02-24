package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.Problems;
import com.masaischool.DTO.ProblemsImpl;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public class Engineer_OperationImpl implements Engineer_Operation {


	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
	}
	
	private List<Problems> getProblemsfromResultSet(ResultSet rs)throws SQLException{
		
		List<Problems> list = new ArrayList<>();
		
		while(rs.next()) {
			
			Problems pg = new ProblemsImpl();
			pg.setEmployee_id(rs.getInt("Employee_id"));
			pg.setEngineer_name(rs.getString("Engineer"));
			pg.setProblem_id(rs.getInt("Problem_id"));
			pg.setProblem(rs.getString("Problem"));
			pg.setStatus(rs.getString("Status"));
			list.add(pg);
			
		}
		return list;
	}
	
	
	@SuppressWarnings("null")
	@Override
	public List<Problems> viewAssignedProblem(String Engineer_name) throws NoProblemsFoundException {
		// get problem by engineer name
		Connection connection = null;
		List<Problems> listPb = null;
		Problems enge = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
			final String viewProblems_query = "SELECT Problem_id,Problem,Status FROM Problems WHERE Engineer = ?";
			
			PreparedStatement ps = connection.prepareStatement(viewProblems_query);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				
				enge = new ProblemsImpl();
				enge.setEngineer_name(resultset.getString("Engineer_name"));
				enge.setProblem_id(resultset.getInt("Problem_id"));
				enge.setProblem(resultset.getString("Problem"));
				enge.setStatus(resultset.getString("Status"));
				listPb.add(enge);
			}
			
			
			
		}catch(SQLException e) {
			throw new NoProblemsFoundException("");
		}
		finally {
			try {
				DButils.CloseConnection(connection);
			}catch(SQLException e) {
				throw new NoProblemsFoundException("");
			}
		}
		
       return listPb;
	}

	@Override
	public void UpdateStatus(Problems px) throws SomeThingWentWrongException {
		// Use Update query
		
		Connection connection = null;
		
		try {
			
			connection = DButils.ConnectToDatabase();
			
			final String Update_query = "UPDATE PROBLEMS SET Employee_id = ?,Engineer = ?,Problem = ?,Status = ? WHERE Problem_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(Update_query);
			
			ps.setInt(1, px.getEmployee_id());
			ps.setString(2,px.getEngineer_name());
			ps.setString(3, px.getProblem());
			ps.setString(4, px.getStatus());
			ps.setInt(5, px.getProblem_id());
			
			ps.executeUpdate();
			
			
			
		}catch(SQLException es) {
			throw new SomeThingWentWrongException();
		}
		finally {
			try {
				DButils.CloseConnection(connection);
			}catch(SQLException es) {
				throw new SomeThingWentWrongException();
			}
		}

	}

	@Override
	public List<Problems> viewAllAttendedProblems() throws NoProblemsFoundException {
		// Not completed
		return null;
	}

}
