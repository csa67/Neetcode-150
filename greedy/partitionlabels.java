package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionlabels {
    public List<Integer> getPartitionSizes(String str){
        int[] lastOccurences = new int[26];
        int n=str.length();
        for(int i=n-1;i>=0;i--){
            char ch=str.charAt(i);
            lastOccurences[ch-'a'] = Math.max(lastOccurences[ch-'a'],i);
        }

        int[] firstOccurences = new int[26];
        Arrays.fill(firstOccurences,-1);

        List<Integer> sizes = new ArrayList<>();

        int partitionStart = 0, partitionEnd = 0;

        for(int i=0; i<str.length();i++){
            
            int ch=str.charAt(i)-'a';
            if(firstOccurences[ch] == -1){
                firstOccurences[ch] = i;
            }

            if(partitionEnd < firstOccurences[ch]){
                sizes.add(partitionEnd - partitionStart+1);
                partitionStart = i+1;
                partitionEnd=i+1;
            }

            partitionEnd = Math.max(partitionEnd, lastOccurences[ch]);
        }

        if(partitionEnd -partitionStart+1 > 0) sizes.add(partitionEnd -partitionStart+1);

        return sizes;
    }
}
