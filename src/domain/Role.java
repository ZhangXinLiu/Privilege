package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ozc on 2017/3/8.
 */
public class Role {
    private String id;
    private String name;
    private String description;

    //记住所有的权限
    private Set<Privilege> privileges = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
