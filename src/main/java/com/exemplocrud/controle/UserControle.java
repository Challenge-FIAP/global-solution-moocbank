package com.exemplocrud.controle;

import com.exemplocrud.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.exemplocrud.repositorio.UserRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserControle {

    // Ações
    @Autowired
    private UserRepositorio acoes;

    //Listar usuários
    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    List<User> listar() {
        return acoes.findAll();
    }

    // Cadastrar usuário
    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    User cadastrar(@RequestBody User user) {
        return acoes.save(user);
    }

    // Filtrar usuário
    @CrossOrigin
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User filtrar(@PathVariable int id) {
        return acoes.findById(id);
    }

    // Deletar usuário
    @CrossOrigin
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void remover(@PathVariable Integer id) {
        User user = filtrar(id);
        this.acoes.delete(user);
    }

    // Alterar usuário
    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody
    User alterar(@RequestBody User user) {
        return acoes.save(user);
    }
}