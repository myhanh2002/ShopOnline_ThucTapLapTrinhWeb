package vn.projectLTW.Dao.Impl;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.IUserDao;
import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.UserRoles;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.IUserRoleService;
import vn.projectLTW.service.Impl.UserRoleServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    IUserRoleService userRoleService = new UserRoleServiceImpl();// lấy dữ liệu từ UserRole

    @Override
    public List<Users> findAll() {
        // TODO Auto-generated method stub
        List<Users> userList = new ArrayList<Users>();
        String sql = "SELECT users.userId,users.email,users.fullName,users.images,users.userName,users.passWord,\r\n"
                + "		users.phone,users.status,user_roles.roleName,user_roles.roleId\r\n"
                + "FROM users INNER JOIN user_roles \r\n" + "ON users.roleId=user_roles.roleId\r\n";

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement

            rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

            while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng

                UserRoles userRoles = userRoleService.findOne(rs.getInt("roleId"));
                Users user = new Users();

                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("userName"));
                user.setFullName(rs.getString("fullName"));
                user.setPassWord(rs.getString("passWord"));
                user.setImages(rs.getString("images"));
//				user.setCode(rs.getInt("code"));
                user.setPhone(rs.getString("phone"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoles(userRoles);
                user.setStatus(rs.getInt("status"));

                userList.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public Users findOne(int id) {
        List<Users> userList = new ArrayList<Users>();
        String sql = "SELECT users.userId,users.email,users.fullName,users.images,users.userName,users.passWord,\r\n"
                + "		users.phone,users.status,user_roles.roleName,user_roles.roleId\r\n"
                + "FROM users INNER JOIN user_roles \r\n" + "ON users.roleId=user_roles.roleId\r\n"
                + "WHERE users.userId=?";

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, id);
            rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

            while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng

                UserRoles userRoles = userRoleService.findOne(rs.getInt("roleId"));
                Users user = new Users();

                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("userName"));
                user.setFullName(rs.getString("fullName"));
                user.setPassWord(rs.getString("passWord"));
                user.setImages(rs.getString("images"));
//				user.setCode(rs.getInt("code"));
                user.setPhone(rs.getString("phone"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoles(userRoles);
                user.setStatus(rs.getInt("status"));

                return user;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public UserGG findOneGG(String id) {
        List<UserGG> userGGList = new ArrayList<UserGG>();
        String sql = "SELECT user_gg.id,user_gg.userGGId,user_gg.email,user_roles.roleName,user_roles.roleId\n" +
                "\t\t\tFROM user_gg INNER JOIN user_roles ON user_gg.roleId=user_roles.roleId\n" +
                "            where user_gg.userGGId=?";

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, id);
            rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

            while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng

                UserRoles userRoles = userRoleService.findOne(rs.getInt("roleId"));
                UserGG user = new UserGG();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserGGId(rs.getString("userGGId"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoles(userRoles);


                return user;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Users findOne(String userName) {
        // TODO Auto-generated method stub
        List<Users> userList = new ArrayList<Users>();
        String sql = "SELECT users.userId,users.email,users.fullName,users.images,users.userName,users.passWord,\r\n"
                + "		users.phone,users.status,user_roles.roleName,user_roles.roleId\r\n"
                + "FROM users INNER JOIN user_roles \r\n" + "ON users.roleId=user_roles.roleId\r\n"
                + "WHERE users.userName=?";

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, userName);
            rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

            while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng

                UserRoles userRoles = userRoleService.findOne(rs.getInt("roleId"));
                Users user = new Users();

                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("userName"));
                user.setFullName(rs.getString("fullName"));
                user.setPassWord(rs.getString("passWord"));
                user.setImages(rs.getString("images"));
//				user.setCode(rs.getInt("code"));
                user.setPhone(rs.getString("phone"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoles(userRoles);
                user.setStatus(rs.getInt("status"));

                return user;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void insert(Users user) {

        String sql = "INSERT INTO users(email,userName,fullName,passWord,images,phone,status,roleId)\r\n"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getImages());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getStatus());
            ps.setInt(8, user.getRoles().getRoleId());
//			ps.setInt(9, user.getSellers().getSelelrId());
//			ps.setInt(10, user.getCode());
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    @Override
    public void update(Users user) {
        // TODO Auto-generated method stub
        String sql = "UPDATE  users SET email=?,userName=?,fullName=?,passWord=?,images=?,phone=?,status=?,roleId=? "
                + "WHERE userId=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getImages());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getStatus());
            ps.setInt(8, user.getRoles().getRoleId());
//			ps.setInt(9, user.getSellers().getSelelrId());
//			ps.setInt(10, user.getCode());
            ps.setInt(9, user.getUserId());
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users where userId=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    @Override
    public boolean checkExistEmail(String email) {
        // TODO Auto-generated method stub
        boolean duplicate = false;
        String sql = "SELECT * FROM users WHERE email=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return duplicate;
    }

    @Override
    public boolean checkExistUserName(String userName) {
        boolean duplicate = false;
        String sql = "SELECT * FROM users WHERE userName=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public void insertRegister(Users user) {
        String sql = "INSERT INTO users(email,userName,fullName,passWord,status,roleId,code)VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setInt(5, user.getStatus());
            ps.setInt(6, user.getRoleId());
            ps.setString(7, user.getCode());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertRegisterGG(UserGG userGG) {
        String sql = "INSERT INTO user_gg(userGGId,email,roleId,status)VALUES(?,?,?,?)";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement

            ps.setString(1, userGG.getUserGGId());
            ps.setString(2, userGG.getEmail());
            ps.setInt(3, userGG.getRoleId());
            ps.setInt(4, 1);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(Users user) {
        String sql = "UPDATE users SET status=?, code=?, WHERE email=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, user.getStatus());
            ps.setString(2, user.getCode());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatusGG(UserGG user) {
        String sql = "UPDATE user_gg SET status=?, WHERE email=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, user.getStatus());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(int Id, String newPass) {
        String sql = "UPDATE users SET passWord = ? WHERE userId = ?";

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, newPass);
            ps.setInt(2, Id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkOldPassword(int Id, String oldPass) {
        String sql = "SELECT COUNT(*) AS count FROM users WHERE userId = ? AND passWord = ?";
        boolean isCorrect = false;

        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, Id);
            ps.setString(2, oldPass);
            ps.executeQuery();
            rs = ps.getResultSet();
            if (rs.next() && rs.getInt("count") == 1) {
                isCorrect = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCorrect;
    }

    @Override
    public int getLoginAttempts(String userName) {
        int loginAttempts = 0;
        String sql = "SELECT loginAttempts FROM users WHERE userName = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                loginAttempts = rs.getInt("loginAttempts");
            }
        } catch (Exception e) {
            // Handle the exception
        } finally {
            // Close connections and statements
        }
        return loginAttempts;
    }

    @Override
    public void updateLoginAttempts(String userName, int loginAttempts) {
        String sql = "UPDATE users SET loginAttempts = ? WHERE userName = ? LIMIT 1";//Sử dụng mệnh đề LIMIT trong câu lệnh UPDATE để giới hạn số bản ghi cần cập nhật là một.
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setInt(1, loginAttempts);
            ps.setString(2, userName);
            ps.executeUpdate();
            rs = ps.getResultSet();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Date getAccountLockedUntil(String userName) {
        Date lockedUntil = null;
        String sql = "SELECT lockedUntil FROM users WHERE userName = ?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                lockedUntil = rs.getTimestamp("lockedUntil");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lockedUntil;
    }

    @Override
    public void setAccountLockedUntil(String userName, Date unlockTime) {
        String sql = "UPDATE users SET lockedUntil = ? WHERE userName = ? LIMIT 1";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setTimestamp(1, new java.sql.Timestamp(unlockTime.getTime()));
            ps.setString(2, userName);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void changeProfile(int Id, String fullname, String email, String phone) {
        String sql = "UPDATE users SET fullName=?, email=?, phone=? WHERE userId=?";
        try {
            conn = new DBConnection().getConnection(); // Kết nối CSDL
            ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
            ps.setString(1,fullname);
            ps.setString(2, email);
            ps.setString(3,phone);
//            ps.setString(4,province);
//            ps.setString(5,district);
//            ps.setString(6,address);
            ps.setInt(4,Id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

