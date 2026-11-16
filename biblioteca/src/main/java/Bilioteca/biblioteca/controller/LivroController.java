package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(Model model){
        //model.addAttribute("titulo", "Biblioteca");
        //model.addAttribute("mensagemBoasVindas", "Bem-vindo ao portal da Biblioteca!");
        return "livros/inicio";
    }

    @GetMapping("/livro")
    public String exibirLivro(Model model){
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");
        model.addAttribute("livro", livro);
        return "livro";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/autor")
    public String exibirAutor(Model model){
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        model.addAttribute("autor", autor);
        return "autor";
    }

}
