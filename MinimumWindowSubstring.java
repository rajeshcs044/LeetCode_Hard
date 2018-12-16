package com.rajesh.practice.hard.newpack;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring
{
    public String minWindow(String s, String t)
    {
        if (t.length() > s.length())
        {
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray())
        {
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        int count = 0;
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        char[] sC = s.toCharArray();
        for (int right = 0; right < s.length(); right++)
        {
            if (map.containsKey(sC[right]))
            {
                map.put(sC[right], map.get(sC[right]) - 1);
                if (map.get(sC[right]) >= 0)
                {
                    count++;
                }

                while (count == t.length())
                {
                    if (right - left + 1 < minLen)
                    {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    if (map.containsKey(s.charAt(left)))
                    {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0)
                        {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if (minLen > s.length())
        {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}
