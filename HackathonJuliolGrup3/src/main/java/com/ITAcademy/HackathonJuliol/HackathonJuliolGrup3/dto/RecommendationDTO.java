package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationDTO {
    
    private String answererId;
    private String text;
    @Builder.Default
    private List<String> links = new ArrayList<>();

    @Builder.Default
    private int likes = 0;
}
