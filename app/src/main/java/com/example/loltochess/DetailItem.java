package com.example.loltochess;

public class DetailItem {
    public String standard_image;
    public String second_image;
    public String tv_detail1;

    public DetailItem(){}
    public DetailItem(String standard_image, String second_image, String tv_detail1) {
        this.standard_image = standard_image;
        this.second_image = second_image;
        this.tv_detail1 = tv_detail1;
    }

    public String getStandard_image() {
        return standard_image;
    }

    public void setStandard_image(String standard_image) {
        this.standard_image = standard_image;
    }

    public String getSecond_image() {
        return second_image;
    }

    public void setSecond_image(String second_image) {
        this.second_image = second_image;
    }

    public String getTv_detail1() {
        return tv_detail1;
    }

    public void setTv_detail1(String tv_detail1) {
        this.tv_detail1 = tv_detail1;
    }

    @Override
    public String toString() {
        return "DetailItem{" +
                "standard_image='" + standard_image + '\'' +
                ", second_image='" + second_image + '\'' +
                ", tv_detail1='" + tv_detail1 + '\'' +
                '}';
    }
}

