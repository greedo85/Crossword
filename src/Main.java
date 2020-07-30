import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    Random random = new Random();
    int liczba1;
    int liczba2;
    int liczba3;
    int randomNumber;
    char menuChoice;
    Scanner scanner = new Scanner(System.in);
    CrossWord crossWord=new CrossWord(6,3);
    public static void main( String[] args ) {
        System.out.println("Wylosuj zadanie: 1, 2, 3");
        Main main=new Main();
        main.menu();
    }

    public void menu() {
        crossWord.setCrossword();
        do {
            System.out.println("Naciœnij 'q' aby wyjœæ lub 'd' aby losowaæ dalej:");
            menuChoice = scanner.next().charAt(0);
            switch (menuChoice) {
                case 'd':
                    setRandomTask();
                    break;
                case 'q':
                    System.exit(0);
            }
        }
            while((!(menuChoice != 'q') || (menuChoice =='d')));
    }
    public void setRandomTask()
    {
        randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                crossWord.playCrossword();
                break;
            case 1:
            howManyPrimeNumber();
                break;
            case 2:
                inputPrimeNumbers();
                break;
        }
    }

    /*-----------------------------------------------------------------------------------------------------*/
    public boolean inputPrimeNumbers() {
        try {
            System.out.println("Wpisz 3 liczby pierwsze:");
            liczba1 = scanner.nextInt();
            liczba2 = scanner.nextInt();
            liczba3 = scanner.nextInt();
            System.out.println("poda³eœ: " + liczba1 + " " + liczba2 + " " + liczba3);
            if (!(isNumberPrime(liczba1)) || !(isNumberPrime(liczba2)) || !isNumberPrime(liczba3)) {
                System.out.println("Poda³eœ z³e liczbny");
                return false;
            } else {
                System.out.println("Wygra³eœ, poda³eœ: " + liczba1 + " " + liczba2 + " " + liczba3);
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Nieprawid³owa liczba, spróbuj jeszcze raz");
        }
        return true;
    }

    public boolean howManyPrimeNumber() {
        System.out.println("Podaj ile jest liczb pierwszych:");
        int min = 0;
        int max = 10;
        int counter = 0;
        for (int i = 1; i <= 10; i++) {
            int liczba = random.nextInt((max - min + 1) + 1 + min);
            if (isNumberPrime(liczba)) {
                counter += 1;
            }
            System.out.print(liczba+", ");
        }
        System.out.println("Licznik: " + counter);
        int userChoice = scanner.nextInt();
        if (userChoice == counter) {
            System.out.println("Wygra³eœ");
            return true;
        } else {
            System.out.println("Spróbuj jeszcze raz");
            howManyPrimeNumber();
            return false;
        }
    }


    public boolean isNumberPrime(int liczba) {
        boolean check = true;
        if (liczba <= 1) {
            check = false;
            return check;
        } else {
            for (int i = 2; i <= liczba / 2; i++) {
                if ((liczba % i) == 0) {
                    check = false;
                    break;
                }
            }
            return check;
        }
    }
}
