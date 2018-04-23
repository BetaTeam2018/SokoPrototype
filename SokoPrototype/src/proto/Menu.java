package proto;

import java.util.ArrayList;

public class Menu {
	
	private static void printTheSubtitle() {
		System.out.println(" ========= Prototípus tesztelés by beta =========\n");
		System.out.println("Adja meg a tesztelni kívánt eset sorszámát!\n");
	}
	
	public static void printMenuList() {
		
		printTheSubtitle();
		
		ArrayList<String> menuList = new ArrayList<>();
		menuList.add(" *Kilépés*\n");
		menuList.add("A játékos ládákat tol teszt");	                              // 1.
		menuList.add("Maradj talpon teszt");										  // 2. kapcsolók és csapóajtók tesztjei
		menuList.add("A játékos súrlódás miatt meghal");							  // 3.
		menuList.add("A játékos ládát tol egy célhelyre, majd letolja róla a ládát"); // 4.
		menuList.add("A játékos ládát tol egy sima mezőre majd egy mézesre");		  // 5.
		menuList.add("A játékos minden irányba lépked");							  // 6.
		menuList.add("A játékos lyukba esik");										  // 7.
		
		int i = 0;
		for (String str : menuList) {
			System.out.println(i++ + ". "+ str);
		}
		
		System.out.println(" ================================================\n");
		
	}
}
