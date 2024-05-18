package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entites.Condidat;

public interface CandidatRepository extends JpaRepository<Condidat,Integer> {
}
