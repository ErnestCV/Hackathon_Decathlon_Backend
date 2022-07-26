package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommendation {
    @Id
    private String mongoId;
    private String username;
    private String text;

    //TODO: oju! in production maybe class
    @Builder.Default
    private List<String> links = new ArrayList<>();

    @Builder.Default
    private int likes = 0;
}
