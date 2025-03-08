package com.example.imersive.dto.blockedsites;

import com.example.imersive.models.User;

public class BlockedSiteUpdateDTO {
    private String link;

    public BlockedSiteUpdateDTO( String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}