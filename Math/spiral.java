package Math;

import java.util.ArrayList;
import java.util.List;

public class spiral {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up=0,left=0,right=n-1,down=m-1;

        //right, down, left, right
        while(result.size() < m*n){
            for(int col = left;col<=right;col++){
                result.add(matrix[up][col]);
            }

            for(int row=up+1;row<=down;row++){
                result.add(matrix[row][right]);
            }

            if(up!=down){
                for(int col = right-1;col>=left;col--){
                    result.add(matrix[down][col]);
                }
            }

            if(left!=right){
                for(int row=down-1;row>up;row--){
                    result.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            up++;
            down--;
        }

        return result;

    }
}
