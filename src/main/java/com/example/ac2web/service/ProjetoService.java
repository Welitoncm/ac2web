package com.example.ac2web.service;

import com.example.ac2web.dto.*;
import com.example.ac2web.model.*;
import com.example.ac2web.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public void adicionar(ProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());
        projetoRepository.save(projeto);
    }

    public DadosProjetoDTO buscarPorIdComFuncionarios(Integer id) {
        Projeto projeto = projetoRepository.buscarComFuncionarios(id)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        return new DadosProjetoDTO(projeto);
    }

    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    public List<DadosProjetoDTO> buscarProjetosPorFuncionario(Integer idFuncionario) {
        List<Projeto> projetos = funcionarioRepository.buscarProjetosPorFuncionario(idFuncionario);
        return projetos.stream().map(DadosProjetoDTO::new).toList();
    }
}

