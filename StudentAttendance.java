//5.1.1

import java.util.*;
class StudentAttendanceHash{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> map= new HashMap<>();
		int m = sc.nextInt();
		
		for(int i=0;i<m;i++){
			int p = sc.nextInt();
			int k = sc.nextInt();
			map.put(p,k);
			
		}
		int s = sc.nextInt();
		
		for(int i=0;i<s;i++){
			int w = sc.nextInt();
			if(map.containsKey(w)){
			System.out.println(map.get(w));
				}else{
				System.out.println("Record not found");
				break;
				}
		}

			
	}
}