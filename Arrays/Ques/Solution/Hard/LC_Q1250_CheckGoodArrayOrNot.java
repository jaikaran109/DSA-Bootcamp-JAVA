class Solution {
    public boolean isGoodArray(int[] nums) {

        int factor = 0;

        for(int num : nums){
            factor = gcd(factor,num);
            if(factor == 1) return true;     // ek baar 2 number ka GCD 1 mil gya to agr tm sare elements ka GCD nikaloge to bhii 1 aayega 
        }
        return false;
    }

    private int gcd(int a, int b) {
    if (b == 0) return a;       // 0 ka GCD kisi number x ke saath krne pe x hi aayega 
    return gcd(b, a % b);
    }
}
