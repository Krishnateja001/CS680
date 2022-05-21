package edu.umb.cs680.hw10;

import java.util.List;

public class Chebyshev implements DistanceMetric {

	public double distance(List<Double> p1, List<Double> p2) 
	{
		double maxCoordiante = 0;
		for (int i = 0; i < p1.size(); i++) 
		{
			double temp = Math.abs(p1.get(i) - p2.get(i));
			if(temp > maxCoordiante) 
			{
				maxCoordiante = temp;
			}
		}
		return maxCoordiante;
	}
	
	public static void main(String[]args)
	{
		System.out.println("The Chebyshev has been sucessfully executes");
	}
}