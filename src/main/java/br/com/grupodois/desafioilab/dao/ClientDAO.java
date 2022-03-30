package br.com.grupodois.desafioilab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupodois.desafioilab.model.Client;

public interface ClientDAO extends JpaRepository<Client, Long>{

}
