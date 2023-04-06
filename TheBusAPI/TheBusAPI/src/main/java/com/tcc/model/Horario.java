package com.tcc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horario {

    private String id;

    private String linha;

    private LocalDateTime largada;

    private String sentido;

    private boolean adaptado;


}
