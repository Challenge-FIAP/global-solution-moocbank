package com.exemplocrud.repositorio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.exemplocrud.beans.User;

public interface UserRepositorio extends CrudRepository<User, Integer>{

    //Listar todos
    List<User> findAll();

    //Pesquisar por código
    User findById (int id);

    //Remover por código
    void delete(User user);

    //Cadastrar/Alterar
    <UserMod extends User>  UserMod save(UserMod user);
}
