package com.tiy.baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballStats
{
	public static void main(String[] args)
	{
		boolean anotherPlayer = true;
		while (anotherPlayer)
		{
			Scanner in = new Scanner(System.in);
			ArrayList<Integer> batResults = new ArrayList<>();
			int atBatResult;
			int atBats;

			System.out.println("Enter player's at-bats:");
			atBats = Integer.parseInt(in.nextLine());

			if (atBats > 10)
				atBats = 10;
			else if (atBats < 1)
				atBats = 1;

			for (int i = 0; i < atBats; i++)
			{
				System.out.format("How many bases were taken for at-bat #%d: ", i + 1);
				atBatResult = Integer.parseInt(in.nextLine());

				if (atBatResult > 4)
					atBatResult = 4;
				else if (atBatResult < 0)
					atBatResult = 0;

				System.out.println("\t" + atBatResult + " base(s) entered.");
				batResults.add(atBatResult);
			}

			printStats(batResults);
			
			System.out.println("\n\nDo you want to calculate another player? yes/no");
			String anotherPlayerInput = in.nextLine();
			if (anotherPlayerInput.toLowerCase().equals("no")){
				anotherPlayer = false;
				System.out.println("Done.");
			}

		}
	}

	private static void printStats(ArrayList<Integer> batResults)
	{
		int totalBases = 0;
		int totalHits = 0;

		for (Integer batResult : batResults)
		{
			totalBases += batResult;
			if (batResult > 0)
				totalHits++;
		}

		System.out.format("\nSLUGGING: %.2f\n", (float) totalBases / (float) batResults.size());
		System.out.format("AVERAGE: %.2f", (float) totalHits / (float) batResults.size());
	}

}
