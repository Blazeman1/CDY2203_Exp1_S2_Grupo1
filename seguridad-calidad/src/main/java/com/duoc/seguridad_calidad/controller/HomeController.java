// Ubicado en el paquete controller para organizar el proyecto por capas.
package com.duoc.seguridad_calidad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador de paginas base.
 * Se movio al paquete controller para ordenar el proyecto por capas.
 */
@Controller
public class HomeController {

    // Esto después se puede extender en un futuro moviendolo a nuevo package/paquete y separando
    // el controlador en modulos (por ejemplo HomeController, AuthController, etc) 
    // para definir mejor responsabilidades y desacoplar código.

    @GetMapping("/")
    public String root(Model model) {
        // Se reutiliza la misma vista de inicio para ruta raiz y /home.
        model.addAttribute("name", "Sistema de Gestion Veterinaria");
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Sistema de Gestion Veterinaria");
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
