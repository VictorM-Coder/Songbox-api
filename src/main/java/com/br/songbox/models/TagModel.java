package com.br.songbox.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TAG")
public class TagModel {
    @Id
    private String tag;
}
