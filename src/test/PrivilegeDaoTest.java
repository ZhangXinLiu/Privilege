package test;

import dao.PrivilegeDao;
import domain.Privilege;
import org.junit.Test;

import java.util.List;


/**
 * Created by ozc on 2017/3/8.
 */
public class PrivilegeDaoTest {

    PrivilegeDao privilegeDao = new PrivilegeDao();

    @Test
    public void add() {

        Privilege privilege = new Privilege("4", "看账单", "看账单");

        privilegeDao.addPrivilege(privilege);

    }

    @Test
    public void getAll() {
        List<Privilege> list = privilegeDao.getAllPrivileges();

        for (Privilege privilege : list) {

            System.out.println(privilege.getId());
        }
    }

    @Test
    public void find() {
        String id = "2";

        Privilege privilege = privilegeDao.findPrivilege(id);

        System.out.println(privilege.getName());

    }
}
