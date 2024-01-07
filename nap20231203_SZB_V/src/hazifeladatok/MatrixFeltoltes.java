package hazifeladatok;

import java.util.Random;

public class MatrixFeltoltes {
	
	public static Random r = new Random();
	
	public static void main(String[] args) {
		
		int[][] matrixTomb = new int[4][3];
		
		matrixFeltoltes(matrixTomb);
		kilistaz(matrixTomb);
		System.out.println();
		int[][] transzponaltMatrix = transzponaltMatrix(matrixTomb);
		kilistaz(transzponaltMatrix);
	}

	private static int[][] transzponaltMatrix(int[][] matrixTomb) {
		int[][] transzponaltMatrix = new int[4][3];

		for(int i=0; i<transzponaltMatrix.length; i++) {
			for(int j=0; j<transzponaltMatrix[i].length; j++) {
				
				 transzponaltMatrix[i][j] = matrixTomb[i][j];
				
			}
		}
		return transzponaltMatrix;
		
		
	}

	private static void kilistaz(int[][] matrixTomb) {
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
				
				matrixTomb[i][j] = r.nextInt(50,101); // random.nextInt(51) + 50 -> ez egy másik kiíratási módszer
				
			}
			
		}
		
	}
	
	
	
	

}
