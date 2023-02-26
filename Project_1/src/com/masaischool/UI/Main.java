package com.masaischool.UI;

import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.HOD_Operation;
import com.masaischool.DAO.HOD_OperationImpl;
import com.masaischool.DTO.Engineer;
import com.masaischool.DTO.EngineerImpl;
import com.masaischool.DTO.Problems;
import com.masaischool.Exception.NoEngineerFoundException;
import com.masaischool.Exception.NoProblemsFoundException;
import com.masaischool.Exception.SomeThingWentWrongException;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HOD_Operation hod = new HOD_OperationImpl();
        int choice = 0;
        
        do {
        	
        	System.out.println("1. Register New Engineer\n2. View All Engineers\n3. Delete Engineer\n4. View All Problems\n5. Assign Problem To Engineer\n0. Exit");
        	System.out.println("Enter Selection");
        	choice = sc.nextInt();
        	
        	if(choice == 1) {
        		System.out.print("Enter username ");
        		String username = sc.next();
        		System.out.print("Enter password ");
        		String password = sc.next();
        		System.out.print("Enter category ");
        		String category = sc.next();
        		
        		try {
        			
        			hod.RegisternewEngineer(new EngineerImpl(username,password,category));
        			System.out.println("added successfully");
        		}catch(SomeThingWentWrongException se) {
        			System.out.println(se);
        		}
        	}
        	else if(choice == 2) {       		
        		try {     			
        			List<Engineer> list = hod.getallEngineer();
        			for(Engineer eg : list) {
        				System.out.println(eg);
        			}       			
        		}catch(SomeThingWentWrongException | NoEngineerFoundException exc) {
        			System.out.println(exc);
        		}       		       		
        	}
        	else if(choice == 3) {
        		System.out.println("Enter the username of the Engineer you want to delete");
        		String Name = sc.next();
        		
        		try {
        			hod.DeleteEngineer(Name);
        			
        		}catch(SomeThingWentWrongException se) {
        			System.out.println(se);
        		}
        		
        	}
        	else if(choice == 4) {
        		
        		try {
        			List<Problems> list = hod.getallProblems();
        			for(Problems pb:list) {
        				System.out.println(pb);
        			}
        		}catch(SomeThingWentWrongException | NoProblemsFoundException ex) {
        			System.out.println(ex);
        		}
        		
        	}
        	       	
        }while(choice != 0);
		sc.close();
		
		if(choice == 0) {
			System.out.println("Thank you , visit again");
		}
	}
	
}
