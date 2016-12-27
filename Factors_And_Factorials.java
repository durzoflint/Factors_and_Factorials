import java.io.*;
class Factors_And_Factorials
{
	static int a[][]=new int[100][2],al=0;
	public static void main(String arghh[])throws Exception
	{
		for(int i=1;i<=100;i++)
		{
			int c=0;
			for(int j=1;j<=i;j++)
			if(i%j==0)
			c++;
			if(c==2)
			a[al++][0]=i;
		}
		input();
	}
	static void generate(int n)
	{
		for(int i=1;i<=n;i++)
		{
			int x=0,k=i;
			for(int j=0;j<al;j++)
			{
				while(k!=1)
				{
					if(k%a[x][0]==0)
					{
						k=k/a[x][0];
						a[x][1]++;
					}
					else
					x++;
				}
			}
		}
	}
	static void input()throws Exception
	{
		BufferedReader br=new BufferedReader(new FileReader("Questions.txt"));
		String s="";
		while((s=br.readLine())!=null)
		{
			int n=Integer.parseInt(s);
			if(n==0)
			break;
			generate(n);
			if(s.length()==2)
			System.out.print(" "+n+"! =");
			if(s.length()==1)
			System.out.print("  "+n+"! =");
			if(s.length()==3)
			System.out.print(n+"! =");
			for(int i=0;i<al;i++)
			{
				if(i%15==0&&i>1)
				System.out.print("\n      ");
				String x=""+a[i][1];
				if(a[i][1]==0)
				break;
				if(x.length()==2)
				System.out.print(" "+a[i][1]);
				if(x.length()==1)
				System.out.print("  "+a[i][1]);
				a[i][1]=0;
			}
			System.out.println();
		}
	}
}