package com.avashdahal.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ServiceChallenge
{
    private List<Challenge> challenges= new ArrayList<>();
    private long nextId = 1L;
    public ServiceChallenge()
    {

    }
    public List<Challenge> getAllChallenges()
    {
        return challenges;
    }
    public boolean addChallenge(Challenge challenge)
    {
        if(challenge !=null)
        {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Challenge getChallenges(String month)
    {
        for (Challenge challenge:challenges)
        {
            if(challenge.getMonth().equalsIgnoreCase(month))//equalsIgnoreCase le garda case sensitivity khyal gardeina
            {
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge)
    {
        for (Challenge challenge:challenges)
    {
        if(challenge.getId()==(id))
        {
            challenge.setMonth(updatedChallenge.getMonth());
            challenge.setDescription(updatedChallenge.getDescription());
            return true;
        }
    }
        return false;



    }

    public boolean deleteChallenge(Long id)
    {
      return challenges.removeIf(challenge -> challenge.getId()==id); //lambda expresion Arraylist ma matragarna paiyo
    }
}
