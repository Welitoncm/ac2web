package com.example.ac2web.controllers;

import com.example.ac2web.dto.*;
import com.example.ac2web.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService setorService;

    @PostMapping
    public void adicionar(@RequestBody SetorDTO dto) {
        setorService.adicionar(dto);
    }

    @GetMapping("/{idSetor}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Integer idSetor) {
        return setorService.buscarPorId(idSetor);
    }
}
