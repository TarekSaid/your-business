package br.com.tarek.your.business.models;

import org.hibernate.validator.constraints.NotBlank;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by tarek on 25/12/15.
 */
@NodeEntity
public class Business {

  @GraphId
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

  private String tradeName;

  @Index(unique = true)
  @NotBlank
  @Size(max = 255)
  @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
      flags = Pattern.Flag.CASE_INSENSITIVE)
  private String email;

  @NotBlank
  @Size(max = 60)
  private String password;

  private String role;

  public Business() {
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
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
