package com.nirmal.springbooth2demo.controller;

import com.nirmal.springbooth2demo.model.AppUser;
import com.nirmal.springbooth2demo.service.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {
    @Autowired
    private final AppUserServiceImpl appUserService;

    public AppUserController(AppUserServiceImpl appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/appUser")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @PostMapping("/appUser")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserService.createUser(appUser);
    }

    @GetMapping("/appUser/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable String userId) {
        AppUser appUser = appUserService.getUserById(userId);
        return ResponseEntity.ok(appUser);
    }

    @PutMapping("/appUser/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable String userId, @RequestBody AppUser appUserDetails) {
        AppUser appUser = appUserService.updateUser(userId, appUserDetails);
        return ResponseEntity.ok(appUser);
    }

    @DeleteMapping("/appUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
        appUserService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}