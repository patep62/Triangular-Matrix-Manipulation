/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jianfeng
 */
public class Matrix {
	
    
	private int[][]  matrixData;
	private int    rowsNum;	
	private int    colsNum;	
	
	public Matrix( int row, int col ) 
	{   
		if(row <= 0) { //Check if the input meets the requirements and then assign the input to its variable.
			this.rowsNum = 3;
		}
		
		else {
			this.rowsNum = row;
			
		}
		
		if(col <= 0) {
			this.colsNum = 3;
			
		}
			
		else {
			this.colsNum = col;
			
		}
		
		
		int[][] m = new int[this.rowsNum][this.colsNum]; //Since we already assigned rowsNum and colsNum, all we have to do is make the matrix.
		this.matrixData = m;
		
		
	}

	public Matrix( int[][] table) 
	{	
		rowsNum = table.length;
		colsNum = table[0].length;
		matrixData = new int[rowsNum][colsNum];
		
		int i;
		int a;
		
		for(i = 0; i < rowsNum; i++) { //Iterate through each row of the matrix.
			
			for(a = 0; a < colsNum; a++) { //Iterate through each column of the matrix, effectively iterating through every entry in the matrix.
				
				matrixData[i][a] = table[i][a];
				
			}			
		}
	}
	
	public int getElement(int i, int j) throws IndexOutOfBoundsException
	{ 	
		
    	if(i < this.rowsNum && j < this.colsNum && i >= 0 && j >= 0) { //Check to make sure i and j are within the boundaries of the matrix.
			
			return this.matrixData[i][j];
			
		}
		
		else {
			
			throw new IndexOutOfBoundsException("Invalid indexes."); //Throw error if input does not pass test.
		}
	}
        
    public boolean setElement(int x, int i, int j){ 
            
    	
    	if(i < this.rowsNum && j < this.colsNum && i >= 0 && j >= 0) {
    		this.matrixData[i][j] = x;
    		return true;
    	}
    	
    	else {
    		return false;
    	}
    } 

    public Matrix copy(){ 
        
    	/* fix the code and write your implementation below */
		Matrix copy = new Matrix(rowsNum, colsNum); //Initialize the matrix with correct row and column numbers.
		
		int i;
		int a;
		
		for(i = 0; i < this.rowsNum; i++) {
			for(a = 0; a < this.colsNum; a++) { //Iterate through every entry in the matrix, copying each on to new matrix.
				
				copy.matrixData[i][a] = this.matrixData[i][a];
				
			}
		}
		
        return  copy; 
    }    
                
	public void addTo( Matrix m ) throws ArithmeticException
	{
		
		/* the detail message of the exception should read: "Invalid operation". */
		
		int i;
		int a;
		
		if(m.rowsNum == this.rowsNum && m.colsNum == this.colsNum) { //Check to make sure both matrixes are the same length.
			
			for(i = 0; i < this.rowsNum; i++) {
				
				for(a = 0; a < this.colsNum; a++) {
					
					this.matrixData[i][a] += m.matrixData[i][a];
					
				}
				
			}
			
		}
	
		else {
			
			throw new ArithmeticException("Invalid operation");
			
		}
	
	}
	
    public Matrix subMatrix(int i, int j) throws ArithmeticException{ 
        
		/* The exception detail message should read: "Submatrix not defined"*/
    	
    	/* fix the code and write your implementation below */
    	
		Matrix subM = new Matrix (i+1,j+1); //Create the required matrix, adding one to rows and columns to create sufficient space.
		
		int a;
		int b;
		
		if(i < this.rowsNum && j < this.colsNum && i > 0 && j > 0) { //Check to make sure the submatrix fits within the matrix.
			
			for(a = 0; a <= i; a++) {
				
				for(b = 0; b <= j; b++) { //Iterate through every subMatrix entry copying each value to the new matrix.
					
					subM.matrixData[a][b] = this.matrixData[a][b];
				}
				
			}
			
		}
		
		else {
			
			throw new ArithmeticException("Submatrix not defined");
			
		}
		
        return  subM; 
        
    }
        
    public int getsizeofrows(){ 
           
		/* update below return */
    	
		return this.rowsNum;
    }
        
    public int getsizeofcols(){
		
		/* update below return */
        return this.colsNum; 
    }
        
    public boolean isUpperTr(){
            
		/* write your implementation here and update return accordingly */
    	
    	int i;
    	int j;
    	
    	for(j = 0; j < this.colsNum; j ++) { //Start by going through each row.
    		
    		for(i = 0; i < this.rowsNum; i++) { //Then go through each column in the current row.
    			
    			if(j - i < 0) { //If the current index is below the diagonal, this operation should always yield a negative number.
    				
    				if(this.matrixData[i][j] != 0) { //Therefore, if the above operation passes, then the current index is a number below the diagonal.

    					return false; //Check to see if the number below the diagonal is non-zero. If it is, return false right away.
    					
    				}
    				
    			}
    			
    		}
    		
    	}
    	
        return true;  //If we get to this point, it means that the matrix passed all the tests, and true should be passed.
	}
        
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
            
        
    	//Use above commands to get the row and column numbers of the first matrix in the array, since all the matrixes have to be of equal length.
        Matrix superMatrix = new Matrix (matArray[0].getsizeofrows(), matArray[0].getsizeofcols()); //Initialize the size of the super matrix.
        
        

        int i;
        
        for(i = 0; i < matArray.length; i++) { //Iterate through each matrix in the list, adding each one to super matrix using addTo method.
        	
        	superMatrix.addTo(matArray[i]);
            
        }
            
        return superMatrix; 
    }
        
	public String toString(  )
	{
		String output = new String(); 
		
		int i;
		int a;
		
		for(i = 0; i < this.rowsNum; i++) {
			
			for(a = 0; a < this.colsNum; a++) { //Iterate through every entry in the matrix.
				
				output += this.matrixData[i][a] + " "; //Adding an integer to a string automatically converts it to a string.
				
			}
			
			output+= "\n"; //After we have iterated through every column in the row, add a newline before moving on to the next row.
		}
        	
		return output;
	}
    
}