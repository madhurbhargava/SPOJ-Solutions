import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;
 
/**
 * SPOJ: FAVDICE
 * Problem talks about expected input in terms of probability theory.
 * For 6 faced die: You need one roll to see the first face. 
 * After that, the probability of rolling a different number is 5/6. 
 * Therefore, on average, you expect the second face after 6/5 rolls. 
 * After that value appears, the probability of rolling a new face is 4/6, 
 * and therefore you expect the third face after 6/4 rolls. 
 * Continuing this process leads to the conclusion that the expected number of rolls before all six faces appear is
	6/6 + 6/5 + 6/4 + 6/3 + 6/2 + 6/1 = 14.7 rolls
 * 
 * @author madhurbhargava
 */
public class FAVDICE {
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++)
		{
			double die = scan.nextDouble();
			double denom = die;
			double total = 0;
			for(int j = 0; j < die; j++)
			{
				total = total+(die/denom);
				denom--;
			}
			out.println(round(total, 2));
			out.flush();
		}
		
		
	}
	
	public static BigDecimal round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd;
	}
}
 