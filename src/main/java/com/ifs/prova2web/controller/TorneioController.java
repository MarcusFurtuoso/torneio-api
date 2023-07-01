package com.ifs.prova2web.controller;

import com.ifs.prova2web.dto.TorneioDTO;
import com.ifs.prova2web.model.Torneio;
import com.ifs.prova2web.service.implementation.TorneioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/torneio")
public class TorneioController {

    @Autowired
    private TorneioServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TorneioDTO> getAll() {

        return service.listarTorneios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Torneio cadastrarTorneio(@RequestBody Torneio torneio) {
        return service.cadastrarTorneio(torneio);
    }

}
