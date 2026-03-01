//5.1.3


import java.util.*;
public class TwoSumHashMap {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] h=new int[size];
		for (int i=0;i<size;i++){
			h[i]=s.nextInt();
		}
		int target=s.nextInt();

		int[] result=twosum(h,target);

		if(result.length==2){
			System.out.println("Indices: "+result[0]+" "+result[1]);
		}
		else{
			System.out.println("No pair found");
		}
	}
	public static int[] twosum(int[] nums,int target){
		HashMap<Integer,Integer> h=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int complement=target-nums[i];
			if(h.containsKey(complement)){
				return new int[]{h.get(complement),i};
			}
			h.put(nums[i],i);
		}
		return new int[]{};
	}
}