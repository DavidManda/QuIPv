package com.quipv.app.Service;

import com.quipv.app.Models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
