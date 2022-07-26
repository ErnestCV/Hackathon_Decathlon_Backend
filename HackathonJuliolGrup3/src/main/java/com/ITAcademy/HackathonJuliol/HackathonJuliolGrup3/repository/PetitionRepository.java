package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.repository;

import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Petition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetitionRepository extends MongoRepository<Petition, String> {


}
