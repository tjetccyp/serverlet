package com.cyp.domain;

public class Product {
    private int pro_id;
    private String pro_name;
    private int pro_price;
    private String pro_img1;
    private String pro_img2;
    private String pro_title ;
    private String pro_info;

    public Product() {
    }

    public Product(int pro_id) {
        this.pro_id = pro_id;
    }

    public Product(String pro_name, int pro_price, String pro_img1, String pro_img2, String pro_title, String pro_info) {
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_img1 = pro_img1;
        this.pro_img2 = pro_img2;
        this.pro_title = pro_title;
        this.pro_info = pro_info;
    }

    public Product(int pro_id, String pro_name, int pro_price, String pro_img1, String pro_img2, String pro_title, String pro_info) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_img1 = pro_img1;
        this.pro_img2 = pro_img2;
        this.pro_title = pro_title;
        this.pro_info = pro_info;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_price() {
        return pro_price;
    }

    public void setPro_price(int pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_img1() {
        return pro_img1;
    }

    public void setPro_img1(String pro_img1) {
        this.pro_img1 = pro_img1;
    }

    public String getPro_img2() {
        return pro_img2;
    }

    public void setPro_img2(String pro_img2) {
        this.pro_img2 = pro_img2;
    }

    public String getPro_title() {
        return pro_title;
    }

    public void setPro_title(String pro_title) {
        this.pro_title = pro_title;
    }

    public String getPro_info() {
        return pro_info;
    }

    public void setPro_info(String pro_info) {
        this.pro_info = pro_info;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", pro_price=" + pro_price +
                ", pro_img1='" + pro_img1 + '\'' +
                ", pro_img2='" + pro_img2 + '\'' +
                ", pro_title='" + pro_title + '\'' +
                ", pro_info='" + pro_info + '\'' +
                '}';
    }
}
