package com.example.ac2web.controllers;

import com.example.ac2web.dto.*;
import com.example.ac2web.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping
    public void adicionar(@RequestBody ProjetoDTO dto) {
        projetoService.adicionar(dto);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.buscarPorIdComFuncionarios(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public List<DadosProjetoDTO> buscarProjetosFuncionario(@PathVariable Integer idFuncionario) {
        return projetoService.buscarProjetosPorFuncionario(idFuncionario);
    }
}
