import java.util.Scanner;

public class CrossWord
{
    Scanner scanner = new Scanner(System.in);
    char array[][];
    char [][] userArray;
    public CrossWord( int sizeRow, int sizeColumn)
    {
        array=new char[sizeRow][sizeColumn];
        userArray=new char[sizeRow][sizeColumn];
    }
    public void setCrossword()
    {
        array[0][1]='w';
        array[1][1]='o';
        array[2][1]='³';
        array[3][1]='o';
        array[4][1]='w';
        array[5][1]='e';

        array[1][0]='p';
        array[1][2]='r';

        array[3][0]='l';
        array[3][2]='s';

        for (int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[i].length;j++)
            {
                if(array[i][j]==0)
                {
                    array[i][j]='_';
                }
            }
        }
    }
    public void playCrossword()
    {
        System.out.println("1: 2 Pionowo: miêso na tatara");
        System.out.println("2: 2 Poziomo: d³uga roœlina warzywna");
        System.out.println("3: 4 Poziomo: koleje ludzkiego ¿ycia");
        char type;
        int choice=scanner.nextInt();
        switch (choice)
        {
            case 1:
                typeAnswer(0,1);
                printCrossword(userArray);
                checkCrossword(userArray);
                break;
            case 2:

        }
    }
    public boolean checkCrossword(char userArray[][])
    {
        for (int i=0;i<array.length;i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][1] != userArray[i][1]) {
                    return false;
                }
            }
        }
        if(checkCrossword(userArray))
        {
            System.out.println("Prawid³owe has³o, podaj nastêpne: ");
            playCrossword();
        }
        else
        {
            System.out.println("Has³o nieprawid³owe");
        }
        return true;
    }
    public void printCrossword(char[][]userArray)
    {
        System.out.println("    1  2  3");
        for(int i=0;i<userArray.length;i++)
        {
            System.out.print((i+1)+" ");
            for(int j=0;j<userArray[i].length;j++)
            {
                System.out.print("[" + userArray[i][j] + "]");
            }
            System.out.println(" ");
        }
    }
    private void typeAnswer( int numberRow, int numberColumn ) {
    char type;
    for (numberRow = 0; numberRow<array.length; numberRow++)
    {
        if(array[numberRow][numberColumn]!='_') {
            type = scanner.next().charAt(0);
            userArray[numberRow][numberColumn] = type;
        }
    }


}
}
