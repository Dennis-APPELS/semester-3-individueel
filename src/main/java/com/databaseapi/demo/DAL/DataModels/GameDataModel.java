package com.databaseapi.demo.DAL.DataModels;

import javax.persistence.*;
import java.util.List;

@Entity
public class GameDataModel {
    @Id
    @GeneratedValue
    private Long game_id;

    private String name;
    private int rating;

    @ManyToMany(mappedBy = "games")
    private List<GenreDataModel> genres;

    @OneToMany(mappedBy = "lastPlayed")
    private List<UserDataModel> lastPlayedBy;

}
