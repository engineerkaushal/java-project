package com.example.developer.SpringBootDigest.dto;

public class OrderDTO {

    private String productName;

    private Double productPrice;

    private Integer rating;

    public
    String getProductName () {
        return productName;
    }

    public
    void setProductName (String productName) {
        this.productName = productName;
    }

    public
    Double getProductPrice () {
        return productPrice;
    }

    public
    void setProductPrice (Double productPrice) {
        this.productPrice = productPrice;
    }

    public
    Integer getRating () {
        return rating;
    }

    public
    void setRating (Integer rating) {
        this.rating = rating;
    }

    @Override
    public
    String toString () {
        return "OrderDTO{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", rating=" + rating +
                '}';
    }
}
