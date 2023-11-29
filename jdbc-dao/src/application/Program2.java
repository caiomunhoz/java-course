package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = depDao.findById(1);
		System.out.println("-- TEST 1: FIND DEPARTMENT BY ID --");
		System.out.println(dep);
		
		List<Department> list = depDao.findAll();
		System.out.println("\n-- TEST 2: FIND ALL --");
		for (Department department : list) {
			System.out.println(department);
		}
		
		Department newDep = new Department(null, "Food");
		depDao.insert(newDep);
		
		Department furnitureDep = new Department(2, "Furniture");
		depDao.update(furnitureDep);
		
		depDao.deleteById(9);
		
	}

}
