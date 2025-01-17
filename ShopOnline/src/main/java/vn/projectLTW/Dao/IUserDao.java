package vn.projectLTW.Dao;

import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;

import java.util.Date;
import java.util.List;

public interface IUserDao {
	//Khai báo các hàm xử lí của Dao
	List<Users> findAll(); // hàm lấy toàn bộ User

	Users findOne(int id);
	Users findOne(String userName);// hàm lấy 1 đối tượng User theo ID

	UserGG findOneGG(String id);

	void insert(Users user); // hàm này thêm dữ liệu mới cho User


	void insertRegister(Users user);// hàm này dùng cho Register
	void insertRegisterGG(UserGG userGG);// hàm này dùng cho Register


	void update(Users user); // hàm này cập nhật đối tượng User
	
	void updateStatus(Users user);// hàm này dùng active tài khoản
	void updateStatusGG(UserGG userGG);// hàm này dùng active tài khoản
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUserName(String userName);
	void changePassword(int Id, String newPass);
	boolean checkOldPassword(int userId, String oldPass);

    int getLoginAttempts(String userName);

	void updateLoginAttempts(String userName, int loginAttempts);

	Date getAccountLockedUntil(String userName);

	void setAccountLockedUntil(String userName, Date unlockTime);

    void changeProfile(int Id, String fullname, String email, String phone);
}
