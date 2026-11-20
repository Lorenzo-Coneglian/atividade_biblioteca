package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(Model model){
        return "livros/inicio";
    }

    @GetMapping
    public String listarAutores(Model model){
        model.addAttribute("autores", autores);
        model.addAttribute("autor", new Autor());
        return "autores/lista";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor){
        autores.add(autor);
        return "redirect:/autores";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluirAutor(@PathVariable int indice){
        if (indice >= 0 && indice < autores.size()){
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
