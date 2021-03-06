package model;

import exceptions.NotProperRatingException;
import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// represents a tracker that contains campus food places
public class CampusFoodPlaceTracker implements Saveable {
    private List<CampusFoodPlace> foodPlaces;

    // EFFECTS: constructs an empty list of visited food places
    public CampusFoodPlaceTracker() {
        foodPlaces = new ArrayList<>();
    }

    // getter
    public List<CampusFoodPlace> getCampusFoods() {
        return this.foodPlaces;
    }

    // EFFECTS: returns the length of the list
    public int size() {
        return foodPlaces.size();
    }

    // EFFECTS: returns true if the campus food place tracker contains the given food place
    public boolean contains(CampusFoodPlace foodPlace) {
        return foodPlaces.contains(foodPlace);
    }


    // MODIFIES: this
    // EFFECTS: adds a campus food place to CampusFoodTracker if it is not already there
    public void addCampusFood(CampusFoodPlace foodPlace) {
        if (!contains(foodPlace)) {
            foodPlaces.add(foodPlace);
        }
    }


    // EFFECTS: returns the last visited campus food place in the list
    public CampusFoodPlace lastVisited() {
        //stub
        return foodPlaces.get(foodPlaces.size() - 1);
    }

    // EFFECTS: returns the names of all campus food places that have not been visited before
    public ArrayList<String> listOfNames() {
        ArrayList<String> str = new ArrayList<>();

        for (CampusFoodPlace cfp : this.getCampusFoods()) {
            str.add(cfp.getName());
        }
        return str;
    }


    // EFFECTS: returns the names of all campus food places that are vegan
    public ArrayList<String> listOfVeganPlaces() {
        ArrayList<String> veganPlaces = new ArrayList<>();

        for (CampusFoodPlace cfp : this.getCampusFoods()) {
            if (cfp.isVegan()) {
                veganPlaces.add(cfp.getName());
            }
        }
        return veganPlaces;
    }

    // MODIFIES: this
    // EFFECTS: sets the rating if the given name matches the name of CampusFoodPlace
    public boolean makeRating(String name, Integer rating) throws NotProperRatingException {
        for (CampusFoodPlace s : foodPlaces) {
            if (s.getName().equals(name)) {
                s.setRating(rating);
                return true;
            }
        }
        return false;
    }

    //EFFECT: returns the food place at given index
    public CampusFoodPlace getCampusFoodPlace(int index) {
        return foodPlaces.get(index);
    }

    // EFFECT: saves all the campus food places in a list of food places
    @Override
    public void save(PrintWriter printWriter) {
        for (CampusFoodPlace cfp : foodPlaces) {
            cfp.save(printWriter);
        }
    }
}





