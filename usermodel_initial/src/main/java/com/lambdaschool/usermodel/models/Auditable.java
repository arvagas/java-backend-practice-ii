package com.lambdaschool.usermodel.models;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // when object is created/modified, alerts other entities to rescan db
public abstract class Auditable { // should never have an obj that is auditable, so we have it extended by other classes
  @CreatedBy
  protected String createdby;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createddate;

  @LastModifiedBy
  protected String lastmodifiedby;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastmodifieddate;

  // public String getCreatedBy() {
  //   return createdby;
  // }

  // public Date getCreateddate() {
  //   return createddate;
  // }

  // public String getLastmodifiedby() {
  //   return lastmodifiedby;
  // }

  // public Date getLastmodifieddate() {
  //   return lastmodifieddate;
  // }
}
