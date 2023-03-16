package com.devmf.chairSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class EventDetailDto {
    private long id;
    private long amount;
    private double price;
    private EventDto eventDto;
    private ProductDto productDto;
}
