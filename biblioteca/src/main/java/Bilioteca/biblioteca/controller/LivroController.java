package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(Model model){ return "livros/inicio"; }

    @GetMapping("/livro/{indice}")
    public String exibirLivro(Model model, @PathVariable int indice){
        Livro livro = null;
        if (indice >= 0 && indice < livros.size()){
            livro = livros.get(indice);
        }
        model.addAttribute("livro", livro);
        return "livros/livro";
    }

    @GetMapping
    public String listarLivros(Model model){
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluirLivro(@PathVariable int indice){
        if (indice >= 0 && indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
