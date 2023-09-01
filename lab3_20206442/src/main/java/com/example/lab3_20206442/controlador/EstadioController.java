package com.example.lab3_20206442.controlador;

import com.example.lab3_20206442.entidad.Estadio;
import com.example.lab3_20206442.entidad.Jugador;
import com.example.lab3_20206442.repositorio.EstadioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estadio")
public class EstadioController {

    final EstadioRepository estadioRepository;
    public EstadioController(EstadioRepository estadioRepository){
        this.estadioRepository = estadioRepository;
    }

    @GetMapping(value = {"","/listar"})
    public  String listar(Model model){
        List<Estadio> listaEstadio = estadioRepository.findAll();
        model.addAttribute("listaEstadio",listaEstadio);
        return "estadio/list";
    }

    @GetMapping("/borrar")
    public  String borrar(@RequestParam("id") Integer id){
        Optional<Estadio> optionalEstadio = estadioRepository.findById(id);
        if (optionalEstadio.isPresent()){
            estadioRepository.deleteById(id);
        }
        return "redirect:/estadio/listar";
    }

    @GetMapping("/crear")
    public String crear(){
        return "estadio/newForm";
    }

    @PostMapping("/guardar")
    public String guardar(Estadio estadio){
        estadioRepository.save(estadio);
        return "redirect:/estadio/listar";
    }

}
