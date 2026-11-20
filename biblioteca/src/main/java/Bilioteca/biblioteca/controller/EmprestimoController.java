package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String inicio(Model model){
        return "emprestimos/inicio";
    }

    @GetMapping("/emprestimo/{indice}")
    public String exibirEmprestimo(Model model, @PathVariable int indice){
        Emprestimo emprestimo = null;
        if (indice >= 0 && indice < emprestimos.size()){
            emprestimo = emprestimos.get(indice);
        }
        model.addAttribute("emprestimo", emprestimo);
        return "livros/livro";
    }

    @PostMapping
    public String cadastrarEmprestimo(@ModelAttribute Emprestimo emprestimo){
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/excluir/{indice}")
    public String excluirEmprestimo(@PathVariable int indice){
        if (indice >= 0 && indice < emprestimos.size()){
            emprestimos.remove(indice);
        }
        return "redirect:/livros";
    }
}
