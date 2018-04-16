package dao;

import domain.Privilege;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.util.List;

/**
 * Created by ozc on 2017/3/8.
 */

/**
* 权限的管理应该有以下的功能：
* 1.添加权限
* 2.查看所有权限
* 3.查找某个权限
*
* */

public class PrivilegeDao {

    /*添加权限*/
    public void addPrivilege(Privilege privilege) {
        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "INSERT INTO privilege (id, name, description) VALUE (?, ?, ?)";
            queryRunner.update(sql, new Object[]{privilege.getId(), privilege.getName(), privilege.getDescription()});


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加权限失败了！");
        }
    }

    /*查找权限*/
    public Privilege findPrivilege(String id) {

        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT *FROM privilege WHERE id = ?";
            Privilege privilege = (Privilege) queryRunner.query(sql, new BeanHandler(Privilege.class), new Object[]{id});

            return privilege;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查找权限失败了！");
        }
    }

    //查看所有的权限
    public List<Privilege> getAllPrivileges() {

        try {

            QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT * FROM privilege ";

            List<Privilege> privileges = (List<Privilege>) queryRunner.query(sql, new BeanListHandler(Privilege.class));

            return privileges;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查找权限失败了！");
        }
    }
}
