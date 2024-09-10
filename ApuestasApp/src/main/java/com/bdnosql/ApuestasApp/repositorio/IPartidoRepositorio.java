package com.bdnosql.ApuestasApp.repositorio;

import com.bdnosql.ApuestasApp.modelo.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidoRepositorio extends MongoRepository<Partido, Integer> {

}
