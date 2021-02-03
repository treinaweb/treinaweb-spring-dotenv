package br.com.treinaweb.treinawebspringdotenv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.treinawebspringdotenv.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}