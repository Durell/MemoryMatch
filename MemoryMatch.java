/* Chapter No. 7
 * Program: Project 7
 * File Name: MemoryMatch.java
 * Programmer: Durell Smith
 * Date Last Modified: December 15, 2015
 
 * Problem Statement:
 *
 * A common memory matching game played by young children is to start with a
 * deck of cards that contain identical pairs. For example, given six cards in the deck,
 * two might be labeled 1, two labeled 2, and two labeled 3. The cards are shuffled
 * and placed face down on the table. A player then selects two cards that are face
 * down, turns them face up, and if the cards match, they are left face up. If the two
 * cards do not match, they are returned to their original face down position. The
 * game continues until all cards are face up.
 * Write a program that plays the memory matching game. Use 16 cards that are laid
 * out in a 4 x 4 square and are labeled with pairs of numbers from 1 to 8. Your
 * program should allow the player to specify the cards that he or she would like to
 * select through a coordinate system.
 * For example, in the following layout,
 *
 * 1 2 3 4
 * 1 8 * * *
 * 2 * * * *
 * 3 * 8 * *
 * 4 * * * *
 *
 * all of the face down cards are indicated by *. The pairs of 8 that are face up are at
 * coordinates (1,1) and (2,3). To hide the cards that have been temporarily placed
 * face up, output a large number of newlines to force the old board off the screen.
 * Hint: Use a 2D array for the arrangement of cards and another 2D array that
 * indicates if a card is face up or face down. Or, a more elegant solution is to create
 * a single 2D array where each element is an object that stores both the card’s value
 * and face. Write a function that “shuffles” the cards in the array by repeatedly selecting
 * two cards at random and swapping them.
 * 
 */

// Declare Imports

import java.util.Scanner;
import java.util.Random;

public class MemoryMatch
{
    Card[] deck = new Card[16];
    boolean t = true;


    // Constants

    // Constructors:
    public MemoryMatch()
    {
        for (int i = 0; i < 8; i++)
        {
            deck[i] = new Card(i + 1);
            deck[i+8] = new Card(i + 1);
        }
    }

    public boolean gameOver()
    {
        return ((deck[0].getShow()) && (deck[1].getShow()) && (deck[2].getShow()) && (deck[3].getShow()) && (deck[4].getShow()) && (deck[5].getShow()) && (deck[6].getShow()) && (deck[7].getShow()) && (deck[8].getShow()) && (deck[9].getShow()) && (deck[10].getShow())  && (deck[11].getShow())  && (deck[12].getShow())  && (deck[13].getShow())  && (deck[14].getShow())  && (deck[15].getShow()));
    }

    public void showDeck()
    {
        for (int i = 0; i < deck.length; i+=4)
        {
            System.out.print("       "+ deck[i].getNum() + " " 
                             + deck[i+1].getNum() + " " 
                             + deck[i+2].getNum() + " " 
                             + deck[i+3].getNum() + "\n");
        }
    }

    public void clearConsole()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void play()
    {
        boolean over = false;
        Scanner keyboard = new Scanner (System.in); 
        Card fc = new Card(); // track first choice to compare to second
        Card sc = new Card();
        boolean goodChoice = false;
        while (!over)
        {
            goodChoice = false;
            String c = "";
            int x = 0, y = 0, x2 = 0, y2 = 0 ;

            showBoard();

            while (!goodChoice)
            {
                System.out.print("Please give me \"x y\" coordinates (seperated by space) > ");
                x = keyboard.nextInt();
                y = keyboard.nextInt();
                if ((x == 1) && (y == 1)) { deck[0].setShow(t); goodChoice = true; fc = deck[0]; }
                else if ((x == 2) && (y == 1)) { deck[1].setShow(t); goodChoice = true; fc = deck[1]; }
                else if ((x == 3) && (y == 1)) { deck[2].setShow(t); goodChoice = true; fc = deck[2]; }
                else if ((x == 4) && (y == 1)) { deck[3].setShow(t); goodChoice = true; fc = deck[3]; }
                else if ((x == 1) && (y == 2)) { deck[4].setShow(t); goodChoice = true; fc = deck[4]; }
                else if ((x == 2) && (y == 2)) { deck[5].setShow(t); goodChoice = true; fc = deck[5]; }
                else if ((x == 3) && (y == 2)) { deck[6].setShow(t); goodChoice = true; fc = deck[6]; }
                else if ((x == 4) && (y == 2)) { deck[7].setShow(t); goodChoice = true; fc = deck[7]; }
                else if ((x == 1) && (y == 3)) { deck[8].setShow(t); goodChoice = true; fc = deck[8]; }
                else if ((x == 2) && (y == 3)) { deck[9].setShow(t); goodChoice = true; fc = deck[9]; }
                else if ((x == 3) && (y == 3)) { deck[10].setShow(t); goodChoice = true; fc = deck[10]; }
                else if ((x == 4) && (y == 3)) { deck[11].setShow(t); goodChoice = true; fc = deck[11]; }
                else if ((x == 1) && (y == 4)) { deck[12].setShow(t); goodChoice = true; fc = deck[12]; }
                else if ((x == 2) && (y == 4)) { deck[13].setShow(t); goodChoice = true; fc = deck[13]; }
                else if ((x == 3) && (y == 4)) { deck[14].setShow(t); goodChoice = true; fc = deck[14]; }
                else if ((x == 4) && (y == 4)) { deck[15].setShow(t); goodChoice = true; fc = deck[15]; }
                else 
                    System.out.println("Out of range! Try again.");
            }
    
            showBoard();
            goodChoice = false;
            while (!goodChoice)
            {
                System.out.print("Please give me \"x y\" coordinates (seperated by space) > ");
                x2 = keyboard.nextInt();
                y2 = keyboard.nextInt();
                if ((x2 == x) && (y2 == y)) { System.out.println("Same as first choice! Try again."); }
                else if ((x2 == 1) && (y2 == 1)) { deck[0].setShow(t); goodChoice = true; sc = deck[0]; }
                else if ((x2 == 2) && (y2 == 1)) { deck[1].setShow(t); goodChoice = true; sc = deck[1]; }
                else if ((x2 == 3) && (y2 == 1)) { deck[2].setShow(t); goodChoice = true; sc = deck[2]; }
                else if ((x2 == 4) && (y2 == 1)) { deck[3].setShow(t); goodChoice = true; sc = deck[3]; }
                else if ((x2 == 1) && (y2 == 2)) { deck[4].setShow(t); goodChoice = true; sc = deck[4]; }
                else if ((x2 == 2) && (y2 == 2)) { deck[5].setShow(t); goodChoice = true; sc = deck[5]; }
                else if ((x2 == 3) && (y2 == 2)) { deck[6].setShow(t); goodChoice = true; sc = deck[6]; }
                else if ((x2 == 4) && (y2 == 2)) { deck[7].setShow(t); goodChoice = true; sc = deck[7]; }
                else if ((x2 == 1) && (y2 == 3)) { deck[8].setShow(t); goodChoice = true; sc = deck[8]; }
                else if ((x2 == 2) && (y2 == 3)) { deck[9].setShow(t); goodChoice = true; sc = deck[9]; }
                else if ((x2 == 3) && (y2 == 3)) { deck[10].setShow(t); goodChoice = true; sc = deck[10]; }
                else if ((x2 == 4) && (y2 == 3)) { deck[11].setShow(t); goodChoice = true; sc = deck[11]; }
                else if ((x2 == 1) && (y2 == 4)) { deck[12].setShow(t); goodChoice = true; sc = deck[12]; }
                else if ((x2 == 2) && (y2 == 4)) { deck[13].setShow(t); goodChoice = true; sc = deck[13]; }
                else if ((x2 == 3) && (y2 == 4)) { deck[14].setShow(t); goodChoice = true; sc = deck[14]; }
                else if ((x2 == 4) && (y2 == 4)) { deck[15].setShow(t); goodChoice = true; sc = deck[15]; }
                else 
                    System.out.println("Out of range! Try again.");
            }
    
            showBoard();
            if (fc.equals(sc))
            {
                System.out.println("    ---- Match---- ");
                c = keyboard.nextLine();
            }
            else if (!fc.equals(sc))
            {
                c = keyboard.nextLine();
                fc.setShow(false);
                sc.setShow(false);
            }
            System.out.println("Press enter to continue or type \"q\" to quit");
            c = keyboard.nextLine();
            over = gameOver();
            if (c.equals("q"))
                over = true;
            clearConsole();
        }

    }

    public void shuffleDeck()
    {
        Random ran = new Random();
        int i = 0,
            swap = 0;

        while (i < 1000)
        {
            int p1 = ran.nextInt(16);
            int p2 = ran.nextInt(16);
            swap = deck[p1].getNum();
            deck[p1].setNum(deck[p2].getNum());
            deck[p2].setNum(swap);
            i++;
        }
    }

    public void showBoard()
    {
        System.out.println();
        System.out.println("                   (x) ");
        System.out.println("            •-------------•");
        System.out.println("            |    1 2 3 4  |");
        System.out.println("            |  1 " + deck[0].displayCard() + " " + deck[1].displayCard() + " " + deck[2].displayCard() + " " + deck[3].displayCard() + "  |");
        System.out.println("        (y) |  2 " + deck[4].displayCard() + " " + deck[5].displayCard() + " " + deck[6].displayCard() + " " + deck[7].displayCard() + "  |");
        System.out.println("            |  3 " + deck[8].displayCard() + " " + deck[9].displayCard() + " " + deck[10].displayCard() + " " + deck[11].displayCard() + "  |");
        System.out.println("            |  4 " + deck[12].displayCard() + " " + deck[13].displayCard() + " " + deck[14].displayCard() + " " + deck[15].displayCard() + "  |");
        System.out.println("            •-------------•");
        System.out.println();
    }
    
    public void showMap()
    {
         System.out.println(deck[0] + "   " + deck[1] + "   " + deck[2] + "   ");
         System.out.println();
         System.out.println(deck[1] + "   " + deck[1] + "   " + deck[1] + "   ");
         System.out.println();
         System.out.println(deck[2] + "   " + deck[2] + "   " + deck[2] + "   ");
         
         System.out.println("Please input a number");
    }


    public static void main(String[] args)
    {
        // Setup
        
        System.out.println("                    ");
        System.out.println("             --------------  ");
        System.out.println("            * Memory Match * ");
        System.out.println("             --------------  ");
        System.out.println("Each asterisk has a number under it (1 - 8). There are two of every number.");
        System.out.println("Each turn you flip over two cards, if they match they stay flipped over.");
        System.out.println("If the cards don't match they are flipped back over and the board will clear.");
        System.out.println("The objective is simple, Get all the cards face up!");
        MemoryMatch game = new MemoryMatch();
        System.out.println();
        game.shuffleDeck();
        game.play();



        /*
        Scanner readin = new Scanner(System.in); // Scanner used to accept input from console or file
        float n1 = 0; // example variable n1 declared as type float
        */
    }
}
