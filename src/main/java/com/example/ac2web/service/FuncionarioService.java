package com.example.ac2web.service;

import com.example.ac2web.dto.FuncionarioDTO;
import com.example.ac2web.model.Funcionario;
import com.example.ac2web.model.Setor;
import com.example.ac2web.repository.FuncionarioRepository;
import com.example.ac2web.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    public void adicionar(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());

        Setor setor = setorRepository.findById(dto.getIdSetor())
            .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        funcionario.setSetor(setor);

        funcionarioRepository.save(funcionario);
    }
}

