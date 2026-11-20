package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public String inicio(Model model){
        return "categorias/inicio";
    }

    @GetMapping("/categoria/{indice}")
    public String exibirCategoria(Model model, @PathVariable int indice){
        Categoria categoria = null;
        if (indice >= 0 && indice < categorias.size()){
            categoria = categorias.get(indice);
        }
        model.addAttribute("categoria", categoria);
        return "categorias/categoria";
    }

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute Categoria categoria){
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/excluir/{indice}")
    public String excluirLivro(@PathVariable int indice){
        if (indice >= 0 && indice < categorias.size()){
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
