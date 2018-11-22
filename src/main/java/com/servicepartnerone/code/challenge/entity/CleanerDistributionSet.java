package com.servicepartnerone.code.challenge.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

/**
 * @author Maria.Guseva
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CleanerDistributionSet implements Serializable {
    private Integer seniorNumber;
    private Integer juniorNumber;

    public void calculateAndSetCleanersNumbers(Integer rooms, Integer seniorCapacity, Integer juniorCapacity) {
        int seniorCounter = 0;
        int juniorCounter = 0;
        int sum = 0;
        int seniors = 0;
        int juniors = 0;
        while (sum < rooms) {
            sum += seniorCapacity;
            seniorCounter++;
        }
        seniors = seniorCounter;
        juniors = juniorCounter;
        while (seniorCounter > 1) {
            sum = sum - seniorCapacity + juniorCapacity;
            seniorCounter--;
            juniorCounter++;
            if (sum > rooms) {
                seniors = seniorCounter;
                juniors = juniorCounter;
            } else if (sum == rooms) {
                this.seniorNumber = seniorCounter;
                this.juniorNumber = juniorCounter;
                return;
            }
        }

        this.seniorNumber = seniors;
        this.juniorNumber = juniors;
    }

}
