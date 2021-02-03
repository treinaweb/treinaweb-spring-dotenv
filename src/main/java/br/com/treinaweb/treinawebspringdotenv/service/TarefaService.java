package br.com.treinaweb.treinawebspringdotenv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.treinawebspringdotenv.domain.Tarefa;
import br.com.treinaweb.treinawebspringdotenv.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa listarTarefaPorId(Long id) {
        return repository.getOne(id);
    }

    public void removerTarefaPorId(Long id) {
        repository.deleteById(id);
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        repository.save(tarefa);
    }

    public void editarTarefa(Tarefa tarefa) {
        repository.save(tarefa);
    }
}
