import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main {
    static char[][] fieldGame = new char[3][3];
    static char player = 'X';
    public static void main(String[] args) {
        boolean isWinner = false;

        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                fieldGame[i][j] = '.';
            }
        }

        while (isWinner != true){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
           int row = 0;
           int col = 0;

            try {
                System.out.println("Введите число: ");
                row = Integer.parseInt(reader.readLine());
                System.out.println("Введите число: ");
                col = Integer.parseInt(reader.readLine());


                if (checkPos(row, col)){
                    fieldGame[row-1][col-1] = player;
                    if (checkWinner()){
                        System.out.println("Победа - " + player);
                        isWinner = true;
                    }
                    swapPlayer();
                }else{
                    System.out.println("Эта ячейка занята!");
                }

                outputField();
            } catch (IOException e) {
                System.out.println("Введите корректное значение!");
            } catch (ArrayIndexOutOfBoundsException er){
                System.out.println("Введите корректное значение!");
            }
        }

        System.out.println("Игра окончена!");
    }

    public static void outputField(){
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame.length; j++) {
                System.out.print(fieldGame[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean checkPos(int row, int col){

        if (fieldGame[row-1][col-1] == '.'){
            return true;
        }else {
            return false;
        }
    }

    public static boolean checkWinner(){
        for (int i = 0; i < fieldGame.length; i++) {
            int count = 0;
            for (int j = 0; j < fieldGame.length; j++) {
                if (fieldGame[i][j] == player){
                    count += 1;
                }
            }

            if (count == 3){
                return true;
            }
        }

        return false;
    }

    public static void swapPlayer(){

        if (player == 'X') {
            player = 'O';
        }else{
            player = 'X';
        }

    }

}
