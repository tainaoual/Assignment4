package com.company;

import java.util.Random;

import java.util.Scanner;
public class Main {

        public static void initializeBoard(char board[]) {

            for(int i=0;i<9;i++){

                board[i]='-';

            }

        }

        public static char capitalize(String character) {

            return character.toUpperCase().charAt(0);
        }
        public static void printBoard(char board[]) {

            System.out.print("\nTic-Tac-Toe:\n");

            System.out.print(" ");

            for(int i=1;i<=3;i++){

                System.out.print(i+" ");
            }

            System.out.println();

            for(int i=0;i<3;i++){

                for(int j=0;j<3;j++){

                    if(j==0){

                        System.out.print((i+1)+" ");

                    }

                    System.out.print(board[i*3+j]+" ");

                }

                System.out.println();

            }

        }

        public static int convertToIndex(int rowCol) {

            int col = rowCol%10;

            int row = rowCol/10;

            int index = (row-1)*3+(col-1);

            return index;

        }

        public static boolean alreadyTaken(char board[], int position) {

            if(board[position]=='-'){

                return false;

            }

            return true;

        }

        public static void makePlacement(char board[], int position, char character) {

            board[position] = character;

        }
        public static int randomPosition(int size) {

            Random r = new Random();

            return r.nextInt(size);

        }

        public static boolean threeInRow(char a, char b, char c) {

            if(a==b && b==c){

                return true;

            }

            return false;

        }

        public static boolean gameOverWinner(char board[]) {

            char player = 'O';

            if(threeInRow(board[0],board[1],board[2]) && board[2] ==player ||

                    threeInRow(board[4],board[5],board[3]) && board[5] ==player ||

                    threeInRow(board[6],board[7],board[8]) && board[8] ==player

            ){

                return true;

            }

            if(threeInRow(board[0],board[3],board[6]) && board[6] ==player ||

                    threeInRow(board[1],board[4],board[7]) && board[7] ==player ||

                    threeInRow(board[8],board[5],board[2]) && board[8] ==player

            ){

                return true;

            }

            if(threeInRow(board[8],board[4],board[0]) && board[8] ==player ||

                    threeInRow(board[7],board[4],board[2]) && board[7] ==player

            ){

                return true;

            }

            player = 'X';

            if(threeInRow(board[0],board[1],board[2]) && board[2] ==player ||

                    threeInRow(board[4],board[5],board[3]) && board[5] ==player ||

                    threeInRow(board[6],board[7],board[8]) && board[8] ==player

            ){

                return true;

            }

            if(threeInRow(board[0],board[3],board[6]) && board[6] ==player ||

                    threeInRow(board[1],board[4],board[7]) && board[7] ==player ||

                    threeInRow(board[8],board[5],board[2]) && board[8] ==player

            ){

                return true;

            }

            if(threeInRow(board[8],board[4],board[0]) && board[8] ==player ||

                    threeInRow(board[7],board[4],board[2]) && board[7] ==player

            ){

                return true;

            }

            return false; // this line is provided so the skeleton compiles --

        }

        public static void main(String[] args) {

            System.out.println("Welcome to Tic-Tac-Toe!");

            char board[] = new char[9];

            char user,computer;

            System.out.print("Would you like to play as X or O : ");

            Scanner lineInput = new Scanner(System.in);

            char input = capitalize(lineInput.nextLine());

            if(input=='X'){

                user = 'X';

                computer = 'O';

            }else{

                user = 'O';

                computer = 'X';

            }

            initializeBoard(board);

            printBoard(board);

            Scanner number = new Scanner(System.in);

            int move;

            int numMoves = 0; //increments when player or game A.I. makes a move

            while(true){

                while(true){

                    System.out.print("Please enter your move: ");

                    move = number.nextInt();

                    move = convertToIndex(move);

                    if(!alreadyTaken(board, move)){

                        break;

                    }else{

                        System.out.println("Position already took. Please try again");

                    }

                }

                makePlacement(board, move, user);

                printBoard(board);

                numMoves++;

                if(gameOverWinner(board)){

                    System.out.println(user+" Wins!!!");

                    break;

                }

                System.out.println("Counter move!");

                while(true) {

                    move = randomPosition(9);

                    if (!alreadyTaken(board, move)) {

                        break;

                    }

                }}}}