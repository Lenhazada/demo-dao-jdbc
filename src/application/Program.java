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

		IO.println("---- TEST 1: seller findById ----");
		Seller seller = sellerDao.findById(3);
		IO.println(seller);

		IO.println("\n---- TEST 2: seller findByDepartment ----");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			IO.println(obj);
		}
		
		IO.println("\n---- TEST 3: seller findAll ----");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			IO.println(obj);
		}

		IO.println("\n---- TEST 4: seller insert ----");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		IO.println("Inserted! New id = "+ newSeller.getId());
		
		IO.println("\n---- TEST 5: seller update ----");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		IO.println("Update completed");
		
		
		
	}

}
