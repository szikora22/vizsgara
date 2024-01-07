package listInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList {

	public static void main(String[] args) {

		List<Integer> szamok = new ArrayList<Integer>();
		szamok.add(52);	szamok.add(2); szamok.add(19); szamok.add(35);
		
		System.out.println(szamok);
		
		List<Integer> szamok2 = new ArrayList<Integer>() {
			
			{
				
				add(40); add(8); add(10);
				
			}
						
		};
		
		System.out.println(szamok2);
		
		List<Integer> szamok3 = new ArrayList<Integer>(Arrays.asList(11,76,4));
		System.out.println(szamok3);
		
		Integer[] tomb = {16,61,25};
		List<Integer> szamok4 = new ArrayList<Integer>(Arrays.asList(tomb));
		System.out.println(szamok4);
		
		Integer[] tomb2 = szamok.toArray(new Integer[szamok.size()]);
		
		System.out.println();
		System.out.println(szamok);
		szamok.add(2,9);
		System.out.println(szamok);
		
		System.out.println(szamok.get(3));
		
		System.out.println(szamok.indexOf(35)); // első előfordulás
		System.out.println(szamok.lastIndexOf(35)); // utolsó előfordulás
		System.out.println(szamok.contains(35));
		
		List<Integer> szamokReszlistaja = new ArrayList<Integer>();
		szamokReszlistaja = szamok.subList(1, 4); // részlista képzés, from index benne van, toIndex már nincs benne
		System.out.println(szamokReszlistaja);
		
		szamok.remove(0);
		System.out.println(szamok);
		// System.out.println(szamokReszlistaja); // ha a részlista alapját képző lista szerkezete változik, a részlista hivatkozás kivételt dob 
		
		System.out.println(szamok.size());
		
		for(int i=0; i<szamok.size(); i++) {
			
			System.out.print(szamok.get(i) + " ");
			
		}
		System.out.println();
		System.out.println();
		// Linkedlist --> több memóriát igényel mint ArrayList
		// viszont beszúrás és törlés gyorsabb
		// akkor érdemes használni, ha sok beszúrás/törlés várható az adatszerkezet használatakor
		
		LinkedList<Integer> szamokLL = new LinkedList<Integer>();
		
		szamokLL.add(50);
		szamokLL.addFirst(7);
		szamokLL.addLast(17);
		szamokLL.add(70);
				
		System.out.println(szamokLL);
		
		szamokLL.push(19);
		System.out.println(szamokLL);
		
		szamokLL.pop();
		System.out.println(szamokLL);
		
		szamokLL.remove();
		szamokLL.removeFirst();
		System.out.println(szamokLL);
		
		// szamokLL.remove(17); // hiba, mert 17-es index nincs. Objektumként hivatkozhatjuk, Integerbe kasztolva:
		szamokLL.remove((Integer)17);
		System.out.println(szamokLL);

	}

}
