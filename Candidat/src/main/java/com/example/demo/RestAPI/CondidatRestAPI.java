package com.example.demo.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entites.Condidat;
import com.example.demo.service.CandidatService;

@RestController
@RequestMapping("CondidatRestAPI")
public class CondidatRestAPI {


    @Autowired
    private CandidatService candidatService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Condidat> createCandidat(@RequestBody Condidat candidat) {
        return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Condidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Condidat candidat){
        return new ResponseEntity<>(candidatService.updateCandidat(id, candidat),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
    }
    
   @GetMapping(value = "/{id}")
    public ResponseEntity<Condidat> SerchCandidat(@PathVariable(value = "id") int id){
    
    	return new ResponseEntity<>(candidatService.GetCandidat(id),
HttpStatus.OK);
}
    
    
}
