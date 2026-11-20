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

    @GetMapping
    public String listarLivros(Model model){
        model.addAttribute("livros", livros);
        model.addAttribute("livro", new Livro());
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
