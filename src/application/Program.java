package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("TESTE N1 :: seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println(" \n TESTE N2 :: seller findByDepartment ");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE N3 :: seller findAll");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE N4 :: seller insert");
		Seller newSeller = new Seller(null, "Lucas", "lucas@outlook.com", new Date(),4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	
		
		System.out.println("\n TESTE N5 :: seller update");
		seller = sellerDao.findById(1);
		seller.setName("Novo Nome");
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}
}
