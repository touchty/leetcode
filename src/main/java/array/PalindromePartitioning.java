package array;

import javafx.beans.binding.StringBinding;
import linkedList.PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                /*if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));*/

                currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s  = "aab";

        PalindromePartitioning p = new PalindromePartitioning();

        List<List<String>> res = p.partition(s);

        for (List<String> l : res) {
            System.out.println(l.size());
            System.out.println(l);
            StringBuilder builder = new StringBuilder();
            for (String str : l){
                builder.append(str).append("-");
            }
            if (builder.length() > 0)
                builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.toString());
        }
    }
}
