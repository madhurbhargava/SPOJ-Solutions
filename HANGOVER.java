import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TestClass{
	
	public static void main(String[]args)
	{
		Scanner a = new Scanner(System.in);
		BigDecimal dec = new BigDecimal(-1.0);
		BigDecimal limit = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
		while(dec.compareTo(limit) != 0)
		{
			dec = a.nextBigDecimal().setScale(2, RoundingMode.HALF_UP);
			if(dec.compareTo(limit) != 0)
			{
				calcOverHang(dec);
			}
		}
	}
	
	private static void calcOverHang(BigDecimal limit)
	{
		int result = 0;
		BigDecimal overhang = new BigDecimal(0);
		float denom = 2;
		
		while(overhang.compareTo(limit) != 1)
		{
			overhang = overhang.add(new BigDecimal((float)1/denom));
			denom++;
			result++;
		}
		System.out.println(result+" card(s)");
	}
	
}