package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ozc on 2017/3/8.
 */

public class User {

    private String id;
    private String username;
    private String password;

    //记住角色
    private Set<Role> roles = new HashSet<>();

    //各种getter和setter.....


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void setUsername(String username) {
        this.username = username;
    }




}


