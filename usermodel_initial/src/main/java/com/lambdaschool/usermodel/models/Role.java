package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the roles table.
 */
@Entity
@Table(name = "roles")
public class Role extends Auditable
{
    /**
     * The primary key (long) of the roles table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    /**
     * The name (String) of the role. Cannot be null and must be unique.
     */
    @Column(nullable = false,
            unique = true)
    private String name;


    /**
     * Creates a join table joining Users and Roles in a Many-To-Many relations.
     * Contains a List of Users Objects using this Role.
     */
    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties(value = "roles")
    private Set<User> users = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Role()
    {
    }

    /**
     * Given the name, create a new role object. User gets added later
     *
     * @param name the name of the role in uppercase
     */
    public Role(String name)
    {
        this.name = name.toUpperCase();
    }

    /**
     * Getter for role id
     *
     * @return the role id, primary key, (long) of this role
     */
    public long getRoleid()
    {
        return roleid;
    }

    /**
     * Setter for role id, used for seeding data
     *
     * @param roleid the new role id, primary key, (long) for this role
     */
    public void setRoleid(long roleid)
    {
        this.roleid = roleid;
    }

    /**
     * Getter for role name
     *
     * @return role name (String) in uppercase
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for role name
     *
     * @param name the new role name (String) for this role, in uppercase
     */
    public void setName(String name)
    {
        this.name = name.toUpperCase();
    }

    /**
     * Getter for list of users for this role
     *
     * @return a list of User objects assigned to this role
     */
    public Set<User> getUsers()
    {
        return users;
    }

    /**
     * Setter for list of users for this role
     *
     * @param users a new list of User objects to assign to this role
     */
    public void setUsers(Set<User> users)
    {
        this.users = users;
    }
}
