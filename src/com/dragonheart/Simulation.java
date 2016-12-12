/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragonheart;

import java.util.HashMap;

/**
 *
 * @author Robert Matejczuk
 */
public class Simulation {

    private static final int NUBMER_OF_ITERATION = 100;
    private static final int NUMBER_OF_DICES = 1;
    private static final boolean REROLL_BLANK = false;
    private static final boolean GREEDY_REROLL = false;

    public static void main(String[] args) {
        HashMap<Integer, Integer> rollsValues = new HashMap<>();
        Dice dice = new Dice();
        int value;
        int tmp;

        // Simulation for Yellow Dices
        for (int i = 0; i < NUBMER_OF_ITERATION; i++) {
            value = dice.rollYellowDices(NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
            if (rollsValues.containsKey(value)) {
                tmp = rollsValues.get(value);
                tmp++;
                rollsValues.put(value, tmp);
            } else {
                rollsValues.put(value, 1);
            }
        }

        System.out.println("***YELLOW DICES***");
        rollsValues.forEach((k, v) -> System.out.println("Value: " + k + " Occurence: " + v));
        rollsValues.clear();

        // Simulation for Orange Dices
        for (int i = 0; i < NUBMER_OF_ITERATION; i++) {
            value = dice.rollOrangeDices(NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
            if (rollsValues.containsKey(value)) {
                tmp = rollsValues.get(value);
                tmp++;
                rollsValues.put(value, tmp);
            } else {
                rollsValues.put(value, 1);
            }
        }

        System.out.println("***ORANGE DICES***");
        rollsValues.forEach((k, v) -> System.out.println("Value: " + k + " Occurence: " + v));
        rollsValues.clear();

        // Simulation for Red Dices
        for (int i = 0; i < NUBMER_OF_ITERATION; i++) {
            value = dice.rollRedDices(NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
            if (rollsValues.containsKey(value)) {
                tmp = rollsValues.get(value);
                tmp++;
                rollsValues.put(value, tmp);
            } else {
                rollsValues.put(value, 1);
            }
        }

        System.out.println("***RED DICES***");
        rollsValues.forEach((k, v) -> System.out.println("Value: " + k + " Occurence: " + v));
        rollsValues.clear();
    }
}
