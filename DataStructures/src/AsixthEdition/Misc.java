package AsixthEdition;

public class Misc {
	public static void main(String[] args){
		System.out.println(squareRoot(50));
	}
	
	public static double squareRoot(double x){
		double low = 0;
		double high = x;
		double mid = (low + high) / 2;
		double prevMid = 0;;
		double diff = Math.abs(mid - prevMid);
		double precision = 0.0005;
		while(mid*mid != x && precision < diff){
			
			if(mid*mid > x){
				high = mid;
			}else {
				low = mid;
			}
			prevMid = mid;
			mid = (low + high) /2;
			diff = Math.abs(mid - prevMid);
		}
		
		
		return mid;
	}
}