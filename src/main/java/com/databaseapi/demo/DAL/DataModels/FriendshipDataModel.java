package com.databaseapi.demo.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class FriendshipDataModel {
    @Id
    @GeneratedValue
    private Long friendshipId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserDataModel user;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserDataModel friend;

    @Column(nullable = false)
    private boolean isAccepted;
}
