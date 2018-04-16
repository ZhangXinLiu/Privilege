package service;

import dao.PrivilegeDao;
import domain.Privilege;

import java.util.List;

/**
 * Created by ozc on 2017/3/9.
 */
public class PrivilegeService {

    PrivilegeDao privilegeDao = new PrivilegeDao();

    //添加权限
    public void addPrivilege(Privilege privilege) {
        privilegeDao.addPrivilege(privilege);
    }

    //根据id获得权限
    public Privilege findPrivilege(String id) {
        return privilegeDao.findPrivilege(id);
    }

    //获取所有的权限
    public List<Privilege> getAllPrivileges() {
        return privilegeDao.getAllPrivileges();
    }
}
