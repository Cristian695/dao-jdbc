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

		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("=== TEST 1: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 1: department insert ===");
		Department newDepartment = new Department(null, "Bikes"); 
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		department = departmentDao.findById(1);
		department.setName("Technologies");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete");
			
		sc.close();
	}

}
