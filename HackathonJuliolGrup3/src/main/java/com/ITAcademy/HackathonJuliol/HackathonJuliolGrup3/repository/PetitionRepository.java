package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.repository;

import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Petition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PetitionRepository extends MongoRepository<Petition, String> {
    
    Optional<Petition> findByCreatorId(String creatorId);
}
