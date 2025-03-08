package com.example.imersive.service;

import com.example.imersive.dto.blockedsites.BlockedSiteRequestDTO;
import com.example.imersive.dto.blockedsites.BlockedSiteResponseDTO;
import com.example.imersive.dto.pomodorosession.PomodoroSessionResponseDTO;
import com.example.imersive.models.BlockedSite;
import com.example.imersive.models.Task;
import com.example.imersive.models.User;
import com.example.imersive.repositories.BlockedSiteRepository;
import com.example.imersive.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockedSiteService {
    BlockedSiteRepository blockedSitesRepository;
    UserRepository userRepository;

    public BlockedSiteResponseDTO createBlockedSite(BlockedSiteRequestDTO blockedSiteDTO) {
        // Verifica se o usuário existe
        User user = userRepository.findById(blockedSiteDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        BlockedSite blockedSite = new BlockedSite();

        if (blockedSiteDTO.getUserId() != null) {
            blockedSite.setUser(user);
        }
        if (blockedSiteDTO.getLink() != null) {
            blockedSite.setLink(blockedSiteDTO.getLink());
        }

        blockedSite = blockedSitesRepository.save(blockedSite);
        return new BlockedSiteResponseDTO(blockedSite);
    }

    public List<BlockedSiteResponseDTO> findBlockedSiteByUserId(Long userId){
        // Verifica se o usuário existe
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<BlockedSite> blockedSites = blockedSitesRepository.findByUserId(user.getId());
        return blockedSites.stream().map(BlockedSiteResponseDTO::new).toList();
    }


    public void deleteBlockedSite(Long blockedSiteId) {
        BlockedSite site = blockedSitesRepository.findById(blockedSiteId)
                .orElseThrow(() -> new RuntimeException("Site não encontrado"));

        blockedSitesRepository.delete(site); // ✅ Deleta a site do banco de dados
    }
}