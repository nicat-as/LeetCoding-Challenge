package leetCodingChallenge.may.week2.townJudge;

import java.util.HashMap;
import java.util.Map;
/*
* In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1.The town judge trusts nobody.
2.Everybody (except for the town judge) trusts the town judge.
3.There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
* */



//Accepted: 110 ms, 94.4 MB. I know, it's not best solution. But works :).
public class Solution {
    public static int findJudge(int N, int[][] trust) {
        //For 1 and 2 condition,(1) I created judge map for finding who trusts nobody.
        // And (2) created trust map for finding who posses all trust except himself.
        Map<Integer, Integer> judgeMap = new HashMap<>();
        Map<Integer, Integer> trustable = new HashMap<>();
        int judge = -1;
        for (int i = 0; i < trust.length; i++) {
            if (judgeMap.containsKey(trust[i][0])) {
                judgeMap.compute(trust[i][0], (k, v) -> v + 1);
            }
            judgeMap.putIfAbsent(trust[i][0], 1);
            judgeMap.putIfAbsent(trust[i][1], 0);

            if (trustable.containsKey(trust[i][1])) {
                trustable.compute(trust[i][1], (k, v) -> v + 1);
            }
            trustable.putIfAbsent(trust[i][1], 1);
            trustable.putIfAbsent(trust[i][0], 0);
        }
        for (int i = 1; i <= N; i++) {
            if (judgeMap.containsKey(i)) {
                if (judgeMap.get(i) == 0 && trustable.get(i) == N - 1) {
                    judge = i;
                }
            }
        }
        System.out.println(judgeMap);
        System.out.println("Trustable : " + trustable);
        return judge;
    }

    //These are just for testing
    public static void main(String[] args) {
        int judge = findJudge(4, new int[][]{
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        });
        int judge2 = findJudge(3, new int[][]{
                {1, 2}
                , {2, 3}
        });

        System.out.println(judge + " " + judge2);
    }
}
