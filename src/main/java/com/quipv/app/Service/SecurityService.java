package com.quipv.app.Service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}