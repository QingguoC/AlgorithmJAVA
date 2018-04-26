package org.qingguo;

public class RepeatedStringMatch686 {

    public int repeatedStringMatch(String A, String B){
        int res = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < B.length()){

            sb.append(A);
            res++;
        }
        if (sb.toString().contains(B)) {
            return res;
        }
        sb.append(A);
        if (sb.toString().contains(B)){
            return res + 1;
        }
        return -1;
    }
}
