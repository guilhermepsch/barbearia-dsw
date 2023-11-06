package com.developer.profile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.profile.entity.ProfileEntity;
import com.developer.profile.service.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {
  
  private final ProfileService profileService;

  @Autowired
  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  @GetMapping
  public List<ProfileEntity> findAllProfiles() {
    return profileService.findAllProfiles();
  }

  @GetMapping("/{id}")
  public Optional<ProfileEntity> findProfileById(@PathVariable("id") Long id) {
    return profileService.findProfileById(id);
  }

  @PostMapping
  public ProfileEntity saveProfile(@RequestBody ProfileEntity profile) {
    return profileService.saveProfile(profile);
  }

  @PutMapping
  public ProfileEntity updateProfile(@RequestBody ProfileEntity profile) {
    return profileService.updateProfile(profile);
  }

  @DeleteMapping("/{id}")
  public void deleteProfile(@PathVariable("id") Long id) {
    profileService.deleteProfileById(id);
  }


}
