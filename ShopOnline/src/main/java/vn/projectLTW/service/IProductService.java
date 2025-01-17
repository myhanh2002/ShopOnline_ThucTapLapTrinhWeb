package vn.projectLTW.service;

import vn.projectLTW.model.Product;

import java.util.List;

public interface IProductService {
	void insert(Product product); // hàm này thêm dữ liệu mới cho User

	void update(Product product); // hàm này cập nhật đối tượng User
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	Product findOne(int id);
	
	List<Product> findAll();
	
	List<Product> findAllNews();
	
	List<Product> findAllTopAmount();
	
	List<Product> findAllByCID(int id,int index);
	
	List<Product> findAllBySeller(int id,int index);
	
	List<Product> findAllByPage(int id);

	List<Product> SearchByName(String txtSearch);
	
	int countAll();
	
	
	int countCID(int id);
	
	int countSell(int id);
	
	
	
}
