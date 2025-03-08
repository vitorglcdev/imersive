package com.example.imersive.dto.blockedsites;

import com.example.imersive.models.User;

public class BlockedSiteRequestDTO {
    private String link;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;

    public BlockedSiteRequestDTO(String link, Long userId) {
        this.link = link;
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
