package com.example.metHotels.service;

import com.example.metHotels.dto.ShirtDTO;
import com.example.metHotels.entity.Shirt;
import com.example.metHotels.repository.ShirtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ShirtService {

    private final ShirtRepository shirtRepository;

    public ResponseEntity<?> create(ShirtDTO dto) {
        try {
            if (dto.getPrice() < 0) {
                return new ResponseEntity<>("Price cannot be negative!", HttpStatus.BAD_REQUEST);
            }
            Shirt shirt = dto.toEntity();
            shirt = shirtRepository.save(shirt);
            return new ResponseEntity<>(shirt.toDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> update(ShirtDTO dto) {
        try {
            if (dto.getId() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Optional<Shirt> optionalShirt = shirtRepository.findById(dto.getId());
            if (optionalShirt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Shirt shirt = optionalShirt.get().update(dto);
            shirt = shirtRepository.save(shirt);
            return new ResponseEntity<>(shirt.toDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getAll() {
        try {
            List<ShirtDTO> shirts;
            shirts = shirtRepository.findAll().stream().map(Shirt::toDTO).toList();
            return new ResponseEntity<>(shirts, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> delete(String id) {
        try {
            Optional<Shirt> optionalShirt = shirtRepository.findById(id);
            if (optionalShirt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            shirtRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
