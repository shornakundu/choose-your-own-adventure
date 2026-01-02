// File Name: Shorna K CYOA Project Unit 3
// Author: Shorna Kundu
/* Description: The following program is an interactive type of game that allows players to make choices that influence the direction/outcome of the story.
The game is called Dora's Lost Bracelet and revolves around the player helping Dora to find her lost bracelet depending on the journey the user takes,
they could embark on a side quest that allows them to receive an item that may or may not assist them.
 */
// Date: April 9th, 2024
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // declaration of array list for story + choices, scanner for user input
        ArrayList<String> listStory = new ArrayList<>();
        ArrayList<String> validChoices = new ArrayList<>();
        Scanner info = new Scanner(System.in);


        // opening a file
        try {
            extractStory(listStory, validChoices);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // check if return is valid then continue into game
        boolean msg = introMessage(info);
        if (msg) {
            decisions(listStory, validChoices, info);
        }
    }

    // start screen --> Includes start message, FIGlet text, explanation of game

    /**
     * @param info <-- scanner to collect user info
     * @return <-- boolean return if false ends game
     */
    public static boolean introMessage(Scanner info) {

        // FIGlet text
        System.out.println("""

                ██████╗  ██████╗ ██████╗  █████╗ ███████╗    ██╗      ██████╗ ███████╗████████╗    ██████╗ ██████╗  █████╗  ██████╗███████╗██╗     ███████╗████████╗
                ██╔══██╗██╔═══██╗██╔══██╗██╔══██╗██╔════╝    ██║     ██╔═══██╗██╔════╝╚══██╔══╝    ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝██║     ██╔════╝╚══██╔══╝
                ██║  ██║██║   ██║██████╔╝███████║███████╗    ██║     ██║   ██║███████╗   ██║       ██████╔╝██████╔╝███████║██║     █████╗  ██║     █████╗     ██║  \s
                ██║  ██║██║   ██║██╔══██╗██╔══██║╚════██║    ██║     ██║   ██║╚════██║   ██║       ██╔══██╗██╔══██╗██╔══██║██║     ██╔══╝  ██║     ██╔══╝     ██║  \s
                ██████╔╝╚██████╔╝██║  ██║██║  ██║███████║    ███████╗╚██████╔╝███████║   ██║       ██████╔╝██║  ██║██║  ██║╚██████╗███████╗███████╗███████╗   ██║  \s
                ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝    ╚══════╝ ╚═════╝ ╚══════╝   ╚═╝       ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚══════╝╚══════╝╚══════╝   ╚═╝  \s
                                                                                                                                                                   \s
                """);

        // explanation of game
        System.out.println("Dora’s Lost Bracelet is an interactive type of game that allows players" + "to make choices that influence the direction/outcome of the story." +
                "\nTo make a choice either enter A, B, or C depending on the question.");


        // while loop to ask user if they would like to play returns false when they don't want to
        while (true) {
            System.out.print("Do you want to continue (y/n)? : \n");
            String answer = info.nextLine();
            answer = answer.toLowerCase();
            if (answer.equals("yes") || answer.equals("y") || answer.equals("ye")) {
                return true;
            } else if (answer.equals("no") || answer.equals("n")) {
                return false;
            } else {
                System.out.println("Opps thats not a choice");
            }
        }
    }


    /**
     * @param listStory    --> extracting file info and placeing into arraylist
     * @param validChoices --> extracting file info and placeing into arraylist
     * @throws FileNotFoundException --> exception
     */
    public static void extractStory(ArrayList<String> listStory, ArrayList<String> validChoices) throws FileNotFoundException {

        // opens file of story line + places into scanner
        File file1 = new File("storybook.txt");
        Scanner story = new Scanner(file1);

        // adds into array list --> liststory
        int count = 0;
        while (story.hasNextLine()) {
            listStory.add(count, story.nextLine());
            count++;
        }

        // opens file of choices + places into scanner
        File file2 = new File("choiceList.txt");
        Scanner choice = new Scanner(file2);

        // adds into array list --> validChoices
        count = 0;
        while (choice.hasNextLine()) {
            validChoices.add(count, choice.nextLine());
            count++;

        }
    }

    /**
     * @param listStory    --> access the pages of the story
     * @param validChoices --> the valid chocies for each page
     * @param info         --> scanner for user input
     */
    public static void decisions(ArrayList<String> listStory, ArrayList<String> validChoices, Scanner info) {

        // declaration of a deque for the choice history --> add zero to start at 1st page
        ArrayDeque<Integer> choiceHistory = new ArrayDeque<Integer>();
        choiceHistory.addFirst(0);

        while (true) {

            // go to the place in the choice history
            int place = choiceHistory.getLast();

            // splits each page's information by the period to allow for multi line print --> and then prints it out to player
            String[] listStorySplit = listStory.get(place).split("\\. ");
            for (int i = 0; i < listStorySplit.length; i++) {
                System.out.println(listStorySplit[i]);
            }
            // adds a line after a story --> separates user choice from story block
            System.out.println();

            // if empty means user has reached a ending page --> so game needs to end
            if (validChoices.get(place).equals("end")) {
                break;
            }

            // takes user input and places the valid choices into a array
            String answer = info.nextLine();
            String[] test = validChoices.get(place).split(", ");
            
            // if user inputs a certain letter code would check which letter and perform the specific task depending on what index in the string array corresponds with the index .
            if (Objects.equals(answer, "a") || Objects.equals(answer, "b") || Objects.equals(answer, "c")) {
                if (test.length == 2 && answer.equals("c")) {
                    System.out.println("c is not a valid option");
                } else if (test.length == 1 && answer.equals("b")) {
                    System.out.println("b is not a valid option");
                }

                // adds each choice into the choice history deque
                switch (answer) {
                    case "a" -> choiceHistory.addLast(Integer.valueOf(test[0]));
                    case "b" -> choiceHistory.addLast(Integer.valueOf(test[1]));
                    case "c" -> choiceHistory.addLast(Integer.valueOf(test[2]));
                }

                // if your on specifically page 8 you've reached the side quest so, during side quest
                // your given a question --> the following code checks if the answer the player gives is correct (your given 3 tries)
            } else {
                if (place == 8) {
                    for (int i = 0; i < 2; i++) {
                        if (!Objects.equals(answer, "31")) {
                            System.out.println("Incorrect try again");
                            answer = String.valueOf(Integer.parseInt(info.nextLine()));
                        } else {
                            break;
                        }
                    }
                    if (Objects.equals(answer, "31")) {
                        choiceHistory.addLast(13);
                    } else {
                        choiceHistory.addLast(12);
                    }
                } else {
                    System.out.println("Oops you can't do that");
                }
            }

        }

    }


}