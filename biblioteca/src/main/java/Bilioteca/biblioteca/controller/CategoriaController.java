package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(Model model){ return "livros/inicio"; }

    @GetMapping
    public String listarCategorias(Model model){
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria());
        return "categorias/lista";
    }

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute Categoria categoria){
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluirCategoria(@PathVariable int indice){
        if (indice >= 0 && indice < categorias.size()){
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
