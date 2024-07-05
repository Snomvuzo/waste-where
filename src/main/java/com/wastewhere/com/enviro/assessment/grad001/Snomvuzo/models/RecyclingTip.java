package com.wastewhere.com.enviro.assessment.grad001.Snomvuzo.models;

import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "recycling_tips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    @Column(length = 1000)
    private String content;

    // Getters and setters

    // Retrieves the unique identifier of this recycling tip.
    public Long getId() {
        return id;
    }

    // Sets the unique identifier of this recycling tip.
    public void setId(Long id) {
        this.id = id;
    }

    // Retrieves the title of this recycling tip.
    public String getTitle() {
        return title;
    }

    // Sets the title of this recycling tip.
    public void setTitle(String title) {
        this.title = title;
    }

    // Retrieves the content of this recycling tip.
    public String getContent() {
        return content;
    }

    // Sets the content of this recycling tip.
    public void setContent(String content) {
        this.content = content;
    }
}