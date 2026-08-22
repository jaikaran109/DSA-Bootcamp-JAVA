import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(helper(n));
	}
	static int helper(int n){
	    if(n <= 1) return n;
	    return helper(n-1) ^ helper(n-2);
	}
}
