package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		IO.println("---- TEST 1: findById ----");
		Department department = departmentDao.findById(1);
		IO.println(department);

		IO.println("\n---- TEST 2: findAll ----");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			IO.println(d);
		}
		
		IO.println("\n---- TEST 3: insert ----");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		IO.print("Inserted! New id: "+ newDepartment.getId());
		
		sc.close();
	}

}
