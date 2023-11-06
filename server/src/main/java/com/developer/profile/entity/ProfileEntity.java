package com.developer.profile.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tt_profile")
public class ProfileEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pro_id")
  private Long id;
  @Column(name = "pro_name")
  private String name;
  @Column(name = "pro_desc")
  private String description;
  @Column(name = "pro_birth")
  private Date date;
  @Column(name = "pro_city")
  private String city;
  @Column(name = "pro_occupation")
  private String occupation;
  @Column(name = "pro_interests")
  private String interests;

  public ProfileEntity() {
  }

  public ProfileEntity(
      Long id,
      String name,
      String description,
      Date date,
      String city,
      String occupation,
      String interests
    ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.date = date;
    this.city = city;
    this.occupation = occupation;
    this.interests = interests;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getInterests() {
    return interests;
  }

  public void setInterests(String interests) {
    this.interests = interests;
  }

}
