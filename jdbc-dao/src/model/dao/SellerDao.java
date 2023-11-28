package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	String insert(Seller obj);

	String update(Seller obj);

	String deleteById(Integer id);

	Seller findById(Integer id);
	
	List<Seller> findByDepartment(Department dep);
	
	List<Seller> findAll();
}
