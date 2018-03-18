package com.algaworks.missao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.missao.model.Missao;

public interface Missões extends JpaRepository<Missao, Long> {
	
	
}