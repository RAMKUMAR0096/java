package com.leetcode.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean gameOver = false;
        char player = 'X';

        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        Scanner scan = new Scanner(System.in);

        while (!gameOver){
            displayBoard(board);
//            insert value
            System.out.print("Player " + player + " Enter: ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = hasWon(board,player);
                if(gameOver){
                    displayBoard(board);
                    System.out.println("Player " + player + " Won!");
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Already element present Please Try again!!");
            }
        }
    }

    public static boolean hasWon(char[][] board,char player){
        //check the row
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //check the column
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //check the diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player || board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
    public static void displayBoard(char[][] board){
        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
