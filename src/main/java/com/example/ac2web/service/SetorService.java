package com.example.ac2web.service;

import com.example.ac2web.dto.DadosSetorDTO;
import com.example.ac2web.dto.SetorDTO;
import com.example.ac2web.model.Setor;
import com.example.ac2web.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;

    public void adicionar(SetorDTO dto) {
        Setor setor = new Setor();
        setor.setNome(dto.getNome());
        setorRepository.save(setor);
    }

    public DadosSetorDTO buscarPorId(Integer id) {
        Optional<Setor> setor = setorRepository.findById(id);
        return setor.map(DadosSetorDTO::new)
                    .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    }
}

