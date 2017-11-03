package main.java.com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringGame 
{
	private Map<String,Integer> holder = new HashMap<>();
	public static void main(String args[])
	{
		System.out.println("Please enter a text to search");
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		StringGame interestingGame = new StringGame();
		interestingGame.getCount(input);
		
		System.out.println("The number of times each letter appears in the String");
		
		interestingGame.displayResults(input);
		if(input.equals(interestingGame.reverseString(input)))
		{
			System.out.println("Same string");
		}
		else		
			{
				System.out.println("Not the same string");
			}
			
		int[] arrayToReverse;
		arrayToReverse = new int[] {2,3,4,7,23,33,34,39};
		
		System.out.println("Array before sorting" + Arrays.toString(arrayToReverse));
		
		interestingGame.reverseArray(arrayToReverse, 0, arrayToReverse.length - 1);
		
		System.out.println("Array after sorting" + Arrays.toString(arrayToReverse));
		
		interestingGame.displayFibonacchi();
		
		int [] resultArray = interestingGame.findHighestNumber();
		
		System.out.format("The highest two number of this array are %d and %d.%n", 
				Integer.valueOf(resultArray[0]), Integer.valueOf(resultArray[1]));
		
		int [][] arrayToSum = {{12,13,17}, {23,25,12}, {2,7,8}, {0,3,5}};
		
		Map<Integer,Integer> summedMap =  interestingGame.sumArrayByColumn(arrayToSum);
		
		for(Map.Entry<Integer, Integer> entry : summedMap.entrySet())
		{
			System.out.format("The sum of the column %d is %d.%n", entry.getKey(), entry.getValue());
		}
		
		int[][] secondArray = {{2,3,17}, {3,5,1}, {1,3,5}, {0,2,4}};
		
		Map<Integer,Integer> arraysSummary = interestingGame.sumTwoArrays(arrayToSum, secondArray);
		
		for(Map.Entry<Integer, Integer> entry : arraysSummary.entrySet())
		{
			System.out.format("The sum of the 2 arrays are; row %d is %d.%n", entry.getKey(), entry.getValue());
		}
	}
	
	private Map<Integer, Integer> sumTwoArrays(int[][] arrayToSum, int[][] secondArray) 
	{
		
		Map<Integer,Integer> rowMap = new HashMap<>();
		
		
		for(int x = 0; x < arrayToSum.length; x++)
		{
			int  rowSummary = 0;
			
			for(int y = 0; y < arrayToSum[x].length; y++)
			{
				rowSummary += arrayToSum[x][y] + secondArray[x][y];
				
			}
			rowMap.put(x, rowSummary);
		}
		
		return rowMap;
	}

	private Map<Integer,Integer> sumArrayByColumn(int[][] arrayToSum) 
	{
		Map<Integer,Integer> totalMap = new HashMap<>();
		
		int columnLength = arrayToSum[0].length;
		
		for(int x = 0; x < columnLength; x++)			
		{
			int sum = getColumnTotalValue(arrayToSum, x);
			totalMap.put(x, sum);
		}
		
		return totalMap;
	}

	private int getColumnTotalValue(int[][] arrayToSum, int currentColumn)
	{
		int columnSum = 0;
				
		for(int row = 0;  row < arrayToSum.length; row++)
		{
			columnSum += arrayToSum[row][currentColumn];
			
		}
		
		return columnSum;
	}
	private void getCount(String input)
	{
		for (char ch : input.toCharArray())
		{
			if(ch != ' ')
			{
				if(holder.containsKey(String.valueOf(ch)))
				{
					holder.put(String.valueOf(ch), holder.get(String.valueOf(ch)) +1);
				}
				else
				{
					holder.put(String.valueOf(ch), 1);
				}
			}
			
		}
	
	}
	
	private void displayResults(String input)
	{
		for(Map.Entry<String, Integer> entry : holder.entrySet())
		{
			System.out.format("The letter %s occurs in the word %s %x times.%n", entry.getKey(), input, entry.getValue());
			
		}
	}
	
	private String reverseString(String passedString)
	{
		StringBuilder sb = new StringBuilder();
		if (passedString == null || passedString.isEmpty() )
		{
			return "";
		}
		else
		{
			for (int x = (passedString.length() - 1); x>=0; x--)
			{
				sb.append(passedString.charAt(x));
			}
		}
		
		return sb.toString();
	}
	
	private int[] reverseArray(int[] arrayToReverse, int start, int end)
	{
		if (start > end)
		{
			return arrayToReverse;
		}
		int x = start;
		int y = end;
		int tmp = arrayToReverse[x];
		arrayToReverse[x] = arrayToReverse[y];
		arrayToReverse[y] = tmp;
		x++;
		y--;
		return reverseArray(arrayToReverse, x, y);		
	}
	
	private void displayFibonacchi()
	{
		Integer number1 = 0;
		Integer number2 = 1;
		StringBuilder sb = new StringBuilder();
		
		
		sb.append(number1).append(" ").append(number2).append(" ");
		
		performLoop(number1, number2, sb, 8);
		
		System.out.println(sb.toString());
	}

	private void performLoop(Integer number1, Integer number2, StringBuilder sb, int count) 
	{
		Integer number3 = 0;
		if (count > 0)
		{
			number3 = number1 + number2;
			sb.append(number3).append(" ");
			number1 = number2;
			number2 = number3;
			count--;
			performLoop(number1, number2, sb, count);
		}
	}
	
	private int[] findHighestNumber()
	{
		
		int number1 = 0;
		int number2 = 0;
		int [] findArray = {23,4,76,11,12,45,17,23};
		
		for (int number : findArray)
		{
			if(number1 < number)
			{
				number2 = number1;
				number1 = number;
			}
			else
			{
				if(number2 < number)
				{
					number2 = number;
				}
			}
		}
		return new int[] {number1,number2};
		
	}
	
}
