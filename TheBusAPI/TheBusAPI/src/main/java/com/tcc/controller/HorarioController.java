package com.tcc.controller;

import com.tcc.model.Records;
import com.tcc.service.RecordsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class HorarioController {

    private final RecordsService recordsService;

    public HorarioController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @PostMapping("/horario")
    public Records saveHorario(@RequestBody Records horario) {
        return recordsService.salvarHorario(horario);
    }

    @GetMapping("/horario")
    public List<Records> getHorario() {
        return recordsService.getHorario();
    }
}
