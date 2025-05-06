package Math;

class rotateMatrix{
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            
            //Swap non-diagonal elements.
            for(int row=0; row<n;row++){
                for(int col=row; col<n;col++){
                    if(row != col){
                        int temp = matrix[row][col];
                        matrix[row][col] = matrix[col][row];
                        matrix[col][row] = temp;
                    }
                }
            }
    
            // printMatrix(matrix);
    
            //Reverse each row
    
            for(int row=0; row<n;row++){
                int left = 0;
                int right = n-1;
    
                while(left<right){
                    int temp = matrix[row][left];
                    matrix[row][left++] = matrix[row][right];
                    matrix[row][right--] = temp;
                }
            }
        }
    
        // private void printMatrix(int[][] matrix){
        //     int n = matrix.length;
        //     for(int i=0; i<n;i++){
        //         for(int j=0; j<n;j++){
        //             System.out.print(matrix[i][j]+" ");
        //         }
    
        //         System.out.println();
        //     }
        // }
}
