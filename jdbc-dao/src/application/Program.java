package application;

import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(1);
		
		System.out.println("-- TEST 1: FIND SELLER BY ID --");
		System.out.println(seller);
		
		Department dep = new Department(1, "Computers");
		List<Seller> byDepartmentList = sellerDao.findByDepartment(dep);
		
		System.out.println("\n-- TEST 2: FIND SELLER BY DEPARTMENT --");
		for (Seller s : byDepartmentList) {
			System.out.println(s);
		}
		
		List<Seller> fullList = sellerDao.findAll();
		System.out.println("\n-- TEST 3: FIND ALL --");
		for (Seller s : fullList) {
			System.out.println(s);
		}
		
		System.out.println("\n-- TEST 4: INSERT --");
		Seller newSeller = new Seller(null, "Ethan", "ethan@gmail.com", LocalDate.parse("2004-08-27"), 2499.99, dep);
		System.out.println(sellerDao.insert(newSeller));
		
		System.out.println("\n-- TEST 5: UPDATE --");
		seller = sellerDao.findById(6);
		seller.setName("Mark");
		System.out.println(sellerDao.update(seller));
		
		System.out.println("\n-- TEST 6: DELETE --");
		System.out.println(sellerDao.deleteById(5));
	}
}
