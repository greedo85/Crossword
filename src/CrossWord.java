import java.util.Scanner;

public class CrossWord {
    Scanner scanner = new Scanner(System.in);
    char[][] array;
    char[][] userArray;
    int passwordChoice;

    public CrossWord( int sizeRow, int sizeColumn ) {
        array = new char[sizeRow][sizeColumn];
        userArray = new char[sizeRow][sizeColumn];
    }

    public void setCrossword() {
        array[0][1] = 'w';
        array[1][1] = 'o';
        array[2][1] = 'l';
        array[3][1] = 'o';
        array[4][1] = 'w';
        array[5][1] = 'e';

        array[1][0] = 'p';
        array[1][2] = 'r';

        array[3][0] = 'l';
        array[3][2] = 's';
    }

    public void playCrossword() {
        do {
            System.out.println("1: 2 Pionowo: miêso na tatara");
            System.out.println("2: 2 Poziomo: d³uga roœlina warzywna");
            System.out.println("3: 4 Poziomo: koleje ludzkiego ¿ycia");
            System.out.println("Wpisz numer has³a: ");
            passwordChoice = scanner.nextInt();
            switch (passwordChoice) {
                case 1:
                    typeAnswer(0, 1);
                    printCrossword(userArray);
                    checkPassword(0, 1);
                    break;

                case 2:
                    typeAnswer(1, 0);
                    printCrossword(userArray);
                    checkPassword(1, 0);
                    break;
                case 3:
                    typeAnswer(3, 0);
                    printCrossword(userArray);
                    checkPassword(3, 0);
                    break;
            }
        }
        while (!checkCrossword());
    }

    private void typeAnswer( int numberRow, int numberColumn ) {
        char type;
        int i = numberRow;
        int j = numberColumn;
        if (passwordChoice == 1) {
            for (i = 0; i < array.length; i++) {
                type = scanner.next().charAt(0);
                userArray[i][j] = type;
            }
        } else if (passwordChoice == 2 || passwordChoice == 3) {
            for (j = 0; j < array[i].length; j++) {
                type = scanner.next().charAt(0);
                userArray[i][j] = type;
            }
        }
    }

    public boolean checkPassword( int numberRow, int numberColumn ) {
        int i = numberRow;
        int j = numberColumn;
        int falseCounter = 0;
        if (passwordChoice == 1) {
            for (i = 0; i < array.length; i++) {
                if (array[i][j] != userArray[i][j]) {
                    falseCounter++;
                }
            }
        } else if (passwordChoice == 2 || passwordChoice == 3) {
            for (j = 0; j < array[i].length; j++) {
                if (array[i][j] != userArray[i][j]) {
                    falseCounter++;
                }
            }
        }
        if (falseCounter <= 0) {
            System.out.println("Prawid³owe has³o, podaj nastêpne: ");
            return true;
        } else if (falseCounter > 0) {
            System.out.println("Has³o nieprawid³owe");
            return false;
        }
        return true;
    }

    public void printCrossword( char someArray[][] ) {
        System.out.println("      2  ");
        for (int i = 0; i < someArray.length; i++) {
            if(i==1||i==3) {
                System.out.print((i + 1) + " ");
            }
            else {
                System.out.print("  ");
            }
            for (int j = 0; j < someArray[i].length; j++) {
                System.out.print("[" + someArray[i][j] + "]");
            }
            System.out.println(" ");
        }
    }

    public boolean checkCrossword() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != userArray[i][j]) {
                    return false;
                }
            }
        }
        System.out.println("Rozwi¹zana poprawnie");
        return true;
    }
}
