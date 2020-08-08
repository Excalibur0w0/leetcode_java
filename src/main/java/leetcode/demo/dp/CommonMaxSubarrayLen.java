package leetcode.demo.dp;

import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CommonMaxSubarrayLen {
    public static void main(String[] args) {
        CommonMaxSubarrayLen maxSubarrayLen = new CommonMaxSubarrayLen();
        int result = maxSubarrayLen.findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7});

        System.out.println(result);
    }
    public int findLength(int[] A, int[] B) {
        List list = new LinkedList<>();
        getCommonSubArray(list, A, B, 0, 0);
        System.out.println(JSONObject.toJSONString(list));
        return 1;
    }

    public void getCommonSubArray(List<List<Integer>> subArray, int[] arr1, int[] arr2, int i, int j) {
        if (arr1.length <= 0 || arr2.length <= 0) {
            return;
        }
        if (i >= arr1.length || j >= arr2.length) {
            return;
        }
        List<Integer> member = new LinkedList<>();
        if (arr1[i] == arr2[j]) {
//            member.add()
        }
    }

    public List<String> getTextAllSubsequence(List<Integer> list) {
        List<List<Integer>> allSubsequence = new LinkedList<>();
        return null;
    }

//    public void addSubsequence(List<List<Integer>> allSeq, List<Integer> origin, List<Integer> target, )


}
