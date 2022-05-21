package edu.umb.cs680.hw10;

import java.util.List;

public interface DistanceMetric {
	 public abstract double distance(List<Double> p1, List<Double> p2);
	 public static void main(String[]args)
		{
			System.out.println("The Distance metric has been sucessfully executes");
		}
}