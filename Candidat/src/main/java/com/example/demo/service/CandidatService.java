package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repositories.CandidatRepository;
import com.example.demo.entites.Condidat;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidateRepository;
    public Condidat addCandidat(Condidat candidate) {
        return candidateRepository.save(candidate);
    }
    public Condidat updateCandidat(int id, Condidat  newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {
            Condidat existingCandidat = candidateRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidateRepository.save(existingCandidat);
        } else
            return null;
    }
    
    public  Condidat GetCandidat(int id)
    {    
    	   
    	if (candidateRepository.findById(id).isPresent()) {
    		Condidat existingCandidat = candidateRepository.findById(id).get();
    		return existingCandidat;
    	}
    	else return null;
    }
    
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
