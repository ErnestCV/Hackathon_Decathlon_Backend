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
<<<<<<< HEAD
    private Long id;
    private String responderId;
=======
    @Id
    private String mongoId;
    private String username;
>>>>>>> f5de941d46d8444522da1528839ec7874c3a5049
    private String text;

    //TODO: oju! in production maybe class
    @Builder.Default
    private List<String> links = new ArrayList<>();

    @Builder.Default
    private int likes = 0;
}
