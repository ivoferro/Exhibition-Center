/**
 * Package location for Model concepts.
 */
package lapr.project.model;

/**
 * Represents a place.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Place {

    /**
     * The place location.
     */
    private String location;

    /**
     * The place location by default.
     */
    private static final String DEFAULT_LOCATION = "default location";

    /**
     * Default constructor of a place class.
     */
    public Place() {
        this.location = DEFAULT_LOCATION;
    }

    /**
     * Constructor that receives an instance of this class as parameter.
     *
     * @param location places location
     */
    public Place(String location) {
        this.location = location;
    }

    /**
     * Obtain the places location.
     *
     * @return places location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the places location.
     *
     * @param location the places location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Return the textual representation of a place.
     *
     * @return the textual representation of a place
     */
    @Override
    public String toString() {
        return String.format("Place{%nlocation=%s%n", this.location);
    }

    /**
     * Compares two Place objects.
     *
     * @param otherObject Object to compare
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Place otherPlace = (Place) otherObject;

        return this.location.equalsIgnoreCase(otherPlace.location);
    }
}
