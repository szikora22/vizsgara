package matrixok;

public class MatrixFeltoltes {
	
	public static void main(String[] args) {
		
		int[][] ketdimenziosTomb = new int[5][3];
		
		int sorszam = 0;
		
		for(int i=0; i<ketdimenziosTomb.length; i++) {
			
			for(int j=0; j<ketdimenziosTomb[i].length;j++) {
				
				//ketdimenziosTomb[i][j] = sorszam; -> ebben az esetben szükséges segédváltozó
				ketdimenziosTomb[i][j] = (i*ketdimenziosTomb[i].length+j+1);
				sorszam++;
				
				/*
				 * a ciklusváltozókból is kiszámolható sorszámozás:
				 * ahány soron túl vagyunk (i), annyiszor az oszlopok száma
				 * plusz az aktuális sor aktuális oszlopszáma (j+1)
				ketdimenziosTomb[i][j] = (i*ketdimenziosTomb[i].length+j+1);
				*/
				
			}
						
		}
		
		System.out.println("Kilistázás elsőtől utolsóig:");
		
		for(int i=0; i<ketdimenziosTomb.length; i++) {
			
			for(int j=0; j<ketdimenziosTomb[i].length; j++) {
				
				System.out.print(ketdimenziosTomb[i][j] + " ");
				
			}
			
		}
		
		//  a fenti egymásba ágyazott for ciklus foreach szerkezettel is megvalósítható:
		
			/*for (int[] elem:ketdimenziosTomb) {
				
				for (int elem2:elem) {
					
					System.out.print(elem2+" ");
				}
				System.out.println();
			} */
		
		System.out.println();
		System.out.println("Kilistázás utolsótól elsőig:");
		
		for(int i=ketdimenziosTomb.length-1;i>=0;i--) {
			
			for(int j=ketdimenziosTomb[i].length-1; j>=0; j--) {
				
				System.out.print(ketdimenziosTomb[i][j] + " ");
				
			}
			
		}
		
	}
	
	
	

}
