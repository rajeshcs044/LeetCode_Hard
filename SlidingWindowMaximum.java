package com.rajesh.practice.hard;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum
{
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        if (nums.length == 0)
        {
            return new int[0];
        }

        if (k == 1)
        {
            return nums;
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for (int i = 1; i < k - 1; i++)
        {
            if (list.get(0) < nums[i])
            {
                while (list.size() > 1 && nums[i] > list.get(1))
                {
                    list.remove(1);
                }
                list.set(0, nums[i]);
                continue;
            }
            for (int j = list.size() - 1; j >= 0; j--)
            {
                if (list.get(j) < nums[i])
                {
                    list.remove(j);
                }
                else
                {
                    if (list.size() < k)
                    {
                        list.add(nums[i]);
                        break;
                    }
                }
            }
        }

        int l = -1;
        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++)
        {
            if (i != k - 1 && (nums[i - k] == list.get(0)))
            {
                list.remove(0);
            }
            if (list.isEmpty())
            {
                list.add(nums[i]);
                continue;
            }
            if (list.get(0) < nums[i])
            {
                while (list.size() > 1 && nums[i] > list.get(1))
                {
                    list.remove(1);
                }
                list.set(0, nums[i]);
                l++;
                result[l] = list.get(0);
                continue;
            }
            for (int j = list.size() - 1; j >= 0; j--)
            {
                if (list.get(j) < nums[i])
                {
                    list.remove(j);
                }
                else
                {
                    if (list.size() < k)
                    {
                        list.add(nums[i]);
                        break;
                    }
                }
            }
            l++;
            result[l] = list.get(0);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] A = { -95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91, 91, 74, -28, 39, 90,
                -9, -72, -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63, 100, 59, -48, 43, 35, -49, 48, -36, -64,
                -13, -7, -29, 87, 34, 56, -39, -5, -27, -28, 10, -57, 100, -43, -98, 19, -59, 78, -28, -91, 67, 41, -64,
                76, 5, -58, -89, 83, 26, -7, -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46, 35, -23, 30, -51, 54,
                19, 30, 27, 80, 45, 22 };
        System.out.println("Result: " + maxSlidingWindow(A, 10));
    }
}
