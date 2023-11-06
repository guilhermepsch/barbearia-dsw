package com.developer.profile.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.profile.entity.ProfileEntity;
import com.developer.profile.repository.ProfileRepository;
import com.developer.profile.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

  private final ProfileRepository profileRepository;

  public ProfileServiceImpl(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public List<ProfileEntity> findAllProfiles() {
    return profileRepository.findAll();
  }

  @Override
  public Optional<ProfileEntity> findProfileById(Long id) {
    return profileRepository.findById(id);
  }

  @Override
  public ProfileEntity saveProfile(ProfileEntity profile) {
    return profileRepository.save(profile);
  }

  @Override
  public ProfileEntity updateProfile(ProfileEntity profile) {
    return profileRepository.save(profile);
  }

  @Override
  public void deleteProfileById(Long id) {
    profileRepository.deleteById(id);
  }
  
}
