package com.example.imersive.models;

import jakarta.persistence.*;

@Entity
public class BlockedSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, length = 255)
    private String link;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relacionamento com usuário
    private User user;

    public BlockedSite() {}

    public User getUser() {
        return user;
    }

    public BlockedSite(User user, String link, Long id) {
        this.user = user;
        this.link = link;
        Id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
