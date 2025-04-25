package com.example.ac2web.dto;

import com.example.ac2web.model.Projeto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class DadosProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioDTO> funcionarios;

    public DadosProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.descricao = projeto.getDescricao();
        this.dataInicio = projeto.getDataInicio();
        this.dataFim = projeto.getDataFim();
        this.funcionarios = projeto.getFuncionarios().stream()
            .map(f -> new FuncionarioDTO(f.getId(), f.getNome(), f.getSetor().getId()))
            .toList();
    }
}
