package com.masaischool.DTO;

public class ProblemsImpl implements Problems {

	private int Employee_id;
	private String Engineer_name;
	private int Problem_id;
	private String Problem;
	private String Status;
	
	public ProblemsImpl() {};
	
	public ProblemsImpl(int employee_id, String engineer_name, int problem_id, String problem, String status) {
		super();
		Employee_id = employee_id;
		Engineer_name = engineer_name;
		Problem_id = problem_id;
		Problem = problem;
		Status = status;
	}
    @Override
	public int getEmployee_id() {
		return Employee_id;
	}
    @Override
	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}
    @Override
	public String getEngineer_name() {
		return Engineer_name;
	}
    @Override
	public void setEngineer_name(String engineer_name) {
		Engineer_name = engineer_name;
	}
    @Override
	public int getProblem_id() {
		return Problem_id;
	}
    @Override
	public void setProblem_id(int problem_id) {
		Problem_id = problem_id;
	}
    @Override
	public String getProblem() {
		return Problem;
	}
    @Override
	public void setProblem(String problem) {
		Problem = problem;
	}
    @Override
	public String getStatus() {
		return Status;
	}
    @Override
	public void setStatus(String status) {
		Status = status;
	}

//	@Override
//	public String toString() {
//		return "ProblemsImpl [Employee_id=" + Employee_id + ", Engineer_name=" + Engineer_name + ", Problem_id="
//				+ Problem_id + ", Problem=" + Problem + ", Status=" + Status + "]";
//	}
	
	
	
	
	
}
