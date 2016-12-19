/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragonheart;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Matejczuk
 */
public class Simulation {

    private static final int NUMBER_OF_DICES = 2;
    private static final boolean REROLL_BLANK = false;
    private static final boolean GREEDY_REROLL = false;
    private static final boolean ROLL_YELLOW = true;
    private static final boolean ROLL_ORANGE = true;
    private static final boolean ROLL_RED = true;

    public static void main(String[] args) {
        HashMap<Integer, Integer> rollsValues = new HashMap<>();
        Valuator dice = new Valuator();

        if (ROLL_YELLOW) {
            try {
                // Simulation for Yellow Dices
                rollsValues = dice.diceRollSimulation("yellow", NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
                printScoreFromMap("YELLOW", rollsValues);
            } catch (Exception ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ROLL_ORANGE) {
            try {
                // Simulation for Orange Dices
                rollsValues = dice.diceRollSimulation("orange", NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
                printScoreFromMap("ORANGE", rollsValues);
            } catch (Exception ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (ROLL_RED) {
            try {
                // Simulation for Red Dices
                rollsValues = dice.diceRollSimulation("red", NUMBER_OF_DICES, REROLL_BLANK, GREEDY_REROLL);
                printScoreFromMap("RED", rollsValues);
            } catch (Exception ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void printScoreFromMap(String diceType, HashMap<Integer, Integer> rollsValues) {
        System.out.println("***" + diceType + " DICES***");
        rollsValues.forEach((k, v) -> System.out.println("Value: " + k + " Occurence: " + v));
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("Weighted average: " + df.format(Valuator.weightedAverage(rollsValues)));
        rollsValues.clear();
    }
}
