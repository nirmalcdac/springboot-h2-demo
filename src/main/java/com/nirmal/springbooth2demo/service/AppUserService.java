package com.nirmal.springbooth2demo.service;


import com.nirmal.springbooth2demo.model.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAllUsers();

    AppUser createUser(AppUser appUser);

    AppUser getUserById(String userId);

    AppUser updateUser(String userId, AppUser appUserDetails);

    void deleteUser(String userId);
}