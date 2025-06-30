package com.purplemesh.logicalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class TicTac {

  private static final char EMPTY = '-';
  private static final char PLAYER = 'X';
  private static final char COMPUTER = 'O';
  private static final int SIZE = 3;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
    char[][] board = new char[SIZE][SIZE];

    initializeBoard(board);

    boolean playerTurn = true;
    boolean gameOver = false;

    while (!gameOver) {
      printBoard(writer, board);
      if (playerTurn) {
        playerMove(scanner, writer, board);
      } else {
        computerMove(writer, board);
      }
      if (checkWinner(board, playerTurn ? PLAYER : COMPUTER)) {
        printBoard(writer, board);
        writer.println((playerTurn ? "Player" : "Computer") + " wins!");
        gameOver = true;
      } else if (isBoardFull(board)) {
        printBoard(writer, board);
        writer.println("It's a draw!");
        gameOver = true;
      }
      playerTurn = !playerTurn;
    }

    scanner.close();
    writer.close();
  }

  private static void initializeBoard(char[][] board) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = EMPTY;
      }
    }
  }

  private static void printBoard(PrintWriter writer, char[][] board) {
    writer.println("Current Board:");
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        writer.print(board[i][j] + " ");
      }
      writer.println();
    }
  }

  private static void playerMove(Scanner scanner, PrintWriter writer, char[][] board) {
    int row;
    int col;
    while (true) {
      writer.println("Enter your move (row and column 0-2):");
      row = scanner.nextInt();
      col = scanner.nextInt();
      if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY) {
        board[row][col] = PLAYER;
        writer.println("Player marked at (" + row + ", " + col + ")");
        break;
      } else {
        writer.println("Invalid move, try again.");
      }
    }
  }

  private static void computerMove(PrintWriter writer, char[][] board) {
    Random random = new Random();
    int row;
    int col;
    while (true) {
      row = random.nextInt(SIZE);
      col = random.nextInt(SIZE);
      if (board[row][col] == EMPTY) {
        board[row][col] = COMPUTER;
        writer.println("Computer marked at (" + row + ", " + col + ")");
        break;
      }
    }
  }

  private static boolean checkWinner(char[][] board, char symbol) {
    for (int i = 0; i < SIZE; i++) {
      if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
        return true;
      }
    }
    for (int j = 0; j < SIZE; j++) {
      if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
        return true;
      }
    }
    if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
      return true;
    }
    if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
      return true;
    }
    return false;
  }

  private static boolean isBoardFull(char[][] board) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (board[i][j] == EMPTY) {
          return false;
        }
      }
    }
    return true;
  }
}