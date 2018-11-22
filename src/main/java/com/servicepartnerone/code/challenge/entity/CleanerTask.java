package com.servicepartnerone.code.challenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.servicepartnerone.code.challenge.exception.WrongInputException;
import  org.jetbrains.annotations.*;

import java.util.List;

import static com.servicepartnerone.code.challenge.exception.ExceptionMessages.*;

/**
 * @author Maria.Guseva
 */
public class CleanerTask {
    private List<Integer> roomsNumberList;
    private Integer seniorCapacity;
    private Integer juniorCapacity;

    public CleanerTask(@NotNull @JsonProperty("rooms") List<Integer> roomsNumberList,
                       @NotNull @JsonProperty("senior") Integer seniorCapacity,
                       @NotNull @JsonProperty("junior") Integer juniorCapacity) {
        validate(roomsNumberList, seniorCapacity, juniorCapacity);
        this.roomsNumberList = roomsNumberList;
        this.seniorCapacity = seniorCapacity;
        this.juniorCapacity = juniorCapacity;
    }

    private void validate (final List<Integer> roomsNumberList,
                           final Integer seniorCapacity,
                           final Integer juniorCapacity){
        if (seniorCapacity < 0 || juniorCapacity < 0){
            throw new WrongInputException(NEGATIVE_CAPACITY);
        }
        for (Integer roomsNumber : roomsNumberList){
            if (roomsNumber < 0){
                throw new WrongInputException(NEGATIVE_NUMBER_OF_ROOMS);
            }
            if (roomsNumber > 100){
                throw new WrongInputException(TOO_BIG_NUMBER_OF_ROOMS);
            }
        }
        if (seniorCapacity <= juniorCapacity) {
            throw new WrongInputException(SENIOR_CAPACITY_HAVE_TO_BE_HIGHER);
        }
    }

    public List<Integer> getRoomsNumberList() {
        return roomsNumberList;
    }

    public Integer getSeniorCapacity() {
        return seniorCapacity;
    }

    public Integer getJuniorCapacity() {
        return juniorCapacity;
    }
}
