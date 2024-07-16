package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public class PlantDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean inStock;
    private String care;
    private String include;
    private List<String> availablePotColors;
    private List<String> imageUrls;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public List<String> getAvailablePotColors() {
        return availablePotColors;
    }

    public void setAvailablePotColors(List<String> availablePotColors) {
        this.availablePotColors = availablePotColors;
    }
    public String getCare() {
        return care;
    }
    public void setCare(String care) {
        this.care = care;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

}
