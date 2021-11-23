import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

        printBoard(board);

        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);

            computerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
                || (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
                || (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
                || (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
                || (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] board, String position) {
        switch (position) {
        case "1":
            return (board[0][0] == ' ');
        case "2":
            return (board[0][1] == ' ');
        case "3":
            return (board[0][2] == ' ');
        case "4":
            return (board[1][0] == ' ');
        case "5":
            return (board[1][1] == ' ');
        case "6":
            return (board[1][2] == ' ');
        case "7":
            return (board[2][0] == ' ');
        case "8":
            return (board[2][1] == ' ');
        case "9":
            return (board[2][2] == ' ');
        default:
            return false;
        }
    }

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
        case "1":
            board[0][0] = symbol;
            break;
        case "2":
            board[0][1] = symbol;
            break;
        case "3":
            board[0][2] = symbol;
            break;
        case "4":
            board[1][0] = symbol;
            break;
        case "5":
            board[1][1] = symbol;
            break;
        case "6":
            board[1][2] = symbol;
            break;
        case "7":
            board[2][0] = symbol;
            break;
        case "8":
            board[2][1] = symbol;
            break;
        case "9":
            board[2][2] = symbol;
            break;
        default:
            System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

}

// import java.util.Scanner;
// import javax.swing.JOptionPane;

// public class TicTacToe {
// public static void main(String[] args) {

// Scanner scan = new Scanner(System.in);
// int firstplay, secondplay, thirdplay;
// int fourthplay, fifthplay, sixthplay;
// int seventhplay, eighthplay, ninthplay;
// int first = 1, second = 2, third = 3;
// int fourth = 4, fifth = 5, sixth = 6;
// int seventh = 7, eighth = 8, ninth = 9;
// char x = 'X', o = 'O';
// String firstPlayer, secondPlayer;

// System.out.print("\nEnter the name of the Player 1: \n");
// firstPlayer = scan.nextLine();

// System.out.print("\nEnter the name of the Player 2: \n");
// secondPlayer = scan.nextLine();

// System.out.println("\n" + firstPlayer + " will be Player 1 and " +
// secondPlayer + " will be Player 2!\n");

// System.out.println(
// "\nThis is a game of a Tic-Tac-Toe the players must type the number where
// they want to place their symbol\n"
// + firstPlayer + " will be Player 1 and will start the game with X\n" +
// secondPlayer
// + " will be Player 2 and will start the game with O\n");

// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);

// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// while (firstplay < 1 || firstplay > 9) {
// System.out.print("\nSorry the value that you entered is incorrect.\n"
// + "\nEnter a number from 1 to 9 deepending on the place yuo want to put X:
// \n");
// firstplay = scan.nextInt();
// }

// if (firstplay == first) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// // !the second move
// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();

// if (secondplay == second) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// // ! third move
// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// if (firstplay == third) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + fifth
// + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// // !fourth move
// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();

// if (secondplay == fourth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + fifth + "
// " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// // !fifth move
// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// if (firstplay == fifth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// // ! sixth move
// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();

// if (secondplay == sixth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// o
// + "\n" + seventh + " " + eighth + " " + ninth);
// // !seventh move
// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// if (firstplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// o
// + "\n" + x + " " + eighth + " " + ninth);// ? here is a win
// } else if (firstplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth
// + " " + sixth + "\n" + seventh + " " + x + " " + ninth);
// // !seventh move
// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();

// if (secondplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " "
// + o + "\n" + seventh + " " + x + " " + o);
// // !eight move
// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// if (firstplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// o
// + "\n" + seventh + " " + o + " " + x);// ? here is a win
// // !eight move
// } else if (secondplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " "
// + sixth + "\n" + seventh + " " + eighth + " " + o);
// }

// // !eight move
// } else if (firstplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth
// + " " + sixth + "\n" + seventh + " " + eighth + " " + x);
// }

// // !seventh move
// } else if (secondplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + o + " " + eighth + " " + ninth);
// //! eighth move
// System.out.print("\nEtner the number of the place you want to enter the
// X:\n");
// firstplay = scan.nextInt();

// if (firstplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + o + " " + x + " " + ninth);
// //! next move
// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();
// if (secondplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + o + " " + x + " " + o);
// }

// //! next move
// } else if (firstplay == ninth){
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + o + " " + eighth + " " + x);//?here is a win
// }
// //! eighth move
// } else if (secondplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + seventh + " " + o + " " + ninth);
// } else if (secondplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + x + " " +
// sixth
// + "\n" + seventh + " " + eighth + " " + o);
// }

// // ! sixth move
// } else if (firstplay == sixth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + fifth + "
// " + x
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + fifth + "
// " + sixth
// + "\n" + x + " " + eighth + " " + ninth);
// } else if (firstplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + fifth + "
// " + sixth
// + "\n" + seventh + " " + x + " " + ninth);
// } else if (firstplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + o + " " + fifth + "
// " + sixth
// + "\n" + seventh + " " + eighth + " " + x);
// }

// // !fifth move
// } else if (secondplay == fifth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + o + "
// " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == sixth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + fifth
// + " " + o
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + fifth
// + " " + sixth
// + "\n" + o + " " + eighth + " " + ninth);
// } else if (secondplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + fifth
// + " " + sixth
// + "\n" + seventh + " " + o + " " + ninth);
// } else if (secondplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + x + "\n" + fourth + " " + fifth
// + " " + sixth
// + "\n" + seventh + " " + eighth + " " + o);
// }
// // !fourth move
// } else if (firstplay == fourth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + x + " " + fifth
// + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == fifth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " + x
// + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == sixth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth + " " + x
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == seventh) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth + " " + sixth
// + "\n" + x + " " + eighth + " " + ninth);
// } else if (firstplay == eighth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth + " " + sixth
// + "\n" + seventh + " " + x + " " + ninth);
// } else if (firstplay == ninth) {
// System.out.println("\n" + x + " " + o + " " + third + "\n" + fourth + " " +
// fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + x);
// }

// // ! third move

// } else if (secondplay == third) {
// System.out.println("\n" + x + " " + second + " " + o + "\n" + fourth + " " +
// fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == fourth) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + o + " " +
// fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == fifth) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + o + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == sixth) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + o
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == seventh) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + o + " " + eighth + " " + ninth);
// } else if (secondplay == eighth) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + o + " " + ninth);
// } else if (secondplay == ninth) {
// System.out.println("\n" + x + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + o);
// }
// // !the second move
// } else if (firstplay == second) {
// System.out.println("\n" + first + " " + x + " " + third + "\n" + fourth + " "
// + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == third) {
// System.out.println("\n" + first + " " + second + " " + x + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == fourth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + x + " "
// + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == fifth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + x + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == sixth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + x
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (firstplay == seventh) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + x + " " + eighth + " " + ninth);
// } else if (firstplay == eighth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + seventh + " " + x + " " + ninth);
// } else if (firstplay == ninth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + x);
// }

// // fist action is done now the second

// System.out.print("\nEtner the number of the place you want to enter the
// O:\n");
// secondplay = scan.nextInt();

// while (secondplay < 1 || secondplay > 9) {
// System.out.print("\nSorry the value that you entered is incorrect.\n"
// + "\nEnter a number from 1 to 9 deepending on the place yuo want to put X:
// \n");
// secondplay = scan.nextInt();
// }

// if (secondplay == first) {
// System.out.println("\n" + o + " " + second + " " + third + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == second) {
// System.out.println("\n" + first + " " + o + " " + third + "\n" + fourth + " "
// + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == third) {
// System.out.println("\n" + first + " " + second + " " + o + "\n" + fourth + "
// " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == fourth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + o + " "
// + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == fifth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + o + " " + sixth
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == sixth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + o
// + "\n" + seventh + " " + eighth + " " + ninth);
// } else if (secondplay == seventh) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + o + " " + eighth + " " + ninth);
// } else if (secondplay == eighth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + seventh + " " + o + " " + ninth);
// } else if (secondplay == ninth) {
// System.out.println("\n" + first + " " + second + " " + third + "\n" + fourth
// + " " + fifth + " " + sixth
// + "\n" + seventh + " " + eighth + " " + o);
// }
// }
// }
