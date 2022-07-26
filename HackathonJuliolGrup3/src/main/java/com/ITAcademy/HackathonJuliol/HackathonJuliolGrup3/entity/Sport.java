package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sport {
    // TODO: in production may use classes for both
    private String name;
    private String experience;
}
