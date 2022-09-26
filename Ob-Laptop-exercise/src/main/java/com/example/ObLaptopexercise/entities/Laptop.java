package com.example.ObLaptopexercise.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
@ApiModel("Representative entity of a laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("AutoIncrementing dummy key")
    private Long id;
    private String brand;
    private Integer RAMCapacity;
    private Integer ssd;
    private String operatingSystem;

    public Laptop(){

    }

    public Laptop(Long id, String brand, Integer RAMCapacity, Integer ssd, String operatingSystem) {
        this.id = id;
        this.brand = brand;
        this.RAMCapacity = RAMCapacity;
        this.ssd = ssd;
        this.operatingSystem = operatingSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRAMCapacity() {
        return RAMCapacity;
    }

    public void setRAMCapacity(Integer RAMCapacity) {
        this.RAMCapacity = RAMCapacity;
    }

    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
