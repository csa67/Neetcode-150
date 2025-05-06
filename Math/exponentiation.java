package Math;

public class exponentiation {
        public double myPow(double x, int n) {
            long N = (long) n;
            if(N==0){
                //anything pow 0 --> 1
                return 1;
            }
    
            if(N < 0){
                //neg pow --> 1/ x^(pos)
                N = -1 * N;
                x = 1.0/ x;
            }
    
            double res = 1;
    
            while(N!=0){
                if(N%2 != 0){
                    //reduce pow by 1, as x^n = x^n-1 * x.
                    res = res*x;
                    N-=1;
                }else{
                    x = x*x;
                    N = N/2;
                }
            }
    
            return res;
        }
}
