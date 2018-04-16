package dao;

import domain.Privilege;
import domain.Role;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.util.List;

/**
 * Created by ozc on 2017/3/8.
 */
public class UserDao {

    public void addUser(User user) {

        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "INSERT INTO user (id,username,password) VALUES(?,?,?)";

            queryRunner.update(sql, new Object[]{user.getId(), user.getUsername(), user.getPassword()});


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加权限失败了！");
        }

    }

    public User login(String username, String password) {

        try {
            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            User user = (User) queryRunner.query(sql, new BeanHandler(User.class), new Object[]{username, password});

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("登陆失败了！！");
        }
    }

    public User find(String id) {
        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

            String sql = "SELECT * FROM user WHERE id=?";
            User user = (User) queryRunner.query(sql, new BeanHandler(User.class), new Object[]{id});

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加权限失败了！");
        }

    }

    public List<User> getAll() {
        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

            String sql = "SELECT * FROM user";
            List<User> users = (List<User>) queryRunner.query(sql, new BeanListHandler(User.class));

            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加权限失败了！");
        }
    }


    /*得到用戶的所有角色*/
    public List<Role> getRoles(String user_id) {

        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

            //根據用戶id查詢所有角色，重點就在角色上，所以要有role表。然后查詢user_role表，就可以鎖定用戶id對應的角色了！
            String sql = "SELECT r.* FROM role r, user_role ur WHERE ur.user_id = ? AND r.id = ur.role_id ";

            List<Role> roles = (List<Role>) queryRunner.query(sql, new BeanListHandler(Role.class), new Object[]{user_id});

            return roles;
        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("得到用戶所有的角色失败了！");
        }

    }

    //更新用戶的角色
    public void updateRole(User user, List<Role> roles) {

        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

            //先把用戶原來的所有角色刪掉了
            String delete = "DELETE FROM user_role WHERE user_id = ?";
            queryRunner.update(delete, user.getId());


            String add = "INSERT INTO user_role (user_id,role_id) VALUES(?,?)";
            for (Role role : roles) {
                queryRunner.update(add, new Object[]{user.getId(), role.getId()});
            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("添加权限失败了！");
        }

    }



}
