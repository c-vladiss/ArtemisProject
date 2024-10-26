package com.hl.artemisproject.controllers;

import com.hl.artemisproject.classes.Hunter;
import com.hl.artemisproject.services.HunterService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/hunters")
public class HunterController {
    private final HunterService hunterService;

    @Autowired
    public HunterController(HunterService hunterService) {
        this.hunterService = hunterService;
    }

    @GetMapping("/")
    public List<Hunter> getAllHunters(){
        return this.hunterService.getAllHunters();
    }

    @GetMapping("/{hunterId}")
    public Optional<Hunter> getHunterById(@PathVariable int hunterId) {
        return this.hunterService.getHunterById(hunterId);
    }

    @PostMapping("/addHunter")
    public void addHunter(@RequestBody Hunter hunter) {
        if(hunter.getHunterName() == null || hunter.getHunterName().isEmpty()) {
            throw new IllegalArgumentException("Hunter name cannot be empty");
        }
        this.hunterService.addHunter(hunter);
    }

    @PutMapping("/updateHunter/{hunterId}")
    public void updateHunter(@RequestBody Hunter hunter, @PathVariable int hunterId) {
        if(getHunterById(hunterId).isEmpty()) {
            throw new IllegalArgumentException("Hunter id cannot be empty");
        }
            this.hunterService.updateHunter(hunter, hunterId);
    }
}
