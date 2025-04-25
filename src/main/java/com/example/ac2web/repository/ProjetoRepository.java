package com.example.ac2web.repository;

import com.example.ac2web.model.Projeto;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.*;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Optional<Projeto> buscarComFuncionarios(@Param("id") Integer id);

    List<Projeto> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
}
