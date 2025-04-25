package com.example.ac2web.dto;

import com.example.ac2web.model.Setor;
import lombok.*;

import java.util.List;

@Data
public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;

    public DadosSetorDTO(Setor setor) {
        this.id = setor.getId();
        this.nome = setor.getNome();
        this.funcionarios = setor.getFuncionarios().stream()
            .map(f -> new FuncionarioDTO(f.getId(), f.getNome(), setor.getId()))
            .toList();
    }
}
