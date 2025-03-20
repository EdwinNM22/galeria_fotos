package com.edwin.galeriademo.controller;

import com.edwin.galeriademo.model.foto;
import com.edwin.galeriademo.model.usuario;
import com.edwin.galeriademo.service.Uploadfoto;
import com.edwin.galeriademo.service.fotoService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/fotos")
public class fotoController {

    private final Logger LOGGER = LoggerFactory.getLogger(fotoController.class);

    @Autowired
    private fotoService fotoService;

    @Autowired
    private Uploadfoto upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("fotos", fotoService.findAll());
        return "fotos/show";
    }

    @GetMapping("/create")
    public String create() {
    return "fotos/create";}

    @PostMapping("/save")
    public String save(foto foto, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("Saving foto: {}", foto);
        usuario u= new usuario(1,"","","");
        foto.setUsuario(u);

        //imagen
        if (foto.getId() ==null){
            String nombrefoto = upload.saveImage(file);
            foto.setImagen(nombrefoto);
        } else{

        }

        fotoService.save(foto);
        return "redirect:/fotos/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id) {
        foto foto=new foto();
        Optional<foto> optionalFoto=fotoService.get(id);

        LOGGER.info("search foto: {}", optionalFoto);
         return "fotos/edit";
    }

    @PostMapping("/update")
    public String update(foto foto, @RequestParam("img") MultipartFile file) throws IOException {
        fotoService.update(foto);

        if (file.isEmpty()) {
            foto p= new foto();
            p = fotoService.get(foto.getId()).get();
            foto.setImagen(p.getImagen());
        }else{
            String nombrefoto = upload.saveImage(file);
            foto.setImagen(nombrefoto);
        }
        return "redirect:/fotos/";
    }


}
