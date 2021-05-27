package com.databaseapi.demo.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class FriendshipDataModel {
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserDataModel user;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserDataModel friend;

    @Column(nullable = false)
    private boolean isAccepted;
}
