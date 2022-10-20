package Medium.no12;

class Solution_ {
	
	StringBuilder sb = new StringBuilder();
	int i;
	
    public String intToRoman(int num) {
    	
    	i = num;
    	
    	process();
    	
    	return sb.toString();
        
    }
    
    public void process() {
    	
    	if(i==0)
    		return;
    	else if(i>999) {
    		sb.append("M");
    		i -= 1000;
    	}else if(i>899) {
    		sb.append("CM");
    		i -= 900;
    	}else if(i>499) {
    		sb.append("D");
    		i -= 500;
    	}else if(i>399) {
    		sb.append("CD");
    		i -= 400;
    	}else if(i>99) {
    		sb.append("C");
    		i -= 100;
    	}else if(i>89) {
    		sb.append("XC");
    		i -= 90;
    	}else if(i>49) {
    		sb.append("L");
    		i -= 50;
    	}else if(i>39) {
    		sb.append("XL");
    		i -= 40;
    	}else if(i>9) {
    		sb.append("X");
    		i -= 10;
    	}else if(i>8) {
    		sb.append("IX");
    		i -= 9;
    	}else if(i>4) {
    		sb.append("V");
    		i -= 5;
    	}else if(i>3) {
    		sb.append("IV");
    		i -= 4;
    	}else {
    		sb.append("I");
    		i -= 1;
    	}
    	
    	process();
    }
}