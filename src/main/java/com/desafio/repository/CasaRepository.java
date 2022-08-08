package com.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.entidades.Casa;

@Repository
public interface CasaRepository extends CrudRepository<Casa, Integer>{

}
