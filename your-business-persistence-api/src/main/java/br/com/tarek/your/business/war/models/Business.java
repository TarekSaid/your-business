package br.com.tarek.your.business.war.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Objects;

/**
 * Created by tarek on 25/12/15.
 */
@NodeEntity
public class Business {

  @GraphId
  private Long id;

  private String name;

  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Business business = (Business) o;
    return Objects.equals(id, business.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
