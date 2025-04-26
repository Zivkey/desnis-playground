package com.example.metHotels.entity;

import com.example.metHotels.dto.ShirtDTO;
import com.example.metHotels.dto.ShirtSizeEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "shirts")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Shirt {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private ShirtSizeEnum size;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ShirtDTO toDTO() {
        return ShirtDTO.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .createdAt(this.createdAt)
                .build();
    }

    public Shirt update(ShirtDTO dto) {
        if (dto.getName() != null && !dto.getName().equals(this.name)) {
            this.name = dto.getName();
        }
        if (dto.getPrice() != null && !dto.getPrice().equals(this.price)) {
            this.price = dto.getPrice();
        }
        if (dto.getSize() != null && !dto.getSize().equals(this.size)) {
            this.size = dto.getSize();
        }
        return this;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
