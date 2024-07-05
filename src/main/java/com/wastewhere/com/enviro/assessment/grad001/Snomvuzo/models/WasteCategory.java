package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    // Getters and setters

    // Retrieves the unique identifier of this waste category.
    public Long getId() {
        return id;
    }

    // Sets the unique identifier of this waste category.
    public void setId(Long id) {
        this.id = id;
    }

    // Retrieves the name of this waste category.
    public String getName() {
        return name;
    }

    // Sets the name of this waste category.
    public void setName(String name) {
        this.name = name;
    }

    // Retrieves the description of this waste category.
    public String getDescription() {
        return description;
    }

    // Sets the description of this waste category.
    public void setDescription(String description) {
        this.description = description;
    }
}