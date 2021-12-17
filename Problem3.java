import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem3 {
	private static final String[] tens_names = {
			" ", "ten\s", "twenty\s", "thirty\s", "fourty\s", "fifty\s", "sixty\s", "seventy\s", "eighty\s","ninety\s"
		};
	
	private static final String[] num_Names = {
			"one\s", "two\s","three\s", "four\s", "five\s", "six\s","seven\s","eight\s","nine\s","ten\s",
			"eleven\s", " twevle\s", "thirteen\s", "fourteen\s", "fifteen\s", "sixteen\s", "seventeen\s",  "eighteen\s", "nineteen\s" 
	};
	
	private static String Upto_one_thousand(int number) {
		String soFar;
		
		if(number % 100 < 20) {
			soFar = num_Names[number % 100];
			number /= 100;			
		}else {
			soFar = num_Names[number % 10];
			number /= 10;
			
			soFar = tens_names[number % 10] + soFar;
			number /= 10;
			
		}
		if(number == 10) {
			return soFar;			
			}
		return num_Names[number] + "hundred\s" + soFar;
	}
	
	public static String convert (long number) {
		if(number == 0) {
			return "Zero";
		}
		String snumber = Long.toString(number);
		
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);
		
		int billion = Integer.parseInt(snumber.substring(0,3));
		
		int millions = Integer.parseInt(snumber.substring(3,6));
		
		int hundredThoudsand = Integer.parseInt(snumber.substring(6,9));
		
		int thousand = Integer.parseInt(snumber.substring(9, 12));
		
		String tradBillions;
		switch(billion) {
		case 0 :
			tradBillions = " ";
				break;
				
		case 1 :
			tradBillions = Upto_one_thousand(billion) + "billion\s";
				break;
				
		default:
			tradBillions = Upto_one_thousand(billion) + "billion\s";				
		}
		
		String result = tradBillions;
		
		String tradMillions;
		switch(millions) {
		
		case 0:
			tradMillions = " ";
			break;
			
		case 1: 
			tradMillions = Upto_one_thousand(millions) + "million\s";
			break;
			
			default:
				tradMillions = Upto_one_thousand(millions) + "million\s";				
			}
		result = result + tradMillions;
		
		String tradHundredThousand;
		switch(hundredThoudsand) {
		
		case 0:
			tradHundredThousand = " ";
			break;
			
		case 1: 
			tradHundredThousand = "one thousand\s";
			break;
			
			default:
				tradHundredThousand = Upto_one_thousand(hundredThoudsand) + "thousand\s";				
			}
		result = result + tradHundredThousand;
		
		String tradThousand;
		tradThousand = Upto_one_thousand(thousand);
		result = result +tradThousand;
		
		
		return result.replaceAll("^\\s+"," " ).replaceAll("\\b\\s{2,}\\b"," ");		
		
	}
	
	public static void main(String[] args) {
		System.out.println(convert(123));
		System.out.println(convert(12345));
		System.out.println(convert(1234567));
		System.out.println(convert(1234567891));
	}
	
}
