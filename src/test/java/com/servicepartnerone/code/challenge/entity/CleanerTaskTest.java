package com.servicepartnerone.code.challenge.entity;

import com.servicepartnerone.code.challenge.exception.ExceptionMessages;
import com.servicepartnerone.code.challenge.exception.WrongInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Maria.Guseva
 */
public class CleanerTaskTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void validateNegativeSeniorCapacity() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.NEGATIVE_CAPACITY);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(1, 2)), -1, 1);
    }

    @Test
    public void validateNegativeJuniorCapacity() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.NEGATIVE_CAPACITY);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(1, 2)), 1, -1);
    }

    @Test
    public void validateNegativeRoomsNumber() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.NEGATIVE_NUMBER_OF_ROOMS);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(1, -1)), 2, 1);
    }

    @Test
    public void validateTooBigNumberOfRooms() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.TOO_BIG_NUMBER_OF_ROOMS);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(101, 2)), 2, 1);
    }

    @Test
    public void validateJuniorCapacityEqualSenior() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.SENIOR_CAPACITY_HAVE_TO_BE_HIGHER);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(1, 2)), 1, 1);
    }

    @Test
    public void validateJuniorCapacityHigherThanSenior() {
        expectedEx.expect(WrongInputException.class);
        expectedEx.expectMessage(ExceptionMessages.SENIOR_CAPACITY_HAVE_TO_BE_HIGHER);
        new CleanerTask(new LinkedList<Integer>(Arrays.asList(1, 2)), 1, 2);
    }
}