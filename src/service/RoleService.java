package service;

import dao.RoleDao;
import domain.Privilege;
import domain.Role;
import domain.User;

import java.util.List;

/**
 * Created by ozc on 2017/3/9.
 */
public class RoleService {

    RoleDao roleDao = new RoleDao();

    //添加角色
    public void addRole(Role role) {

        roleDao.add(role);
    }

    //根据id查找角色
    public Role findRole(String id) {
        return roleDao.find(id);
    }

    //获取所有的角色
    public List<Role> getAllRole() {
        return roleDao.getAll();
    }

    //获取角色所有的权限
    public List<Privilege> getRolePrivilege(String role_id) {
        return roleDao.getPrivileges(role_id);
}

    //修改角色的权限
    public void updateRolePrivilege(Role role, List<Privilege> privileges) {
        roleDao.addPrivilege2Role(role, privileges);
    }


}
