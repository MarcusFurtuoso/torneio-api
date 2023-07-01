package com.ifs.prova2web.controller;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.form.UsuarioUpdate;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Usuario;
import com.ifs.prova2web.service.implementation.CategoriaServiceImpl;
import com.ifs.prova2web.service.implementation.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> getAll() {
        return service.consultarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO cadastrarTorneio(@RequestBody Usuario usuario) {
        return service.cadastrarUsuario(usuario);
    }

    public void login() {

    }
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return service.getUsuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioUpdate usuarioUpdate) {
       return service.update(id, usuarioUpdate);
    }
}
