import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Spoj Problem: STPAR
 Stack based implementation.
 * @author madhurbhargava
 *
 */
public class STPAR {
	
	public static void main(String[] args) throws Exception
	{
		
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			while(true)
			{
				int numCount = Integer.parseInt(reader.readLine());
				if(numCount == 0)
				{
					break;
				}
				LinkedList<Integer> list = convertToList(reader.readLine(), numCount);
				CustomStack stack = new CustomStack(numCount);
				
				boolean canArrange = true;
				
				outerloop:
				for(int i = 0; i < list.size(); i++)
				{
					if(i == list.size() - 1)
					{
						//we reached the end of the list and the stack is not empty, lets try to empty it
						if(!stack.isEmpty())
						{
							innerloop:
							while(!stack.isEmpty())
							{
								int val = stack.pop();
								int curr = list.get(i);
								int diff = val - curr;
								if(diff != 1)
								{
									canArrange = false;
									break outerloop;
								}
								else
								{
									list.add(val);
									i++;
								}
								
							}
						}
					}
					else
					{
						int curr = list.get(i);
						int next = list.get(i+1);
						if(curr > next)
						{
							boolean canPush = stack.canPush(curr);
							if(!canPush)
							{
								canArrange = false;
								break;
							}
						
							stack.push(curr);
							list.remove(i--);
						}
						else
						{
							int diff = next - curr;
							//if the difference between this and the next is greater than 1, 
							//try pulling something from the stack
							if(diff > 1 && !stack.isEmpty())
							{
								int top = stack.peek();
								diff = top - curr;
								if(diff == 1)
								{
									list.add(i+1, top);
									stack.pop();
								}
							}
						}
					}	
				}
				
				if(canArrange && !stack.isEmpty())
				{
					canArrange = false;
				}
				
				if(canArrange)
				{
					out.println("yes");
				}
				else
				{
					out.println("no");
				}
				out.flush();
			}
			
			
		}
	}
	
	private static LinkedList<Integer> convertToList(String data, int num)
	{
		StringTokenizer tokens = new StringTokenizer(data);
		LinkedList<Integer> arr = new LinkedList<Integer>();
		while(tokens.hasMoreTokens())
		{
			arr.add(Integer.parseInt(tokens.nextToken()));	
		}
		return arr;
	}
	
	private static class CustomStack 
	{
		
		private int mTop;
		private int mArr[];
		
		/**
		 * Allocates a stack of given size
		 */
		public CustomStack(final int size)
		{
			mArr = new int[size];
			mTop = -1;
		}
		
		public boolean isEmpty()
		{
			return mTop == -1;
		}
		
		public boolean canPush(int val)
		{
			if(mTop == -1)
			{
				return true;
			}
			if(val > mArr[mTop])
			{
				return false;
			}
			return true;
		}
		
		public int peek()
		{
			return mArr[mTop];
		}
		
		public void push(int val)
		{
			mTop = mTop + 1;
			mArr[mTop] = val;
		}
		
		public int pop()
		{
			if(isEmpty())
			{
				return -1;
			}
			int num = mArr[mTop];
			mArr[mTop] = 0;
			mTop--;
			return num;	
		}
	}
}
