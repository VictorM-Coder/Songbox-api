package com.br.songbox.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Data
@Table(name = "REVIEW")
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String trackId;
    @NotBlank
    private String title;
    @NotBlank
    private String reviewText;
    @NotNull
    @Min(0) @Max(10)
    private int grade;
    @ManyToMany
    private HashSet<TagModel> tagModels;
    private LocalDate postDate;
}
