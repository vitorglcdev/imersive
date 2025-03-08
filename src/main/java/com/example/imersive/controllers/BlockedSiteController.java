package com.example.imersive.controllers;

import com.example.imersive.dto.blockedsites.BlockedSiteRequestDTO;
import com.example.imersive.dto.blockedsites.BlockedSiteResponseDTO;
import com.example.imersive.service.BlockedSiteService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.EntityReference;
import java.util.List;

@Controller
@RequestMapping("/blockedsites")
public class BlockedSiteController {
    private BlockedSiteService blockedSiteService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BlockedSiteResponseDTO>> getBlockedSitesByUserId(@PathVariable Long userId){
        List<BlockedSiteResponseDTO> response = blockedSiteService.findBlockedSiteByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BlockedSiteResponseDTO> createBlockedSite(@RequestBody BlockedSiteRequestDTO blockedSite){
        BlockedSiteResponseDTO response = blockedSiteService.createBlockedSite(blockedSite);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteBlockedSite(@PathVariable Long blockedSiteId){
        blockedSiteService.deleteBlockedSite(blockedSiteId);
        return ResponseEntity.noContent().build(); // ✅ Retorna 204 No Content
    }
}
