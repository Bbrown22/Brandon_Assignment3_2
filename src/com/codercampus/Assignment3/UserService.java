package com.codercampus.Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        try (
    		BufferedReader reader = new BufferedReader(new FileReader("data2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.add(new User(userData[0], userData[1], userData[2]));
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
