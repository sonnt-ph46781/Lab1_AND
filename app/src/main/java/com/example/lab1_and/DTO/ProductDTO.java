package com.example.lab1_and.DTO;

public class ProductDTO {
    int id;
    String name;
    double price;
    int id_cat;
    public String toString (){
        return "ID: "+id+", name: " + name+", price: "+price+", id_cat: "+id_cat;
    }
    // tạo các hàm getter và setter bằng generate

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
