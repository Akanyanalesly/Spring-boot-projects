package com.example.bonus_user_profile_api.controller;

import com.example.bonus_user_profile_api.model.ApiResponse;
import com.example.bonus_user_profile_api.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private List<UserProfile> users = new ArrayList<>();

    public UserProfileController() {
        users.add(new UserProfile(1L, "Peter_doe", "Peter@gmail.com",
                "Peter Doe", 25, "USA", "Java developer", true));
        users.add(new UserProfile(2L, "jane_smith", "jane@gmail.com",
                "Jane Smith", 30, "Canada", "Spring Boot fan", false));
    }

    @PostMapping
    public ApiResponse<UserProfile> createUser(@RequestBody UserProfile user) {
        users.add(user);
        return new ApiResponse<>(true,
                "User profile created successfully",
                user);
    }

    @GetMapping
    public ApiResponse<List<UserProfile>> getAllUsers() {
        return new ApiResponse<>(true,
                "User profiles fetched successfully",
                users);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserProfile> getUserById(@PathVariable Long id) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                return new ApiResponse<>(true, "User found", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @GetMapping("/search/username")
    public ApiResponse<UserProfile> searchByUsername(@RequestParam String username) {
        for (UserProfile user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return new ApiResponse<>(true, "User found", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @GetMapping("/search/country")
    public ApiResponse<List<UserProfile>> searchByCountry(@RequestParam String country) {
        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getCountry().equalsIgnoreCase(country)) {
                result.add(user);
            }
        }
        return new ApiResponse<>(true, "Users from country fetched", result);
    }

    @GetMapping("/search/age")
    public ApiResponse<List<UserProfile>> searchByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<UserProfile> result = new ArrayList<>();
        for (UserProfile user : users) {
            if (user.getAge() >= min && user.getAge() <= max) {
                result.add(user);
            }
        }
        return new ApiResponse<>(true, "Users by age range fetched", result);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserProfile> updateUser(
            @PathVariable Long id,
            @RequestBody UserProfile updatedUser) {

        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setFullName(updatedUser.getFullName());
                user.setAge(updatedUser.getAge());
                user.setCountry(updatedUser.getCountry());
                user.setBio(updatedUser.getBio());
                return new ApiResponse<>(true, "User updated successfully", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @PatchMapping("/{id}/activate")
    public ApiResponse<UserProfile> activateUser(@PathVariable Long id) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                user.setActive(true);
                return new ApiResponse<>(true, "User activated", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @PatchMapping("/{id}/deactivate")
    public ApiResponse<UserProfile> deactivateUser(@PathVariable Long id) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(id)) {
                user.setActive(false);
                return new ApiResponse<>(true, "User deactivated", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getUserId().equals(id));
        return new ApiResponse<>(true, "User deleted successfully", null);
    }
}
