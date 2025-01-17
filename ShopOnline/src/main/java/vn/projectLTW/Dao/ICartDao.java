package vn.projectLTW.Dao;

import vn.projectLTW.model.Cart;

import java.util.List;

public interface ICartDao {
	void insert(Cart cart);
	void update(Cart cart);
	void delete(String id);
	void updateStatus(String id,int st);
	Cart findOne(String id);
	List<Cart> findAll();
	List<Cart> findAllByUser(int id);
	int countByUser(int id);
	int countByStatus(int id, int status);

	List<Cart> allOrder();
	List<Cart> orderByMonth(int month,int year);
	int countToTalOrder();
	double totalRevenue();
	double revenueByMonth(int month,int year);

    int countOrderByMonth(int month, int year);

//    String bestSeller(int month, int year);
}
