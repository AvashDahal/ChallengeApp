package com.avashdahal.ChallengeApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/challenges")
public class ChallengeController
{
    private ServiceChallenge servicechallenge;//challenge object ta initialize bhako chaina
    public ChallengeController(ServiceChallenge servicechallenge)
    {


        this.servicechallenge= servicechallenge;
    }
    @GetMapping
  public ResponseEntity<List<Challenge>> getAllChallenges()
  {
      return new ResponseEntity<>(servicechallenge.getAllChallenges(),HttpStatus.OK);
  }
  @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge)
  {
     boolean isChallengeAdded= servicechallenge.addChallenge(challenge);
     if(isChallengeAdded)
     {
         return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
     }
     else
     {
         return new ResponseEntity<>("Challenge not added succesfully",HttpStatus.NOT_FOUND);
     }


  }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month)
    {
        Challenge challenge=servicechallenge.getChallenges(month);
        if (challenge != null)
        {
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge)
    {
        boolean isChallengeUpdated=servicechallenge.updateChallenge(id, updatedChallenge);

        if(isChallengeUpdated)
        {
            return new ResponseEntity<>("Challenge updated successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Challenge not added succesfully",HttpStatus.NOT_FOUND);
        }

    }

@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id)
{
   boolean ischallengedeleted= servicechallenge.deleteChallenge(id);
    if(ischallengedeleted)
    {
        return new ResponseEntity<>("Challenge deleted successfully",HttpStatus.OK);
    }
    else
    {
        return new ResponseEntity<>("Challenge not deleted ",HttpStatus.NOT_FOUND);
    }

}




}
