package com.br.songbox.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "PLAYLIST")
@Data
public class PlaylistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String playlistId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @ManyToMany
    private HashSet<TagModel> tagModels;
    private LocalDate postDate;
}
