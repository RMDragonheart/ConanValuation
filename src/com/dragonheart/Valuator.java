/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragonheart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Matejczuk
 */
public class Valuator {

    private static final int NUBMER_OF_ITERATION = 10_000_000;

    private ArrayList<Integer> yellowDice = new ArrayList<>();
    private ArrayList<Integer> orangeDice = new ArrayList<>();
    private ArrayList<Integer> redDice = new ArrayList<>();
    private int numberOfIteration;

    public Valuator() {
        initDice();
        numberOfIteration = NUBMER_OF_ITERATION;
    }

    public Valuator(int n) {
        initDice();
        numberOfIteration = n;
    }

    private void initDice() {
        // Yellow Valuator 0-2 Axes
        yellowDice.add(2);
        yellowDice.add(1);
        yellowDice.add(1);
        yellowDice.add(0);
        yellowDice.add(0);
        yellowDice.add(0);

        // Orange Valuator 0-2 Axes
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

    public HashMap<Integer, Integer> diceRollSimulation(String diceType, int numberOfDice, boolean reroll, boolean greedyReroll) throws Exception {
        HashMap<Integer, Integer> rollsValues = new HashMap<>();
        int value;
        int tmp;
        for (int i = 0; i < numberOfIteration; i++) {
            value = diceRoll(diceType, numberOfDice, reroll, greedyReroll);
            if (rollsValues.containsKey(value)) {
                tmp = rollsValues.get(value);
                tmp++;
                rollsValues.put(value, tmp);
            } else {
                rollsValues.put(value, 1);
            }
        }
        return rollsValues;
    }

    /**
     * Method return a random value from yellow dices
     *
     * @param diceType type of dice - yellow, orange, red
     * @param numberOfDices how many dices do you want to roll
     * @param rerollBlank if true, you will reroll blank dices
     * @param greedyReroll if true, you will reroll dices that have less than 2
     * axes not recomended for yellow dice.
     * @return
     */
    private int diceRoll(String diceType, int numberOfDices, boolean rerollBlank, boolean greedyReroll) throws Exception {
        int[] rolls = new int[numberOfDices];
        int value;

        ArrayList<Integer> list = getDiceArray(diceType);

        for (int i = 0; i < numberOfDices; i++) {
            Collections.shuffle(list);
            value = list.get(0);

            // Rerolls
            if (rerollBlank && value == 0 || greedyReroll && value < 2) {
                Collections.shuffle(list);
                value = list.get(0);
            }

            rolls[i] = value;
        }

        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += rolls[i];
        }

        return sum;
    }

    private ArrayList<Integer> getDiceArray(String diceType) throws Exception {
        switch (diceType.toLowerCase()) {
            case "yellow":
                return yellowDice;
            case "orange":
                return orangeDice;
            case "red":
                return redDice;
            default:
                throw new Exception("Wrong dice type (" + diceType + ")");
        }
    }

    public static double weightedAverage(HashMap<Integer, Integer> rollsValues) {
        double multiplicationSum = 0;
        double divider = 0;

        for (Map.Entry<Integer, Integer> m : rollsValues.entrySet()) {
            multiplicationSum += m.getKey() * m.getValue();
            divider += m.getValue();
        }
        return multiplicationSum / divider;
    }
}
