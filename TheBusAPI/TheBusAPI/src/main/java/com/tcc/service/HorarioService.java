package com.tcc.service;

import com.tcc.model.Horario;
import com.tcc.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario salvarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public List<Horario> getHorario() {
        return horarioRepository.findAll();
    }

}
