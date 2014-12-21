import java.util.Scanner;
public class TestClass {
	public static void main(String[]args){
		Scanner a=new Scanner(System.in);
		int numTestCase=a.nextInt();
		a.nextLine();
		for(int x = 0;x<numTestCase;x++){
			String[]val=a.nextLine().split(" ");
			long res=modExp(Long.parseLong(val[0]),Long.parseLong(val[1]), 10);
			System.out.println(res);}
	}
	static long modExp(long base,long exp,int modvar){
		String binary=Long.toBinaryString(exp);
		long res=1;
		while(binary.length()!=0){
			if (binary.charAt(binary.length()-1)=='1'){
		           res=(res*base)%modvar;}
			binary=binary.substring(0,binary.length()-1);
			base=(base*base)%modvar;
		}return res;
	}	
}