package com.tcc.controller;

import com.tcc.model.Horario;
import com.tcc.service.HorarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HorarioController {

    private HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @PostMapping("/horario")
    public Horario saveHorario(@RequestBody Horario horario) {
        return horarioService.salvarHorario(horario);
    }

    @GetMapping("/horario")
    public List<Horario> getHorario() {
        return horarioService.getHorario();
    }
}
