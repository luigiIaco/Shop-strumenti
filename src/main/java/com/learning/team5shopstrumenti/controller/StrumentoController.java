package com.learning.team5shopstrumenti.controller;

import com.learning.team5shopstrumenti.interfaccie.StrumentoRepository;
import com.learning.team5shopstrumenti.model.Strumento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/strumenti")
public class StrumentoController {

    @Autowired
    private StrumentoRepository strumentoRepository;




    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String searchKeyword, Model model) {

        List<Strumento> strumenti;
        if (searchKeyword != null) {
            strumenti = strumentoRepository.findByMarcaContaining(searchKeyword);
        } else {
            strumenti = strumentoRepository.findAll();
        }
        model.addAttribute("area", "public");
        model.addAttribute("strumenti", strumenti);
        model.addAttribute("preloadSearch", searchKeyword);
        return "strumenti/list";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Strumento> result = strumentoRepository.findById(id);
        if (result.isPresent()) {
            Strumento strumento = result.get();
            model.addAttribute("strumento", strumento);
            return "strumenti/show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo strumento con id " + id + " non è stato trovato");
        }
    }
}