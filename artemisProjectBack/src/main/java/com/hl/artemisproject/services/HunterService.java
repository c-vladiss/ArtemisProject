package com.hl.artemisproject.services;

import com.hl.artemisproject.classes.Hunter;
import com.hl.artemisproject.repositories.HunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HunterService {
    private final HunterRepository hunterRepository;

    @Autowired
    public HunterService(HunterRepository hunterRepository) {
        this.hunterRepository = hunterRepository;
    }
    public Optional<Hunter> getHunterById(int id) {
        return hunterRepository.findHunterById(id);
    }

    public Optional<Hunter> getHunterByHunterParams(Hunter hunter){
        return hunterRepository.findHunterByHunterParams(hunter.getHunterName(), hunter.getHunterMail());
    }

    public List<Hunter> getAllHunters() {
        return hunterRepository.findAll();
    }

    public void addHunter(Hunter hunter) {
        Optional<Hunter> optionalHunter = hunterRepository.findHunterByHunterParams(hunter.getHunterName(), hunter.getHunterMail());

        if (optionalHunter.isPresent()) {
            throw new IllegalStateException("Hunter already exists");
        }
        hunterRepository.save(hunter);
    }

    public void updateHunter(Hunter hunter, long hunterId) {
        Optional<Hunter> optionalHunter = hunterRepository.findHunterById(hunterId);
        if (optionalHunter.isPresent()) {
            hunterRepository.updateHunterById(hunter.getHunterName(), hunter.getHunterMail(), hunterId);
        } else {
            throw new ResourceNotFoundException("Hunter with ID " + hunterId + " does not exist");
        }
    }
}
