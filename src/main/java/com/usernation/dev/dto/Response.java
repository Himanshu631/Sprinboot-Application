package com.usernation.dev.dto;

public class Response {
    private Integer userId;
    private String accountType;
    private String userName;

    public Response(Integer userId, String userName, String accountType) {
        this.userId = userId;
        this.userName = userName;
        this.accountType = accountType;
    }

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
