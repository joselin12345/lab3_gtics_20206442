package com.example.lab3_20206442.controlador;

import com.example.lab3_20206442.entidad.Jugador;
import com.example.lab3_20206442.repositorio.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jugador")
public class JugadorController {

    final JugadorRepository jugadorRepository;
    public JugadorController(JugadorRepository jugadorRepository){
        this.jugadorRepository= jugadorRepository;
    }

    @GetMapping(value = {"","/listar"})
    public  String listar(Model model){
        List<Jugador> listaJugador = jugadorRepository.findAll();
        model.addAttribute("listaJugador",listaJugador);
        return "jugador/list";
    }

    @GetMapping("/borrar")
    public  String borrar(@RequestParam("id") Integer id){
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);
        if (optionalJugador.isPresent()){
            jugadorRepository.deleteById(id);
        }
        return "redirect:/jugador/listar";
    }

    @GetMapping("/crear")
    public String crear(){
        return "jugador/newForm";
    }

    @PostMapping("/guardar")
    public String guardar(Jugador jugador){
        jugadorRepository.save(jugador);
        return "redirect:/jugador/listar";
    }

}
