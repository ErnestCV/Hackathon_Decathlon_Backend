package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.service;

import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto.PetitionDTO;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto.RecommendationDTO;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Petition;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Recommendation;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity.Tags;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.exception.ResourceNotFoundException;
import com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.repository.PetitionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetitionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    PetitionRepository petitionRepository;

    public Petition getPetitionByCreatorId(String id) {
        Petition petition = petitionRepository.findByUsername(id)
                .orElseThrow(() -> new ResourceNotFoundException("Petition", "id", id));
        return petition;
    }

    public List<PetitionDTO> getPetitionsTags(Tags tags) {
        List<Petition> list = petitionRepository.findAll();
        return list.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PetitionDTO createPetition(PetitionDTO petitionDTO) {
        Petition petition = mapToEntity(petitionDTO);
        Petition newPetition = petitionRepository.save(petition);
        return mapToDTO(newPetition);
    }

    public PetitionDTO updatePetition(PetitionDTO petitionDTO, String id) {
        Petition petition = petitionRepository.findByUsername(id)
                .orElseThrow(() -> new ResourceNotFoundException("Petition", "id", id));

        petition.setMessage(petitionDTO.getMessage());
        petition.setTags(petitionDTO.getTags());
        petition.setClosed(petitionDTO.isClosed());

        Petition newPetition = petitionRepository.save(petition);
        return mapToDTO(newPetition);
    }

    // recomendations repo
    public Petition insertRecommendation(final String id, final Recommendation recomendation) {
        Petition petition = getPetition(id);
        petition.getRecommendations().add(recomendation);
        recomendation.setId((long) petition.getRecommendations().size());
        petition = petitionRepository.save(petition);
        return petition;
    }

    public Petition updateRecomendation(final String petitionId, final Long recomendationId,
            final Recommendation newRec) {
        Petition petition = getPetition(petitionId);
        Recommendation recomendation = this.getReccomentaion(petition, recomendationId);

        recomendation.setLikes(newRec.getLikes());
        recomendation.setUsername(newRec.getText());
        recomendation.setLinks(newRec.getLinks());
        petitionRepository.save(petition);

        return petition;
    }

    public Petition removeRecomendation(final String petitionId, final Long recId) {
        Petition petition = getPetition(petitionId);
        Recommendation toRemove = this.getReccomentaion(petition, recId);
        petition.getRecommendations().remove(toRemove);
        return petitionRepository.save(petition);
    }

    private Recommendation getReccomentaion(final Petition petition, final Long recId) {
        return petition.getRecommendations().stream()
                .filter(r -> r.getId().equals(recId)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Petition", "id", recId.toString()));
    }

    // get petition or throw
    private Petition getPetition(final String id) throws ResourceNotFoundException {
        return petitionRepository.findByUsername(id)
                .orElseThrow(() -> new ResourceNotFoundException("Petition", "id", id));
    }

<<<<<<< HEAD
    private Recommendation getRecommendation(final Petition petition, final String id)
            throws ResourceNotFoundException {
        // Optional<Recommendation> rec =
        // petition.getRecomendations().stream().anyMatch(r -> r.get)
=======
    public void deletePetition(String id) {
        petitionRepository.delete(getPetition(id));
    }
    
    private Recommendation getRecommendation(final Petition petition, final String id) throws ResourceNotFoundException {
        //Optional<Recommendation> rec = petition.getRecomendations().stream().anyMatch(r -> r.get)
>>>>>>> ba038c69f99dc7e3c8ff4111c24c924ce1a88a1e
        return null;
    }

    // Convert entity to DTO
    private PetitionDTO mapToDTO(Petition petition) {
        return modelMapper.map(petition, PetitionDTO.class);
    }

    // Convert DTO to entity
    private Petition mapToEntity(PetitionDTO petitionDTO) {
        return modelMapper.map(petitionDTO, Petition.class);
    }

}
