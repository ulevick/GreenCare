package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean inStock;
    private String care;
    private String include;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "plant_image_urls", joinColumns = @JoinColumn(name = "plant_id"))
    @Column(name = "url")
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
