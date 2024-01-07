package hazifeladatok;

import java.util.Random;

public class MatrixRandomNegyzet {
	
	public static Random r = new Random();

	public static void main(String[] args) {

		int[][] matrixTomb = new int[3][3];
		
		matrixFeltoltes(matrixTomb);
		kilistaz(matrixTomb);
		System.out.println();
		forditva(matrixTomb);
		
	}

	private static void forditva(int[][] matrixTomb) {
		System.out.println("Fordított sorrend: ");
		   for(int i=matrixTomb.length-1; i>=0; i--) {
				
				for(int j=matrixTomb[i].length-1; j>=0; j--) {
					
					System.out.print(matrixTomb[i][j] + "\t");
				}
				System.out.println();
			}
		
	}

	private static void kilistaz(int[][] matrixTomb) {

	   System.out.println("Eredeti sorrend: ");
	   for(int i=0; i<matrixTomb.length; i++) {
			
			for(int j=0; j<matrixTomb[i].length; j++) {
				
				System.out.print(matrixTomb[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}

	private static void matrixFeltoltes(int[][] matrixTomb) {

		for(int i=0; i<matrixTomb.length; i++) {
			
			for(int j=0; j<matrixTomb[i].length; j++) {
				
				int egyjegyuVeletlen = r.nextInt(1,10); // r.nextInt(9) + 1;
				matrixTomb[i][j] = egyjegyuVeletlen*egyjegyuVeletlen;
			}
			
		}
		
		
	}

}
