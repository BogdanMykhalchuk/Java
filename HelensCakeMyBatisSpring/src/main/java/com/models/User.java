package com.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private Integer id;
    private String login;
    private String password;
    private String name;
    private String phoneNumber;
    private UserRole userRole;
    private List<UserCakeOrder> cakeOrders = new ArrayList<>();
    private List<UserPrintOrder> printOrders = new ArrayList<>();

    public User() {}

    public User(Integer id, String login, String password, String name, String phoneNumber,
                UserRole userRole, List<UserCakeOrder> cakeOrders, List<UserPrintOrder> printOrders) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.cakeOrders = cakeOrders;
        this.printOrders = printOrders;
    }

    public static User createUserWithoutRole(String login, String password, String name, String phoneNumber) {
        List<UserCakeOrder> cakeOrders = new ArrayList<>();
        List<UserPrintOrder> printOrders = new ArrayList<>();
        return new User(null, login, password, name, phoneNumber, UserRole.ROLE_CLIENT, cakeOrders, printOrders);
    }

    public static User createUserWithRole(String login, String password, String name, String phoneNumber, UserRole userRole) {
        List<UserCakeOrder> cakeOrders = new ArrayList<>();
        List<UserPrintOrder> printOrders = new ArrayList<>();
        return new User(null, login, password, name, phoneNumber, userRole, cakeOrders, printOrders);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<UserCakeOrder> getCakeOrders() {
        return cakeOrders;
    }

    public void setCakeOrders(List<UserCakeOrder> cakeOrders) {
        this.cakeOrders = cakeOrders;
    }

    public List<UserPrintOrder> getPrintOrders() {
        return printOrders;
    }

    public void setPrintOrders(List<UserPrintOrder> printOrders) {
        this.printOrders = printOrders;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
