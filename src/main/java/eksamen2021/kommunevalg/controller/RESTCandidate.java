package eksamen2021.kommunevalg.controller;

import eksamen2021.kommunevalg.model.Candidate;
import eksamen2021.kommunevalg.model.Party;
import eksamen2021.kommunevalg.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/candidate")
public class RESTCandidate {

    @Autowired
    CandidateRepository candidateRepository;

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate){

        candidateRepository.save(candidate);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Candidate> displayCandidate(){
        return candidateRepository.findAll();
    }

    @PutMapping("/update/{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable int candidateId, @RequestBody Candidate updatedCandidate){
        Optional<Candidate> candidateObj = candidateRepository.findById(candidateId);

        Candidate myCandidateObject = candidateObj.get();

        myCandidateObject.setName(updatedCandidate.getName());
        myCandidateObject.setParty(updatedCandidate.getParty());

        myCandidateObject = candidateRepository.save(myCandidateObject);

        return new ResponseEntity<>(myCandidateObject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{candidateId}")
    public ResponseEntity<Candidate> deleteCandidate(@PathVariable int candidateId){
        candidateRepository.deleteById(candidateId);

        return ResponseEntity.ok().build();
    }
}
