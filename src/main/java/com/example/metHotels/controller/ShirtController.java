package com.example.metHotels.controller;

import com.example.metHotels.dto.ShirtDTO;
import com.example.metHotels.service.ShirtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("shirts")
@RequiredArgsConstructor
public class ShirtController {

    private final ShirtService shirtService;

    @PostMapping("v1/create")
    public ResponseEntity<?> create(@RequestBody ShirtDTO dto) {
        return shirtService.create(dto);
    }

    @PutMapping("v1/update")
    public ResponseEntity<?> update(@RequestBody ShirtDTO dto) {
        return shirtService.update(dto);
    }

    @GetMapping("v1/get-all")
    public ResponseEntity<?> getAll() {
        return shirtService.getAll();
    }

    @DeleteMapping("v1/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return shirtService.delete(id);
    }

}
