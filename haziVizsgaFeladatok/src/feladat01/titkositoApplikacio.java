package feladat01;

import java.util.Scanner;

public class titkositoApplikacio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kérem adja meg a titkosítani kívánt szöveget: ");
        String szoveg = sc.nextLine();

        String titkositottSzoveg = titkosit(szoveg);
        System.out.println("A titkosítás eredménye: " + titkositottSzoveg);

        String dekodoltSzoveg = dekodolas(titkositottSzoveg);
        System.out.println("A dekódolás eredménye: " + dekodoltSzoveg);
        sc.close();
    }

    public static String titkosit(String titkositando) {
        String mitKellCserelni = "aetsk ";
        String mireKellCserelni = "123456";
        String eredmeny = titkositando;

        for (int i = 0; i < mitKellCserelni.length(); i++) {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

        if (eredmeny.length() > 1) {
            eredmeny = eredmeny.substring(1) + eredmeny.charAt(0);
        }

        return eredmeny;
    }

    public static String dekodolas(String dekodolando) {
        String mitKellCserelni = "123456";
        String mireKellCserelni = "aetsk ";
        String eredmeny = dekodolando;

        for (int i = 0; i < mitKellCserelni.length(); i++) {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

        if (eredmeny.length() > 1) {
            eredmeny = eredmeny.substring(eredmeny.length() - 1) + eredmeny.substring(0, eredmeny.length() - 1);
        }

        return eredmeny;
    }
}