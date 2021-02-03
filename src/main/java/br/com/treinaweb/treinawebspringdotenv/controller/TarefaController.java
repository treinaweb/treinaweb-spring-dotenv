package br.com.treinaweb.treinawebspringdotenv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.treinaweb.treinawebspringdotenv.domain.Tarefa;
import br.com.treinaweb.treinawebspringdotenv.service.TarefaService;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaService service;

    @GetMapping
    public String index(ModelMap model) {
        model.addAttribute("tarefas", service.listarTarefas());

        return "tarefa/index";
    }

    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, ModelMap model) {
        model.addAttribute("tarefa", service.listarTarefaPorId(id));

        return "tarefa/detalhes";
    }

    @GetMapping("/cadastrar")
    public String cadastro(ModelMap model) {
        model.addAttribute("tarefa", new Tarefa());

        return "tarefa/formulario";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "/tarefa/formulario";
        }

        service.cadastrarTarefa(tarefa);

        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/editar")
    public String edicao(@PathVariable Long id, ModelMap model) {
        model.addAttribute("tarefa", service.listarTarefaPorId(id));

        return "tarefa/formulario";
    }

    @PostMapping("/editar")
    public String editar(@Valid Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "tarefa/formulario";
        }

        service.editarTarefa(tarefa);

        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable Long id) {
        service.removerTarefaPorId(id);

        return "redirect:/tarefas";
    }
}
