package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.album;
import com.edwin.galeriademo.service.albumService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/albumes")
public class albumController {

    private final Logger LOGGER = LoggerFactory.getLogger(albumController.class);

    @Autowired
    private albumService albumService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("albumes", albumService.findAll());
        return "albumes/show";
    }

    @GetMapping("/create")
    public String create() {
        return "albumes/create";
    }

    @PostMapping("/save")
    public String save(album album) {
        LOGGER.info("Saving album: {}", album);

        // Aquí puedes agregar lógica para asociar un usuario al álbum si es necesario.
        albumService.save(album);

        return "redirect:/albumes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<album> optionalAlbum = albumService.get(id);

        LOGGER.info("search album: {}", optionalAlbum);
        if (optionalAlbum.isPresent()) {
            model.addAttribute("album", optionalAlbum.get());
            return "albumes/edit";
        } else {
            return "redirect:/albumes";
        }
    }

    @PostMapping("/update")
    public String update(album album) {
        LOGGER.info("Updating album: {}", album);
        albumService.update(album);
        return "redirect:/albumes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<album> optionalAlbum = albumService.get(id);

        if (optionalAlbum.isPresent()) {
            albumService.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found");
        }

        return "redirect:/albumes";
    }
}
