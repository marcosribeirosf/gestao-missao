package com.algaworks.missao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.missao.model.Militar;

public interface Militares extends JpaRepository<Militar, Long> {
	
	
}