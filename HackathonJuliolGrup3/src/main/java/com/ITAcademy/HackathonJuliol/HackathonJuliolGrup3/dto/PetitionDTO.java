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

    private String mongoId;
    private String username;
    private String message;
    // TODO: oju! in production create a class!
    private List<String> tags;

    private boolean isClosed = false;

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
