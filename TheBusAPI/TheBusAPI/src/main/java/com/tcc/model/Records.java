package com.tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Records {

    private String _id;

    private String linha;

    private String horario_largada;

    private String sentido;

    private String adaptado_deficiente;

}
