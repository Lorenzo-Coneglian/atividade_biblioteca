package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        return "usuarios/inicio";
    }

    @GetMapping("/usuario/{indice}")
    public String exibirUsuario(Model model, @PathVariable int indice) {
        Usuario usuario = null;
        if (indice >= 0 && indice < usuarios.size()){
            usuario = usuarios.get(indice);
        }
        model.addAttribute("usuario", usuario);
        return "usuarios/usuario";
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{indice}")
    public String excluirUsuario(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}
