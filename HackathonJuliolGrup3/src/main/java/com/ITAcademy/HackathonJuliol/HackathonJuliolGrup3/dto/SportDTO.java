package com.ITAcademy.HackathonJuliol.HackathonJuliolGrup3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportDTO{
	private String name;
    private String experience;
}