class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1)
            return s;
        
        StringBuilder[] sbArr = new StringBuilder[numRows];
        
        for(int i = 0 ; i<sbArr.length ; i++){
            sbArr[i] = new StringBuilder();
        }
        
        char[] chArr = s.toCharArray();
        
        for(int i = 0 ; i<chArr.length ; i++){
            int mod = i%(numRows*2-2);
            if(mod<numRows-1)
                sbArr[mod].append(chArr[i]);
            else
                sbArr[numRows*2-2-mod].append(chArr[i]);
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0 ; i<sbArr.length ; i++){
            answer.append(sbArr[i]);
        }
        
        return answer.toString();
        
    }
}
