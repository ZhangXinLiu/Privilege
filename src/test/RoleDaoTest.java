package test;

import dao.RoleDao;
import domain.Role;
import org.junit.Test;

import java.util.List;

/**
 * Created by ozc on 2017/3/9.
 */
public class RoleDaoTest {


    RoleDao roleDao = new RoleDao();

    @Test
    public void add() {

        Role role = new Role();
        role.setId("4");
        role.setName("customer");
        role.setDescription("this is a manager");

        roleDao.add(role);
    }
    @Test
    public void find( ) {

        String id = "1";
        Role role = roleDao.find(id);

        System.out.println(role.getName());

    }

    @Test
    public void getAdd() {

        List<Role> roleList = roleDao.getAll();

        for (Role role : roleList) {

            System.out.println(role.getName());
        }
    }


}
