import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Problem Invcnt, Counts the number of inversions using modified merge-sort.
 * The merge-sort implementation is the one from Cormen.
 * @author mbhargava
 *
 */
public class INVCNT {
	
	static long counter = 0;
	public static void main(String[] args) 
	{
		Parser in = new Parser(System.in);
	    PrintWriter out = new PrintWriter(System.out, true);
	    try
	    {
	    	int testCount = in.nextInt();
	    	while(testCount-- != 0)
	    	{
	    		counter = 0;
	    		final int arrSize = in.nextInt();
	    		int[] arr = new int[arrSize];
	    		for(int i = 0; i < arrSize; i++)
	    		{
	    			arr[i] = in.nextInt();
	    		}
	    		mergeSort(arr, 0, arr.length - 1);
	    		System.out.println(counter);
	    	}
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	private static void mergeSort(int[] arr, int p, int r)
	{
		if(p < r)
		{
			int q = (p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
			
		}
	}
	
	
	/**
	 * Merge function
	 * @param arr, original array
	 * @param p, start index of first array
	 * @param q, end index of first array
	 * @param r, end index of array arr
	 */
	public static void merge(int[] arr, int p, int q, int r)
	{
		final int n1 = q - p + 1;
		final int n2 = r - q;
		final int[]left = new int[n1+1];
		final int[]right = new int[n2+1];
		for(int i = 0; i < n1; i++)
		{
			left[i] = arr[p+i];
		}
		
		for(int i = 0; i < n2; i++)
		{
			right[i] = arr[q+i+1];
		}
		
		left[n1]  = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for(int k = p; k <= r;k++)
		{
			if(left[i] <= right[j])
			{
				arr[k] = left[i++];
			}
			else
			{
				//counter++;
				arr[k] = right[j++];
				counter += n1-i;
			}
		}
	}
	
	/**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 65536;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        /**
         * Read a line of data from the input stream.
         * @return the next line of data.
         * @throws IOException if an I/O error occurs.
         */
        public String readLine() throws IOException {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char)(read())) != '\n') {
                line.append(c);
            }
            return line.toString();
        }

        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }

}
