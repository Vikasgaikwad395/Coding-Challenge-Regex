import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
	
		private static ArrayList<Integer> buildTeam(ArrayList<Integer> team, int skill){
			ArrayList<Integer> newTeam = new ArrayList<Integer>();
			newTeam.add(skill);
			
			for (int player : team)
			{
				if (skill == (player + 1))
				{
					newTeam.add(player);
				}
			}
			
			return newTeam;
		}
		
		private static boolean canBuildTeam(ArrayList<Integer> team, int skill){
			boolean canBuildTeam = false;
			
			for (int player : team)
			{
				if (skill == (player + 1))
				{
					canBuildTeam = true;
					break;
				}
			}
			return canBuildTeam;
		}
		
		private static void printSmallestTeam(ArrayList<ArrayList<Integer>> teams)
		{
			int tmp;
			int smallest = teams.get(0).size();
			
			for (int i = 1; i < teams.size(); i++)
			{
				tmp = teams.get(i).size();
				if (tmp < smallest)
				{
					smallest = tmp;
				}
			}
			
			System.out.println(smallest);
		}
		
		private static void findSmallestTeam(ArrayList<Integer> team)
		{
			ArrayList<ArrayList<Integer>> teams = new ArrayList<ArrayList<Integer>>();
			
			for (int player : team)
			{
				if (canBuildTeam(team, player))
				{
					teams.add(buildTeam(team, player));
				}
			}
			
			printSmallestTeam(teams);
		}

		public static void main(String[] args) throws IndexOutOfBoundsException{
			int  			   i, n, t;
			System.out.println("Enter the teams");
			Scanner 		   scanner = new Scanner(System.in);
			ArrayList<Integer> team = new ArrayList<Integer>();
			
			t = scanner.nextInt();
			while (t > 0)
			{
				n 	 = scanner.nextInt();
				for (i = 0; i < n; i++)
				{
					team.add(scanner.nextInt());
				}
				
				findSmallestTeam(team);
				--t;
			}
			
			
		}
}