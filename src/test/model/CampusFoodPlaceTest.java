package model;

import exceptions.NotProperRatingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampusFoodPlaceTest {
    private CampusFoodPlace campusFoodPlace;

    @BeforeEach
    void runBefore() {
        campusFoodPlace = new CampusFoodPlace("Starbucks", "Life Building",
                "cafe", true, 4);
    }


    @Test
    void testConstructor() {

        assertEquals("Starbucks", campusFoodPlace.getName());
        assertEquals("Life Building", campusFoodPlace.getLocation());
        assertEquals("cafe", campusFoodPlace.getCuisineType());
        assertTrue(campusFoodPlace.isVegan());
        assertEquals(4, campusFoodPlace.getRating());
    }

    @Test
    void testToString() {
        assertEquals
                (" name = Starbucks, location = Life Building,  cuisineType = cafe,  " +
                        "veganOption = true, rating = 4", campusFoodPlace.toString());
    }

    // tests for Phase 4

    @Test
    void testSetProperRating() {
        try {
            campusFoodPlace.setRating(4);
            assertEquals(4, campusFoodPlace.getRating());
        } catch (NotProperRatingException e) {
           fail();
        }
    }

    @Test
    void testSetNotProperRating() {
        try {
            campusFoodPlace.setRating(8);
            fail();
        } catch (NotProperRatingException e) {
            System.out.println("Please enter a rating from 0-5");
        }
    }

}
