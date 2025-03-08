package com.example.imersive.repositories;

import com.example.imersive.dto.blockedsites.BlockedSiteResponseDTO;
import com.example.imersive.models.BlockedSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockedSiteRepository extends JpaRepository <BlockedSite, Long>{
    List<BlockedSite> findByUserId(Long id);
}
