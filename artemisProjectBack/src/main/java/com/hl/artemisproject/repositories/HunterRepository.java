package com.hl.artemisproject.repositories;

import com.hl.artemisproject.classes.Hunter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface HunterRepository extends JpaRepository<Hunter, Integer> {

    @Query("SELECT h FROM Hunter h WHERE h.hunterId = ?1")
    Optional<Hunter> findHunterById(long id);

    @Query("SELECT h FROM Hunter h WHERE h.hunterName = ?1 AND h.hunterMail = ?2")
    Optional<Hunter> findHunterByHunterParams(String hunterName, String hunterMail);

    @Query("SELECT h FROM Hunter h")
    List<Hunter> getAllHunters();

    @Transactional
    @Modifying
    @Query("UPDATE Hunter SET hunterName = ?1, hunterMail = ?2 WHERE hunterId = ?3")
    void updateHunterById(String hunterName, String hunterMail, long hunterId);
}
