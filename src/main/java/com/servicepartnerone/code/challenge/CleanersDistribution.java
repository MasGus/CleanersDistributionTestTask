package com.servicepartnerone.code.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.servicepartnerone.code.challenge.entity.CleanerDistributionSet;
import com.servicepartnerone.code.challenge.entity.CleanerTask;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static com.servicepartnerone.code.challenge.exception.ExceptionMessages.NULL_VALUE_ARGUMENT;

/**
 * @author Maria.Guseva
 */
public class CleanersDistribution {
    private static List<CleanerDistributionSet> cleanerDistributionList = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        try {
            CleanerTask cleanerTask = new ObjectMapper().readValue(new FileReader(args[0]), CleanerTask.class);
            Integer seniorCapacity = cleanerTask.getSeniorCapacity();
            Integer juniorCapacity = cleanerTask.getJuniorCapacity();
            for (Integer room: cleanerTask.getRoomsNumberList()){
                CleanerDistributionSet cleanerDistributionSet = new CleanerDistributionSet();
                cleanerDistributionSet.calculateAndSetCleanersNumbers(room, seniorCapacity, juniorCapacity);
                cleanerDistributionList.add(cleanerDistributionSet);
            }
        } catch (InvalidDefinitionException ex){
            if (ex.getCause() instanceof IllegalArgumentException){
                throw new IllegalArgumentException(NULL_VALUE_ARGUMENT);
            }
            throw ex;
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(cleanerDistributionList);
        System.out.println(jsonInString);
    }
}
