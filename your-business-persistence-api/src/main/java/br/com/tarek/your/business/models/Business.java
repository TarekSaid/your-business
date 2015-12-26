package br.com.tarek.your.business.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by tarek on 25/12/15.
 */
@NodeEntity
public class Business {

  @GraphId
  private Long id;

  @NotNull
  private String name;

  private String tradeName;

  @Index(unique = true)
  @NotNull
  private String email;

  public Business() {}

  public Business(String name, String email) {
    this.name = name;
    this.email = email;
  }

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

  public String getTradeName() {
    return tradeName;
  }

  public void setTradeName(String tradeName) {
    this.tradeName = tradeName;
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
    return Objects.equals(getEmail(), business.getEmail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmail());
  }
}
