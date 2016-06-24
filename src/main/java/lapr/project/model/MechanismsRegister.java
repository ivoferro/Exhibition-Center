/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representsa mechanism register for attribution mechanism list.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class MechanismsRegister implements Serializable {

    /**
     * List of attribution mechanism.
     */
    private List<StaffAttributionMechanism> attributionMechanismList;

    /**
     * Creates an instance of MechanismsRegister with its default values.
     */
    public MechanismsRegister() {
        attributionMechanismList = new ArrayList<>();
    }

    /**
     * Creates an instance of MechanismsRegister receiving a list of attribution
     * mechanism.
     *
     * @param attributionMechanismList list of attribution mechanism
     */
    public MechanismsRegister(List<StaffAttributionMechanism> attributionMechanismList) {
        this.attributionMechanismList = new ArrayList<>(attributionMechanismList);
    }

    /**
     * Creates an instance of MechanismsRegister copying another mechanisms
     * register.
     *
     * @param mechanismsRegister another mechanism register
     */
    public MechanismsRegister(MechanismsRegister mechanismsRegister) {
        this.attributionMechanismList = new ArrayList<>(mechanismsRegister.attributionMechanismList);
    }

    /**
     * Gets the attribution mechanism list.
     *
     * @return List of attribution mechanisms
     */
    public List<StaffAttributionMechanism> getAttributionMechanismList() {
        return new ArrayList<>(attributionMechanismList);
    }

    /**
     * Sets the attribution mechanism list.
     *
     * @param attributionMechanismList list of attribution mechanisms
     */
    public void setAttributionMechanismList(List<StaffAttributionMechanism> attributionMechanismList) {
        this.attributionMechanismList = new ArrayList<>(attributionMechanismList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("MechanismsRegister{");
        for (StaffAttributionMechanism staffAttributionMechanism : attributionMechanismList) {
            s.append(String.format("%s%n", staffAttributionMechanism));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compares if the given object is equal to this mechanisms register.
     *
     * @param otherObject Object to compare
     * @return true if the objects are equals, false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        MechanismsRegister otherMechanismsRegister = (MechanismsRegister) otherObject;

        return this.attributionMechanismList.equals(otherMechanismsRegister.attributionMechanismList);
    }

}
