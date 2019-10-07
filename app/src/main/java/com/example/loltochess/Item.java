package com.example.loltochess;

public class Item {

    public String itemImage;
    public String tvWeapon;
    public String tvWeaponSpec;
    public String tvWeaponDamage;

    public Item(){}
    public Item(String itemImage, String tvWeapon, String tvWeaponSpec, String tvWeaponDamage) {
        this.itemImage = itemImage;
        this.tvWeapon = tvWeapon;
        this.tvWeaponSpec = tvWeaponSpec;
        this.tvWeaponDamage = tvWeaponDamage;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getTvWeapon() {
        return tvWeapon;
    }

    public void setTvWeapon(String tvWeapon) {
        this.tvWeapon = tvWeapon;
    }

    public String getTvWeaponSpec() {
        return tvWeaponSpec;
    }

    public void setTvWeaponSpec(String tvWeaponSpec) {
        this.tvWeaponSpec = tvWeaponSpec;
    }

    public String getTvWeaponDamage() {
        return tvWeaponDamage;
    }

    public void setTvWeaponDamage(String tvWeaponDamage) {
        this.tvWeaponDamage = tvWeaponDamage;
    }
}
