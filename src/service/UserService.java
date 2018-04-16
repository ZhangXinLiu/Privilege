package service;

import dao.UserDao;
import domain.Role;
import domain.User;

import java.util.List;

/**
 * Created by ozc on 2017/3/9.
 */
public class UserService {


    UserDao userDao = new UserDao();

    //添加用户
    public void addUser(User user) {

        userDao.addUser(user);
    }

    //根据id查找用户
    public User findUser(String id) {
        return userDao.find(id);
    }

    //得到所有的用户
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    //获取用户所有的角色
    public List<Role> getUserRole(String user_id) {
        return userDao.getRoles(user_id);
    }

    //修改用户的角色
    public void updateUserRole(User user, List<Role> roles) {

        userDao.updateRole(user, roles);
    }

    //登陆
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

}
