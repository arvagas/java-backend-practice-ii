package com.lambdaschool.usermodel.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "userroles")
@IdClass(UserRoleId.class)
public class UserRoles implements Serializable {
  @Id
  @ManyToOne
  @JoinColumn(name = "userid")
  @JsonIgnoreProperties(value = "roles", allowSetters = true)
  private User user;

  @Id
  @ManyToOne
  @JoinColumn(name = "roleid")
  @JsonIgnoreProperties(value = "users", allowSetters = true)
  private Role role;

  public UserRoles() {
  }

  public UserRoles(User user, Role role) {
    this.user = user;
    this.role = role;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserRoles that = (UserRoles) o;
    return  ((this.getUser() == null) ? 0 : this.getUser().getUserid()) ==
            ((that.getUser() == null) ? 0 : that.getUser().getUserid()) &&
            ((this.getRole() == null) ? 0 : this.getRole().getRoleid()) ==
            ((that.getRole() == null) ? 0 : that.getRole().getRoleid());
  }

  @Override
  public int hashCode() {
    // return Objects.hash(user, role);
    return 1;
  }
}
