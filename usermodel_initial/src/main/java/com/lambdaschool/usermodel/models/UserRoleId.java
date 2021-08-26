package com.lambdaschool.usermodel.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable // exists in the db, but it is embedded into accompanying class; wil lnot exist as separate table
public class UserRoleId implements Serializable {
  private long user; // application will actually look at the obj, and then go into the properties to grab id
  private long role;

  public UserRoleId() {
  }

  public UserRoleId(long user, long role) {
    this.user = user;
    this.role = role;
  }

  public long getUser() {
    return user;
  }

  public void setUser(long user) {
    this.user = user;
  }

  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserRoleId that = (UserRoleId) o;
    return user == that.user &&
            role == that.role;
  }

  @Override
  public int hashCode() {
    return 1;
  }
}
