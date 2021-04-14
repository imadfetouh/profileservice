package com.imadelfetouh.profileservice.dal.ormmodel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ff")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_Id", referencedColumnName = "profileId")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private List<Tweet> tweets;

    public String getUsername() {
        return username;
    }

    public String getPhoto() {
        return photo;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}
