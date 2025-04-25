package com.example.ac2web.controllers;

import com.example.ac2web.dto.*;
import com.example.ac2web.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final ProjetoService projetoService;

    @PostMapping
    public void adicionar(@RequestBody FuncionarioDTO dto) {
        funcionarioService.adicionar(dto);
    }

    @GetMapping("/{idFuncionario}/projetos")
    public List<DadosProjetoDTO> buscarProjetos(@PathVariable Integer idFuncionario) {
        return projetoService.buscarProjetosPorFuncionario(idFuncionario);
    }
}
