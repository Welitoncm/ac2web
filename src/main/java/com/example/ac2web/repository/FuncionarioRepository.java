package com.example.ac2web.repository;

import com.example.ac2web.model.Funcionario;
import com.example.ac2web.model.Projeto;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> buscarProjetosPorFuncionario(@Param("id") Integer id);
}
