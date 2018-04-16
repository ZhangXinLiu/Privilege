package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by ozc on 2017/3/8.
 */
public class UserDaoTest {

    UserDao userDao = new UserDao();

    @Test
    public void add() {

        User user = new User();
        user.setId("2");
        user.setUsername("qqq");
        user.setPassword("123");
        userDao.addUser(user);


    }

    @Test
    public void find() {

        String id = "1";
        User user = userDao.find(id);

        System.out.println(user.getUsername());
    }

    @Test
    public void findALL() {

        List<User> userList = userDao.getAll();

        for (User user : userList) {

            System.out.println(user.getUsername());
        }

    }

}
