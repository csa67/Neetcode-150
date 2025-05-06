package Math;

public class multiplyStrings {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
    
            int n = num1.length();
            int m = num2.length();
            int[] res = new int[n +m];
    
            for (int i=n-1; i>=0; i--) {
                int d1 = num1.charAt(i) - '0';
                for (int j=m-1; j>=0; j--) {
                    int d2 = num2.charAt(j) -'0';
    
                    int mult = d1 * d2;
                    int sum = res[i+j+1] + mult;
                    
                    res[i+j+1] = sum%10;
                    res[i+j] += sum /10;
                }
            }
    
            StringBuilder sb = new StringBuilder();
            for (int digit: res) {
                if (sb.length() ==0 && digit == 0) {
                    continue;
                }
                sb.append(digit);
            }
    
            return sb.toString();
        }
}
