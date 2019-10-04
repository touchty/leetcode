package test;

import java.util.ArrayList;
import java.util.List;

public class FirstAppearingOnce {
    List<Character> list = new ArrayList<>();
    int[] count = new int[256];
    int index = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        count[ch]++;
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (index < list.size()) {
            if (count[list.get(index)] == 1) {
                char c = list.get(index);
                return (c);
            } else {
                index++;
            }
        }
        return '#';
    }
}
/*
int count[]=new int[256];
    //Insert one char from stringstream
    int index=1;
    public void Insert(char ch)
    {
        if(count[ch]==0){
          count[ch]=index++;
        }
        else{
            count[ch]=-1;
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){
                temp=count[i];
                ch=(char)i;
            }
        }
        return ch;
    }
 */
