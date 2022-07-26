package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Petitions")
public class Petition {
    
    private Long mongoId;
    private String creatorId;
    private String message;
    // TODO: oju! in production create a class!
    private List<String> tags;
    private List<Recommendation> recomendations;
    
    @Builder.Default
    private boolean isClosed = false;

}
