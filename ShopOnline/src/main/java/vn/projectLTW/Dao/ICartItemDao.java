package vn.projectLTW.Dao;

import vn.projectLTW.model.CartItem;

import java.util.List;


public interface ICartItemDao {
	
	
	void insert(CartItem cartItem);
	void update(CartItem cartItem);
	void delete(String id);
	CartItem findOne(String id);
	List<CartItem> findAll();
	List<CartItem> findAllByUser(int id);
	List<CartItem> findAllByUserId(int id);
	List<CartItem> findAllByUserPaging(int id,int index);

	
	int countByUser(int id);
	List<CartItem> findAllSeller(int id);

}
