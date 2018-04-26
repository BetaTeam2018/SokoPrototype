package proto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = null;
   
    private static void printTheSubtitle() {
        System.out.println("========= Prototípus tesztelés by beta =========");
        //System.out.println("Adja meg a tesztelni kívánt eset sorszámát!\n");
    }
    public static void printMainMenuList() {
    	printTheSubtitle();
    	System.out.println("===============================================");
    	System.out.println("                    Főmenü                     ");
    	System.out.println("===============================================");
        ArrayList < String > mainMenuList = new ArrayList < > ();
        mainMenuList.add(" *Kilépés*");
        mainMenuList.add("Tesztek"); 
        mainMenuList.add("Parancssor\n"); 
        int i = 0;
        for (String str: mainMenuList) {
            System.out.println(i++ + ". " + str);
        }
    }
    public static void printTestMenuList() {
        ArrayList < String > menuList = new ArrayList < > ();
      
        System.out.println("===============================================");
    	System.out.println("             Tesztek futtatása                 ");
    	System.out.println("===============================================");
      
    	menuList.add(" *Vissza*");
        menuList.add("A játékos ládákat tol teszt"); // 1.
        menuList.add("Maradj talpon teszt"); // 2. kapcsolók és csapóajtók tesztjei
        menuList.add("A játékos súrlódás miatt meghal"); // 3.
        menuList.add("A játékos ládát tol egy célhelyre, majd letolja róla a ládát"); // 4.
        menuList.add("A játékos ládát tol egy sima mezőre majd egy mézesre"); // 5.
        menuList.add("A játékos minden irányba lépked"); // 6.
        menuList.add("A játékos lyukba esik\n"); // 7.

        int i = 0;
        for (String str: menuList) {
            System.out.println(i++ + ". " + str);
        }
    }

    public static Integer readListNumber() {

        Scanner scanner = new Scanner(System.in);
        Integer ret = 0;

        try {
            System.out.print("Sorszám: ");
                ret = scanner.nextInt();
               
            return ret;
        } finally {
            if (scanner != null);
        }
    }

}