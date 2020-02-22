public class Numbers {

	public static void main(String[] args) {
		//raise the number in the ten power
		int two=2, three=3, twoInTheTenPower = two, threeInTheTenPower=three;
		for (int i=0; i<9; i++){
			twoInTheTenPower*=two;
			threeInTheTenPower*=three;
		}
		System.out.println("2^10="+twoInTheTenPower);
		System.out.println("3^10="+threeInTheTenPower);
		//alternative method of exponentiation, only for powers of two
		System.out.println("2^10="+(2<<9));
		//finding of the maximum
		int a=1250, b=500, c=3400, maxNumber=0;
		if ((a>b)&&(a>c)){
			maxNumber=a;
		}
		else if (b>c){
			maxNumber=b;
		}
		else maxNumber=c;
		System.out.println("maximum number of:"+a+" "+b+" "+c+" is "+maxNumber);
	}

}
