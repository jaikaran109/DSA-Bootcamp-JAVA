class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        boolean[] present = new boolean[26];
        int count = 0;
        for(char ch : sentence.toCharArray()){
            int index = ch - 'a';

            if(!present[index]) {
                present[index] = true;
                count++;
            }

            if(count == 26) return true;

        }

        return false;
        
    }
}


// class Solution {
//     public boolean checkIfPangram(String sentence) {
//         if(sentence.length() < 26) return false;
//         boolean[] present = new boolean[26];
//         for(char ch : sentence.toCharArray()){
//             int index = ch - 'a';
//             present[index] = true;
//         }
//         for(int i = 0 ; i < 26 ; i++){
//             if(!present[i]) return false;
//         }
//         return true;
        
//     }
// }