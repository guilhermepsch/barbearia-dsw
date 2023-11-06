package com.developer.profile.service;

import java.util.List;
import java.util.Optional;

import com.developer.profile.entity.ProfileEntity;

public interface ProfileService {
  
  List<ProfileEntity> findAllProfiles();
  Optional<ProfileEntity> findProfileById(Long id);
  ProfileEntity saveProfile(ProfileEntity profile);
  ProfileEntity updateProfile(ProfileEntity profile);
  void deleteProfileById(Long id);
}
