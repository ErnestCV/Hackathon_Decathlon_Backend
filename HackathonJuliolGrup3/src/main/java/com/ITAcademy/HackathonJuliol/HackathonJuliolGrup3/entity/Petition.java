package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
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
    @Id
    private String mongoId;
    private String username;
    private String message;
    // TODO: oju! in production create a class!
    private List<String> tags;
    @Builder.Default
    private List<Recommendation> recommendations = new ArrayList<>();
    
    @Builder.Default
    private boolean isClosed = false;

}
