import java.util.Scanner;


public class Driver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int rows = 0;
		int columns = 0;
		System.out.println("Enter the number of Rows: ");
		rows = in.nextInt();
		System.out.println("Enter the number of columns: ");
		columns = in.nextInt();
		
		int [][]matrix = new int[rows][columns];
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				System.out.println("Enter next value: ");
				matrix[i][j] = in.nextInt();
			}
		}
		
		System.out.println("The following is the matrix: ");
		showMatrix(matrix);
		System.out.println();
		
		System.out.print("The Determinant is ");
		System.out.print(getDeterminant(matrix));
	}
	
	static double getDeterminant(int [][]m){
	
		double determinant = 0;
		int minors[][][] = new int[m.length][m.length-1][m.length-1];
		
		if(m.length > 2){
			for(int i=0; i<m.length; i++){
				int a = 0;
				int b = 0;
				for(int ii=0; ii<=m.length-1; ii++){
					for(int jj=0; jj<=m.length-1; jj++){
						if(ii != 0 && jj != i){
							if(a < minors[0].length && b < minors[0][0].length){
								minors[i][a][b] = m[ii][jj];
								b++;
							}
						}
					}
					if(b >= minors[0][0].length){
						b = 0;
						a++;
					}
				}
				determinant += m[0][i] * getDeterminant(minors[i]) * Math.pow(-1, i);
			}
		}
		else if(m.length == 2){
			determinant = m[0][0] * m[1][1] - m[1][0] * m[0][1];
		}
		return determinant;
	}
	
	
	static void showMatrix(int [][]m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}
