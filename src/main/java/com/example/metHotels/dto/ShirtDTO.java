package com.example.metHotels.dto;

import com.example.metHotels.entity.Shirt;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ShirtDTO {
    private String id;
    private String name;
    private Double price;
    private ShirtSizeEnum size;
    private LocalDateTime createdAt;

    public Shirt toEntity() {
        return Shirt.builder()
                .name(this.name)
                .price(this.price)
                .size(this.size)
                .createdAt(this.createdAt)
                .build();
    }
}
