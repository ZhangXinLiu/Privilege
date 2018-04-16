package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ozc on 2017/3/8.
 */
public class Privilege {

    private String id;
    private String name;
    private String description;

    public Privilege() {
    }

    public Privilege(String name) {
        this.name = name;
    }

    public Privilege(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        return name != null ? name.equals(privilege.name) : privilege.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

