// GFF

import java.util.*;
public class firstUpperCase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        char found = helper(str,0);
        System.out.println(found);
    }
    static char helper(String str , int idx){
        if(idx == str.length()){
            return '0';
        }
        if(str.charAt(idx)>= 'A' && str.charAt(idx) <= 'Z') return str.charAt(idx);

        return helper(str,idx+1);
    }

}
