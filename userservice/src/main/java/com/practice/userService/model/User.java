package com.practice.userService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private String amountOfPosts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountOfPosts() {
        return amountOfPosts;
    }

    public void setAmountOfPosts(String amountOfPosts) {
        this.amountOfPosts = amountOfPosts;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", amount='" + amount + '\'' + ", amountOfPosts='" + amountOfPosts + '\'' + '}';
    }
}
