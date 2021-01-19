/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jianfeng
 */
public class UpperTriangularMatrix {
    private int n;
    private int[] array;
    
    public UpperTriangularMatrix(int n){
        
    	if(n <= 0) {
    		
    		this.n = 1;
    		
    	}
    	
    	else {
    		
    		this.n = n;
    		
    	}
    	
    	this.array = new int[(this.n*(this.n+1))/2]; //Use formula given in question to initialize array.
    	
        
    }
    
    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        
    	int i;
    	int j;
    	int index = 0;
    	int rows = upTriM.getsizeofrows(); //Get row and col numbers
    	int cols = upTriM.getsizeofcols();
    	this.n = rows; //Initialize n
    	
    	this.array = new int[(this.n*(this.n+1))/2]; //Initialize array
    	
    	if (upTriM.isUpperTr()) { //Run only if this returns true, meaning upTriM is upper triangular.
    		
    		for(i = 0; i < rows; i++) {
    			
    			for(j = 0; j < cols; j++) { 
    				
    				if(i <= j) { //Every element on the diagonal and above, will have this property where i is <= j.
    					
	    				this.array[index] = upTriM.getElement(i,j); //Only add the element if it is on or above the diagonal.
	    				index += 1; //Increase the index for the next element.
    				
    				}
    			}
    		}
    	}
    	
    	else {	
    		
    		throw new IllegalArgumentException("Not an upper triangular Matrix");
    		
    	}
        
    }    
        
    public int getDim(){
        
		
		/* write your implementation here and update return accordingly */
        return this.n; 
    }
    
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
		
		
 		/* write your implementation here and update return accordingly */
    	
    	if(i < 0 || n <= i || j < 0 || n <= j) { //First check if indexes are within range.
    		
    		throw new IndexOutOfBoundsException("Invalid indexes");
    		
    	}
    	
    	else {
    		
	    	if(i <= j) { //First check that the value is on or above the diagonal.
	    		
	    		int index = n*(n-1)/2 - ((n-i)*(n-i-1)/2) + j; //This takes in the i and j values and finds the corresponding index in array.
	    		
	    		return this.array[index]; //Use the index found and return from array.
	  
	    	}
	    	
	    	else {
	    		
	    		return 0; //If the value is below the diagonal it means it is 0, so just return 0.
	    		
	    	}
    	}
    	   	
    }
    
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException,IllegalArgumentException{
       
    	if(i < 0 || n <= i || j < 0 || n <= j) { //Check for valid index.
    		
    		throw new IndexOutOfBoundsException("Invalid indexes");
    		
    	}
        
        if(i > j && x != 0) { //Check that x is not 0, and i > j.
        	
        	throw new IllegalArgumentException("Incorrect argument");
        	
        }
    	
        else {
        	
        	int index = n*(n-1)/2 - ((n-i)*(n-i-1)/2) + j; //Use same formula to get the index in the array given i and j.
        	this.array[index] = x; //Assign x to the associated index.
        	
        }
        
    }
    
    public Matrix fullMatrix(){

        Matrix full= new Matrix(n,n); //Initialize the new matrix.
        
        int i;
        int j;
        int index = 0;
        
        for(i = 0; i < n; i++) {
        	
        	for(j = 0; j < n; j++) {
        		
        		if(i <= j) { //Check that the value is on or above the diagonal.
        			
        			full.setElement(this.array[index], i, j); //Call the set element method to place the value in the right spot.
        			index += 1;
        		}
        		
        	}
        	
        }
        
		
        return full; 
    }
    
   
      
    public String toString(){

       String output = new String(); 
		
		int i;
		int j;
		int b;
		
		for(i = 0; i < this.n; i++) {
			
			for(j = 0; j < this.n-i; j++) { //Run n-i times, so that on each iteration, it will run for one less time. This works since there are
											//a reducing number of non-zero values on each row. 3 --> 2 --> 1.
				output += this.array[(i*3)+j] + " "; //The formula ensures that we add the correct index and do not got over or below.
							
			}
			
			output += "\n";
			for(b = 0; b < i; b++) { //When the above loop breaks, it means it has finished a row. So here we add the newline, then add the 
				output += "0" + " "; //required number of zeroes, according to what row we are currently on.
			}
			
		}
       	
		return output;
    }
   
    
    public int getDet(){
        
    	int i;
    	int det = 1; //Initialize to 1 so we don't get zero multiplication.
    	
    	for(i = 0; i < n; i++) { //Iterate through the diagonals of the array, which is just the row or col number.
    		
    		int index = n*(n-1)/2 - ((n-i)*(n-i-1)/2) + i; //Assign the index of the diagonal value on each row to the index variable.
    		det *= this.array[index]; //Multiply the diagonal number into the determinant.
    		
    	}
        
       return det; 
    }

    
    public double[] effSolve(double[] b) throws IllegalArgumentException{

        /* fix the following and write your implementation */
    	double[] sol = new double[10];

       
        return sol;  
    }   
}