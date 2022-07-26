package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {

    private Long recId;
    private String responderId;

    //TODO: oju! in production maybe class
    private List<String> links = new ArrayList<>();

    private int likes = 0;
}
