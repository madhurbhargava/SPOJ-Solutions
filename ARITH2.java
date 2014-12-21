import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class ARITH2 {

	private static String OPERATOR = "";
	private static String PLUS = "+";
	private static String MUL = "*";
	private static String DIV = "/";
	private static String MINUS = "-";
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < num; i++)
		{
			//read the empty line
			reader.readLine();
			ArrayDeque<String> queue = convertToQueue(reader.readLine());
			long total = Long.parseLong(queue.remove());
			while(!queue.isEmpty())
			{
				String str = queue.remove();
				if(str.equals("+") || str.equals("-") || str.endsWith("/") || str.equals("*"))
				{
					OPERATOR = str;
					continue;
				}
				else
				{
					if(OPERATOR.equals(PLUS))
					{
						total = total + Long.parseLong(str);
					}
					else if(OPERATOR.equals(MUL))
					{
						total = total * Long.parseLong(str);
					}
					else if(OPERATOR.equals(MINUS))
					{
						total = total - Long.parseLong(str);
					}
					else if(OPERATOR.equals(DIV))
					{
						total = total / Long.parseLong(str);
					}
				}
			}
			out.println(total);
			out.flush();
		}
	}
	
	private static ArrayDeque<String> convertToQueue(String str)
	{
		StringTokenizer stok = new StringTokenizer(str);
		ArrayDeque<String> queue = new ArrayDeque<String>();
		while(stok.hasMoreTokens())
		{
			queue.add(stok.nextToken());
		}
		//remove "="
		queue.removeLast();
		return queue;
	}

}

