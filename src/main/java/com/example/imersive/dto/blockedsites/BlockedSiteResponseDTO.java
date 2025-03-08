package com.example.imersive.dto.blockedsites;

import com.example.imersive.models.BlockedSite;
import com.example.imersive.models.User;

public class BlockedSiteResponseDTO {
    private String link;
    private Long userId;

    public BlockedSiteResponseDTO(String link, Long userId) {
        this.link = link;
        this.userId = userId;
    }

    public BlockedSiteResponseDTO(BlockedSite blockedSite) {
        this.link = blockedSite.getLink();
        this.userId = blockedSite.getId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
