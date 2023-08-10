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
		
		System.out.println("TESTE N1 :: department findById");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		
		System.out.println("\n TESTE N2 :: department findAll");
		List<Department> list = departmentDao.findAll();
	
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE N3 :: department insert");
		Department newDepartment = new Department(null, "Novo Departamento");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted!");
		
		
		System.out.println("\n TESTE N4 :: department update");
		department = departmentDao.findById(1);
		department.setName("Novo Departamento 2");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n TESTE N5 :: department delete");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted");
		sc.close();
		
		
	}

}
