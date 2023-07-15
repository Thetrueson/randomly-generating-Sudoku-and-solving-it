package project9;
import java.util.Scanner;
public class Problem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] big = qustion(n,n*n-m);
		print(big);
		int[] temp = new int[1];
		temp[0] = m;
		print(answer2(big,temp));
	}
	public static boolean judge(int[][] n,int n1,int n2,int n3)
	{
		int[][] n_ = new int[n.length][n.length];
		for(int i = 0;i<n_.length;i++)
		{
			for(int j =0;j<n_[i].length;j++)
			{
				n_[i][j] = n[i][j];
			}
		}
		n_[n2][n3] = n1;
		for(int i = 0;i<n_.length;i++)
		{
			int t = 0;
			for(int j = 0;j<n_[i].length;j++)
			{
				if(n_[i][j] == n1)
				{
					t++;
				}
				if(t>1)
				{
					return false;
				}
			}
		}
		for(int i = 0;i<n_.length;i++)
		{
			int t = 0;
			for(int j = 0;j<n_[i].length;j++)
			{
				if(n_[j][i] == n1)
				{
					t++;
				}
				if(t>1)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static int[][] qustion(int k,int temp)
	{
		int[][] n = new int[k][k];
		int m1 = 0;
		int m2 = 0;
		boolean angle = true;
		while(angle)
		{
			for(int i = 0;i<n.length;i++)
			{
				for(int j = 0;j<n[i].length;j++)
				{
					n[i][j] = 0;
				}
			}
			angle = false;
			int temp1 = temp;
			while(temp1>0)
			{
				do
				{
					m1 = (int)(Math.random()*(n.length));
					m2 = (int)(Math.random()*(n.length));
				}while(n[m1][m2]!=0);
				for(int i = 1;i<=n.length;i++)
				{
					n[m1][m2] = i;
					if(judge(n,n[m1][m2],m1,m2))
					{
						temp1--;
						break;
					}
					else
					{
						n[m1][m2] = 0;
					}
				}
				if(n[m1][m2] == 0)
				{
					angle = true;
					//System.out.println("-1");
					break;
				}
			}
		}
		return n;
	}
	public static int[][] answer1(int[][] n,int temp)
	{
		int[][] n_ = new int[n.length][n.length];
		int m1 = 0;
		int m2 = 0;
		boolean angle = true;
		int count = 0;
		while(angle)
		{
			if(count>Math.pow(n.length, 5.5))
			{
				return null;
			}
			count++;
			for(int i = 0;i<n.length;i++)
			{
				for(int j = 0;j<n[i].length;j++)
				{
					n_[i][j] = n[i][j];
				}
			}
			angle = false;
			int temp1 = temp;
			while(temp1>0)
			{
				do
				{
					m1 = (int)(Math.random()*(n.length));
					m2 = (int)(Math.random()*(n.length));
				}while(n_[m1][m2]!=0);
				for(int i = 1;i<=n.length;i++)
				{
					n_[m1][m2] = i;
					if(judge(n_,n_[m1][m2],m1,m2))
					{
						temp1--;
						break;
					}
					else
					{
						n_[m1][m2] = 0;
					}
				}
				if(n_[m1][m2] == 0)
				{
					angle = true;
					break;
				}
			}
		}
		return n_;
	}
	public static int[][] answer2(int[][] n,int[] temp)
	{
		int m1 = 0;
		int m2 = 0;
		int[] nums = seek(n,m1,m2);
		proceed(n,nums[0],nums[1],temp);
		return n;
	}
	public static void proceed(int[][] n,int m1,int m2,int[] temp)
	{
		if(m1 == -1)
		{
			return;
		}
		for(int i = 1;i<=n.length;i++)
		{
			if(temp[0]==0)
			{
				break;
			}
			if(judge(n,i,m1,m2))
			{
				if(n[m1][m2]==0)
				{
					temp[0]--;
				}
				n[m1][m2] = i;
				int[] nums = seek(n,m1,m2);
				proceed(n,nums[0],nums[1],temp);
				if(temp[0]!=0&&n[m1][m2]!=0)
				{
					n[m1][m2] = 0;
					temp[0]++;
				}
			}
		}
		if(n[m1][m2] == 0)
		{
			//System.out.println("-1");
			return;
		}
		else
		{
			return;
		}
	}
	public static int[] seek(int[][] n,int m1,int m2)
	{
		int[] nums = new int[2];
		for(;m1<n.length;m1++)
		{
			for(m2 = 0;m2<n[m1].length;m2++)
			{
				if(n[m1][m2] == 0)
				{
					nums[0] = m1;
					nums[1] = m2;
					return nums;
				}
			}
		}
		nums[0] = -1;
		nums[1] = -1;
		return nums;
		
	}
	public static void print(int[][] n)
	{
		if(n == null)
		{
			System.out.println("-1");
			return;
		}
		for(int j = 0;j<n[0].length;j++)
		{
			System.out.print("--");
		}
		System.out.println();
		for(int i = 0;i<n.length;i++)
		{
			for(int j = 0;j<n[i].length;j++)
			{
				System.out.print("|");
				if(n[i][j]==0)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(n[i][j]);
				}
			}
			System.out.println("|");
			for(int j = 0;j<n[0].length;j++)
			{
				System.out.print("--");
			}
			System.out.println();
		}
		System.out.println();
	}
}
