
/**
 https://leetcode.com/problems/excel-sheet-column-title/
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

        For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...

Input: 1
Output: "A"    */

时间 O （n）
空间 O （n）

0-25的int转换成char的A-Z，直接int cast成char (char) ('A' + cur)

class Solution {
    public String convertToTitle(int n) {
        String result = "";
        while(n != 0){
            int cur = (n-1) % 26;
            n = (n-1) / 26;
            result = (char) ('A' + cur) + result;
        }
        return result;
    }
}