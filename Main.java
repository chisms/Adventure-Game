package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	// Initializes and populate sthe hashmap with members from the location class.
	    
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

	// Adds directional controls to the game    
	
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        //tempExit.put("Q", 0);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

	// Adds specific location instances to the hash map    
	
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        //tempExit.put("Q", 0);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        //tempExit.put("Q", 0);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        //tempExit.put("Q", 0);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        //tempExit.put("Q", 0);
        locations.put(5, new Location(5, "You are in the forest",tempExit));


	// Adds directional controls to a seperate map, allowing for transitioning between locations    
	    
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        int loc = 1;
	    
	// Infinite while loop, program will end when user quits or reaches the predetermined exit.    
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
