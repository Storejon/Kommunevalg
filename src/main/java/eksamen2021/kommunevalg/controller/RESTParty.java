package eksamen2021.kommunevalg.controller;

import eksamen2021.kommunevalg.model.Party;
import eksamen2021.kommunevalg.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("party")
public class RESTParty {

    @Autowired
    PartyRepository partyRepository;

    @PostMapping(value = "/new", consumes = "application/json")
    public ResponseEntity<Party> createParty(@RequestBody Party party){
        partyRepository.save(party);
        return new ResponseEntity<>(party, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Party> displayParty(){
        return partyRepository.findAll();
    }

    @PutMapping("/update/{partyId}")
    public ResponseEntity<Party> updateParty(@PathVariable int partyId, @RequestBody Party updatedParty){
        Optional<Party> partyObj = partyRepository.findById(partyId);

        Party myPartyObject = partyObj.get();

        myPartyObject.setPartyName(updatedParty.getPartyName());

        myPartyObject = partyRepository.save(myPartyObject);

        return new ResponseEntity<>(myPartyObject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{partyId}")
    public ResponseEntity<Party> deleteParty(@PathVariable int partyId){
        partyRepository.deleteById(partyId);

        return ResponseEntity.ok().build();
    }
}
