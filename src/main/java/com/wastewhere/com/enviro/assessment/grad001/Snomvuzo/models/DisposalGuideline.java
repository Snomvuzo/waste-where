package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    @Column(length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "waste_category_id")
    private WasteCategory wasteCategory;

    // Getters and setters

    // retrieves the unique identifier of this disposal guideline.
    public Long getId() {
        return id;
    }

    // sets the unique identifier of this disposal guideline.
    public void setId(Long id) {
        this.id = id;
    }

    // Retrieves the title of this disposal guideline.
    public String getTitle() {
        return title;
    }

    // Sets the title of this disposal guideline.
    public void setTitle(String title) {
        this.title = title;
    }

    // Retrieves the content of this disposal guideline.
    public String getContent() {
        return content;
    }

    // Sets the content of this disposal guideline.
    public void setContent(String content) {
        this.content = content;
    }

    // Retrieves the waste category associated with this disposal guideline.
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    // Sets the waste category associated with this disposal guideline.
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}