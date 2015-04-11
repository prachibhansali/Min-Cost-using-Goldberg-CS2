package FPAEvaluate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PS4Q1 {

	public static void main(String args[]) throws FileNotFoundException
	{
		String s="";
		int N=10000;
		int sink=(2*N+3);
		int supersink=sink+1;
		s+= "c This is an example of a comment line.\n";
		int v=2*N+4;
		int edge=3*N+2;
		String int_edges="";
		for(int i=N;i>0;i--)
			{
			for(int j=1;j<=(i/2);j++)
			{
				int div=i%j==0? (i/j) : -1;
				if(div!=-1 && hasValidFactors(div))
					{
					edge++;
					int_edges+="a "+(N+i+2)+" "+(j+2)+" "+"0"+" "+"1"+" "+"0\n";
					//int_edges+="a "+i+" "+j+" "+"0"+" "+"1"+" "+"2\n";
					}
			}
	}
		s+="p min "+String.valueOf(v)+" "+String.valueOf(edge)+"\n";
		s+="c Node descriptor lines (supply+ or demand-)\n";
		s+="n 1 27\n";
		s+="n "+supersink+" -27\n";
		s+="c Arc descriptor lines (from, to, minflow, maxflow, cost)\n";
		s+="a 1 2 0 27 0\n";
		s+="a "+sink+" "+supersink+" 0 -27 0\n";
		for(int i=1;i<=N;i++)
			s+="a "+2+" "+(i+2)+" "+"0"+" "+"1"+" "+"0\n";
		for(int i=1;i<=N;i++)
			s+="a "+(i+2)+" "+(N+i+2)+" "+"0"+" "+"1"+" "+"-1\n";
		for(int i=N;i>=1;i--)
			s+="a "+(i+2)+" "+sink+" "+"0"+" "+"1"+" "+"0\n";
		s+=int_edges;
		
		PrintWriter pw=new PrintWriter(new File("output-dmacs.txt"));
		pw.write(s);
		pw.close();
	}

	private static boolean hasValidFactors(int div) {
		if(div==1) return true;
		while(div%2==0)
			{
			div=div/2;
			if(div==1) {
				div=0;
				break;
			}
			}
		if(div!=0)
		while(div%3==0)
		{
			div=div/3;
			if(div==1) {
				div=0;
				break;
			}
		}
		if(div==0) return true;
		else return false;
	}
}
