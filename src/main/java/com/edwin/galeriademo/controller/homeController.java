package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.album;

import com.edwin.galeriademo.service.albumService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class homeController {

    @Autowired
    private albumService albumService;

    @GetMapping("")
    public String home(Model model, HttpSession session) {
        List<album> albumes = albumService.findAll(); // Obtener todos los álbumes
        model.addAttribute("albumes", albumes); // Pasar los álbumes al modelo

        //SESSION
        model.addAttribute("sesion", session.getAttribute("idusuario"));

        return "usuario/home"; // Asegúrate de que esta vista esté configurada para mostrar álbumes

    }

    @GetMapping("/cerrar")
    public String cerrarSesion(Model model, HttpSession session) {
        session.removeAttribute("idusuario");
        return "redirect:/";


    }

}
