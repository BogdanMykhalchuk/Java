package com.models;

public class Address {
    private Integer id;
    private String region;
    private String city;
    private String district;
    private String village;
    private String street;
    private String house;
    private String flat;
    private String restaurant;

    public Address() {
    }

    public Address(Integer id, String region, String city, String district, String village, String street,
                   String house, String flat, String restaurant) {
        this.id = id;
        this.region = region;
        this.city = city;
        this.district = district;
        this.village = village;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.restaurant = restaurant;
    }

    public static Address createAddressWithoutId(String region, String city, String district, String village, String street, String house, String flat, String restaurant) {
        return new Address(null, region, city, district, village, street, house, flat, restaurant);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
