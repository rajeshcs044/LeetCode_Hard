package com.rajesh.practice.hard;

public class TrappingRainWater
{
    public static int trap(int[] height)
    {
        if (height.length < 3)
        {
            return 0;
        }

        int globalMax = 0;
        int globalMaxIndex = 0;
        for (int i = 0; i < height.length; i++)
        {
            if (height[i] > globalMax)
            {
                globalMax = height[i];
                globalMaxIndex = i;
            }
        }

        int count = 0;
        int localMax = height[0];
        for (int i = 1; i < globalMaxIndex; i++)
        {
            if (height[i] > localMax)
            {
                localMax = height[i];
            }
            else
            {
                count = count + (localMax - height[i]);
            }
        }

        localMax = height[height.length - 1];
        for (int i = height.length - 2; i > globalMaxIndex; i--)
        {
            if (height[i] > localMax)
            {
                localMax = height[i];
            }
            else
            {
                count = count + (localMax - height[i]);
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Result: " + trap(A));
    }
}
