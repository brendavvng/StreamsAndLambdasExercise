package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("Luke Skywalker", 172, 77, "blue", "male"));
        characters.add(new Character("Darth Vader", 202, 136, "yellow", "male"));
        characters.add(new Character("Leia Organa", 150, 49, "brown", "female"));
        characters.add(new Character("Anakin Skywalker", 188, 84, "blue", "male"));

        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 1. Print names in UPPERCASE using map and forEach
        characters.stream()
                .map(character -> character.getName().toUpperCase())
                .forEach(name -> System.out.println(name));

        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 2. Filter characters with mass > 80 using .filter and .collect(Collectors.toList())
        // store the results in a variable called heavyCharacters and display the new list
        // creating a new list to hold our heavy characters
        // using streams and filter methods to ask if the mass is > 80
        // if mass is > 80, they get added to the list
        List<Character> heavyCharacters = characters.stream()
                // filter wants to return the whole object
                .filter(character -> character.getMass() > 80)
                .toList();
        // looping over heavy characters to display list
        heavyCharacters.forEach(character -> System.out.println(character.getName() + " " + character.getMass()));


        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 3. Create a new list of just character names using .map and .collect(Collectors.toList())
        // the new list should be called names. Display the new list with a loop
        // using "String" to store the characters name, you're returning the string representation of the name
        List<String> names = characters.stream()
                // map helps us gets the names, it doesnt have to be the whole object
                .map(character -> character.getName())
                .toList();
                // you could also use this:
                //.collect(Collectors.toList());
        names.forEach(name -> System.out.println(name));


        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 4. Use anyMatch to check for blue eyes and let us know if any character has blue eyes
        boolean hasBlueEyes = characters.stream()
                // any match is going to return true or false
                .anyMatch(character -> character.getEyeColor().equalsIgnoreCase("blue"));

        if (hasBlueEyes) {
            System.out.println("Some characters have blue eyes!");
        } else {
            System.out.println("No characters have blue eyes...");
        }

        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 5. Use allMatch to check if all are male and let us know if all characters are male
        boolean allMale = characters.stream()
                .allMatch(character -> character.getGender().equalsIgnoreCase("male"));

        if (allMale) {
            System.out.println("All characters are male!");
        } else {
            System.out.println("There are male and female characters.");
        }

        System.out.println("∘₊✧──────────────────────────────✧₊∘");

        // 6. Use .mapToInt and .sum to calculate total mass of all characters and then display the total mass
        int totalMass = characters.stream()
                .mapToInt(character -> character.getMass())
                .sum();
        System.out.println("Total mass: " + totalMass);
        System.out.print("Average mass" + totalMass / characters.size());

    }


}
