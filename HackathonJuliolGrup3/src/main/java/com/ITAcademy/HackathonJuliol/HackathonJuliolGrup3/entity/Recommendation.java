package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommendation {

    private Long recId;
    private String responderId;
    //TODO: oju! in production maybe class
    @Builder.Default
    private List<String> links = ArrayList<>();
    @Builder.Default
    private int likes = 0;
}
