package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetitionDTO {
    
    private String creatorId;
    private String message;
    // TODO: oju! in production create a class!
    private List<String> tags;

    @Builder.Default
    private boolean isClosed = false;

}
