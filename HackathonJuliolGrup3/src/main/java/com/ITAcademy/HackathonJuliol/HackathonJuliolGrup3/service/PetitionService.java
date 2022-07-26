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

    public PetitionDTO getPetitionByCreatorId(String id) {
        Petition petition = petitionRepository.findByCreatorId(id).orElseThrow(() -> new ResourceNotFoundException("Petition", "id", id));
        return mapToDTO(petition);
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

    // recomendations repo
    public PetitionDTO insertRecommendation(final String id, final RecommendationDTO recomendation){
        Petition petition = petitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Petition", "id", id));
        petition.getRecomendations().add(recommendationToDTO(recomendation));
        return mapToDTO(petition);
    }

    //Convert entity to DTO
    private PetitionDTO mapToDTO(Petition petition) {
        return modelMapper.map(petition, PetitionDTO.class);
    }

    //Convert DTO to entity
    private Petition mapToEntity(PetitionDTO petitionDTO) {
        return modelMapper.map(petitionDTO, Petition.class);
    }

    private Recommendation recommendationToDTO(final RecommendationDTO dto) {
        return modelMapper.map(dto, Recommendation.class);
    }
}
