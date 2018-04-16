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
public class RoleDao {

    public void add(Role role){

        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into role(id,name,description) values(?,?,?)";
            Object params[] = {role.getId(),role.getName(),role.getDescription()};
            runner.update(sql, params);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Role find(String id){

        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from role where id=?";
            return (Role) runner.query(sql, id, new BeanHandler(Role.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //得到所有角色
    public List<Role> getAll(){
        try{

            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from role";
            return (List<Role>) runner.query(sql, new BeanListHandler(Role.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //得到某角色的所有權限【權限表、權限和角色關系表】
    public List<Privilege> getPrivileges(String role_id) {
        try{

            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

            String sql = "SELECT p.* FROM privilege p, role_privilege rp WHERE rp.role_id = ? AND p.id = rp.privilege_id";

            List<Privilege> privileges = (List<Privilege>) runner.query(sql, new BeanListHandler(Privilege.class), new Object[]{role_id});

            return privileges;


        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //为某个角色授权
    public void addPrivilege2Role(Role role, List<Privilege> privileges) {

        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());


            //先刪除該角色的所有權限
            String delete = "DELETE FROM role_privilege WHERE role_id = ?";
            runner.update(delete, new Object[]{role.getId()});

            //賦予角色新的權限
            String sql = "INSERT INTO role_privilege (role_id, privilege_id) VALUES (?, ?)";
            for (Privilege privilege : privileges) {
                runner.update(sql, new Object[]{role.getId(), privilege.getId()});
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
