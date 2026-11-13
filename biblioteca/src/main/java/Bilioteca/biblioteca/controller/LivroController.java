package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String inicio(Model model){
        model.addAttribute(
                "titulo",
                "Biblioteca"
        );
        model.addAttribute(
                "mensagemBoasVindas",
                "Bem-vindo ao portal da Biblioteca!"
        );
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

    @GetMapping("/autor")
    public String exibirAutor(Model model){
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        model.addAttribute("autor", autor);
        return "autor";
    }

}
