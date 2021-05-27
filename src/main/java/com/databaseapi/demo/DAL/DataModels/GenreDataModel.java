package com.databaseapi.demo.DAL.DataModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class GenreDataModel {
    @Id
    @GeneratedValue
    private Long genre_id;

    private String name;
    @ManyToMany
    @JoinTable(
            name = "Genre_Game",
            joinColumns = { @JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private List<GameDataModel> games;

}
