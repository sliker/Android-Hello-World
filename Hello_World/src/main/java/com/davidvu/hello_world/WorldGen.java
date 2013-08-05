package com.davidvu.hello_world;

/**
 * Created by david.velasquez on 8/2/13.
 */
public class WorldGen {
    String planetName = "earth";
    int planetMass;
    double planetGravity;
    int planetColonies;
    long planetPopulation;
    int planetBases;
    int planetMilitary;
    boolean planetProtection;

    public WorldGen (String name, int mass, double gravity) {
        planetName = name;
        planetMass = mass;
        planetGravity = 0;
        planetColonies = 0;
        planetPopulation = 0;
        planetBases = 0;
        planetMilitary = 0;
        planetProtection = false;
    }

    void setPlanetColonies (int numColonies) {
        planetColonies += numColonies;
    }

    int getPlanetColonies() {
        return planetColonies;
    }

    void setPlanetMilitary (int numBases) {
        planetBases += numBases;
    }

    int getPlanetMilitary() {
        return planetBases;
    }

    void turnForceFieldOn() {
        planetProtection = true;
    }

    void turnForceFieldOff() {
        planetProtection = false;
    }

    boolean getForceFieldState() {
        return planetProtection;
    }

    void setColonyImmigration (int numColonies) {
        planetPopulation += numColonies;
    }

    long getColonyImmigration() {
        return planetPopulation;
    }

    void setBaseProtection (int numForces) {
        planetMilitary += numForces;
    }

    int getBaseProtection() {
        return planetMilitary;
    }
}
