import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PALIN: Generating the next larger Palindrome
 * Spaghetti code, too many test cases handled individually. Avoided uses recursion due to NZEC.
 * Tested on:
 * 5 - 6 
9 - 11 
119 - 121 
192 - 202 
5403123 - 5404045 
12 - 22 
200 - 202 
0 - 1 
123456789 - 123464321 
987654321 - 987656789 
322222222 - 322222223 
3223 - 3333 
3123 - 3223 
9994 - 9999 
1991 - 2002 
10 - 11 
1299976 - 1300031 
9999 - 10001 
99999 - 100001 
20899802 - 20900902 
105 - 111 
 * @author mbhargava
 *
 */
public class PALIN 
{
	
	public static void main(String[] args)
	{
		 BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		 StringBuffer num = null;
		 int count = 0;
		 int testCaseCount = 0;
		try {
			testCaseCount = Integer.parseInt(inp.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 while(count++ < testCaseCount)
		 {
			 try {
				num = new StringBuffer(inp.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 int length = num.length();
			 
			 if(length == 1 && !num.toString().equals("9"))
			 {
				 int n = Integer.parseInt(num.toString());
				 n++;
				 num = new StringBuffer(Integer.toString(n));
			 }
			 else if(num.toString().equals("10") || num.toString().equals("9"))
			 {
				 num = new StringBuffer("11");
			 }
			 else if((length%2) == 0)
			 {
				 //number of digits are even
				 String left = num.substring(0, length/2);
				 String right = num.substring(length/2, length);
				 
				 boolean rlarge = findLarger(left, right);
				 if(!rlarge && !(left.toString().equals(right.toString())))
				 {
					 StringBuffer lrev = new StringBuffer(left).reverse();
					 rlarge = findLarger(lrev.toString(), right);
					 StringBuffer lBuffer = new StringBuffer(num.substring(0, length/2));
					 if(rlarge)
					 {
						 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
						 //lBuffer.
					 }
					 //else
					 //{
						 
						 lBuffer.append(new StringBuffer(lBuffer).reverse());//lrev);
						 if(lBuffer.toString().equals(num.toString()))
						 {
							 lBuffer = new StringBuffer(left);
							 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
							 lBuffer.append(new StringBuffer(lBuffer).reverse());
						 }
						 num = lBuffer;
				 }
				 else
				 {
				 
				 StringBuffer lBuffer = new StringBuffer(num.substring(0, length/2));
				 length = lBuffer.length();
				 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
				 if(length != lBuffer.length())
				 {
					 lBuffer.append(new StringBuffer(lBuffer.substring(0, lBuffer.length() - 1)).reverse());
				 }
				 else
				 {
					 lBuffer.append(new StringBuffer(lBuffer).reverse());
				 }
				 num = lBuffer;
				 }
			 }
			 else
			 {
				 //System.out.println(num);
				 //number of digits are odd
				 String left = num.substring(0, length/2);
				 String right = num.substring(length/2+1, length);
				 
				 boolean rlarge = findLarger(left, right);
				 if(!rlarge && !(left.toString().equals(right.toString())))
				 {
					 StringBuffer lrev = new StringBuffer(left).reverse();
					 rlarge = findLarger(lrev.toString(), right);
					 StringBuffer lBuffer = new StringBuffer(num.substring(0, length/2+1));
					 if(rlarge)
					 {
						 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
						 //lBuffer.
					 }
					 //else
					 //{
						 
						 lBuffer.append(lrev);
						 if(lBuffer.toString().equals(num.toString()))
						 {
							 lBuffer = new StringBuffer(num.substring(0, length/2+1));
							 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
							 lBuffer.append(new StringBuffer(lBuffer.substring(0, lBuffer.length() - 1)).reverse());
						 }
						 num = lBuffer;
					 //}
				 }
				 else
				 {
				 //if
				 StringBuffer lBuffer = new StringBuffer(num.substring(0, length/2+1));
				 length = lBuffer.length();
				 lBuffer = incrementDigit(lBuffer, lBuffer.length() - 1, 1);
				 if(length != lBuffer.length())
				 {
					 lBuffer = new StringBuffer(lBuffer.substring(0, lBuffer.length() - 1));
					 num = lBuffer.append(new StringBuffer(lBuffer).reverse().toString());
					 
				 }
				 else
				 {
					String str = lBuffer.substring(0, lBuffer.length() - 1);
					lBuffer.append(new StringBuffer(str).reverse());
					num = lBuffer;
				 }
				 }
			 }
			 System.out.println(num);
		 }
	}
	
	
	/**
	 * Returns true if right is larger else returns false
	 * @param left
	 * @param right
	 * @return
	 */
	private static boolean findLarger(String left, String right)
	{
		for(int i = 0; i < left.length(); i++)
		{
			if(left.charAt(i) == right.charAt(i))
			{
				continue;
			}
			
			if(left.charAt(i) > right.charAt(i))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
	/**
	 * Increment any character based digit in a String based number
	 * @param digit
	 * @return
	 */
	private static StringBuffer incrementDigit(StringBuffer num, int index, int addend)
	{
		while(addend != 0)
		{
			if(index == -1)
			{
				num.insert(0, addend);
				return num;
			}
			
			if(Character.getNumericValue(num.charAt(index)) == 9)
			{
				num.setCharAt(index, Character.forDigit(0, 10));
				addend = 1;
				index--;
			}
			else
			{
				int charNum = Character.getNumericValue(num.charAt(index));
				charNum++;
				num.setCharAt(index, Character.forDigit(charNum, 10));
				index--;
				addend = 0;
			}
		}
		return num;
	}

}
