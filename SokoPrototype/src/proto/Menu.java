package proto;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * a menü kirajzolásáért felelős osztály
 *
 */
public class Menu {

	/**
	 * Scanner amivel a bementről olvasunk
	 */
    static Scanner scanner = null;
   
    
    /**
     * kirajzolja a menüt 
     */
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

    /**
     * beolvassa hogy a felhasználó melyik menüpontot válaszotta
     * @return a kiválaszott menüpont sorszáma
     */
    public static Integer readListNumber() {

        Scanner scanner = new Scanner(System.in);
        Integer ret = 0;

            System.out.print("Sorszám: ");
                ret = scanner.nextInt();	//menüpont számának beolvasása
               
            return ret;
    }

}