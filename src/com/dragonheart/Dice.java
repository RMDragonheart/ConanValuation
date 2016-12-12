/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragonheart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Robert Matejczuk
 */
public class Dice {

    private ArrayList<Integer> yellowDice = new ArrayList<>();
    private ArrayList<Integer> orangeDice = new ArrayList<>();
    private ArrayList<Integer> redDice = new ArrayList<>();

    public Dice() {
        // Yellow Dice 0-2 Axes
        yellowDice.add(2);
        yellowDice.add(1);
        yellowDice.add(1);
        yellowDice.add(0);
        yellowDice.add(0);
        yellowDice.add(0);

        // Orange Dice 0-2 Axes
        orangeDice.add(2);
        orangeDice.add(2);
        orangeDice.add(1);
        orangeDice.add(1);
        orangeDice.add(0);
        orangeDice.add(0);

        // Red Doce 0-3 Axes
        redDice.add(3);
        redDice.add(2);
        redDice.add(2);
        redDice.add(1);
        redDice.add(1);
        redDice.add(0);
    }

    /**
     * Method return a random value from yellow dices
     *
     * @param numberOfDices how many dices do you want to roll
     * @param rerollBlank if true, you will reroll blank dices
     * @param greedyReroll if true, you will reroll dices that have less than 2
     * axes not recomended for yellow dice.
     * @return
     */
    public int rollYellowDices(int numberOfDices, boolean rerollBlank, boolean greedyReroll) {
        int[] rolls = new int[numberOfDices];
        int value;
        for (int i = 0; i < numberOfDices; i++) {
            Collections.shuffle(yellowDice);
            value = yellowDice.get(0);

            // Rerolls
            if (rerollBlank && value == 0 || greedyReroll && value < 2) {
                Collections.shuffle(yellowDice);
                value = yellowDice.get(0);
            }

            rolls[i] = value;
        }

        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += rolls[i];
        }

        return sum;
    }

    /**
     * Method return a random value from orange dices
     *
     * @param numberOfDices how many dices do you want to roll
     * @param rerollBlank if true, you will reroll blank dices
     * @param greedyReroll if true, you will reroll dices that have less than 2
     * axes
     * @return
     */
    public int rollOrangeDices(int numberOfDices, boolean rerollBlank, boolean greedyReroll) {
        int[] rolls = new int[numberOfDices];
        int value;
        for (int i = 0; i < numberOfDices; i++) {
            Collections.shuffle(orangeDice);
            value = orangeDice.get(0);

            // Rerolls
            if (rerollBlank && value == 0 || greedyReroll && value < 2) {
                Collections.shuffle(orangeDice);
                value = orangeDice.get(0);
            }

            rolls[i] = value;
        }

        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += rolls[i];
        }

        return sum;
    }

    /**
     * Method return a random value from red dices
     *
     * @param numberOfDices how many dices do you want to roll
     * @param rerollBlank if true, you will reroll blank dices
     * @param greedyReroll if true, you will reroll dices that have less than 2
     * axes
     * @return
     */
    public int rollRedDices(int numberOfDices, boolean rerollBlank, boolean greedyReroll) {
        int[] rolls = new int[numberOfDices];
        int value;
        for (int i = 0; i < numberOfDices; i++) {
            Collections.shuffle(redDice);
            value = redDice.get(0);

            // Rerolls
            if (rerollBlank && value == 0 || greedyReroll && value < 2) {
                Collections.shuffle(redDice);
                value = redDice.get(0);
            }

            rolls[i] = value;
        }

        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += rolls[i];
        }

        return sum;
    }
}
