/**
 * The User class represents a player in the game, storing information about their in-game attributes.
 */
package com.game.characters;

public class User {
    /**
     * The amount of money the user has in the game.
     */
    private double money;

    /**
     * The reputation of the user in the game.
     */
    private int reputation;

    /**
     * The stress level of the user in the game.
     */
    private int stress;

    /**
     * Constructs a new User object with initial values of money, reputation, and stress set to zero.
     */
    public User() {
        this.money = 0;
        this.reputation = 0;
        this.stress = 0;
    }

    /**
     * Get the amount of money the user has.
     *
     * @return The current amount of money the user has.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Set the amount of money the user has.
     *
     * @param money The new amount of money to set.
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Get the reputation of the user.
     *
     * @return The current reputation of the user.
     */
    public int getReputation() {
        return reputation;
    }

    /**
     * Set the reputation of the user.
     *
     * @param reputation The new reputation value to set.
     */
    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    /**
     * Get the stress level of the user.
     *
     * @return The current stress level of the user.
     */
    public int getStress() {
        return stress;
    }

    /**
     * Set the stress level of the user.
     *
     * @param stress The new stress level to set.
     */
    public void setStress(int stress) {
        this.stress = stress;
    }
}
