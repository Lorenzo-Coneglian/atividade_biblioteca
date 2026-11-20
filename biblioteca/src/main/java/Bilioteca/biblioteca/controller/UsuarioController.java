package Bilioteca.biblioteca.controller;

import Bilioteca.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();
    private int id;

    @GetMapping("/inicio")
    public String inicio(Model model) { return "livros/inicio"; }

    @GetMapping
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        return "usuarios/lista";
    }

    @PostMapping
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuario.setId(this.id);
        id+=1;
        usuarios.add(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluirUsuario(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}
