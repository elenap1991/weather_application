package org.example;

import java.util.Scanner;

public class ConsoleInput {
    private String userInput;
    private final static String EXIT = "exit";
    private final static String MSG = String.format("Введите название города или %s для выхода: ", EXIT);

    public ConsoleInput(){
        this.userInput = this.setUserInput();
    }

    private String setUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(MSG);
            userInput = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userInput = EXIT;
        }
        return userInput;
    }

    public String getUserInput() {
        return userInput;
    }

}
