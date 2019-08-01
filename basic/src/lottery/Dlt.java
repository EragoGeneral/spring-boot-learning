package lottery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Dlt {

	private static Integer MIN_NUM = 1;
	
	private static Integer MAX_RED = 35;
	
	private static Integer MAX_BLUE = 12;
	
	@SuppressWarnings("rawtypes")
	private static Set generateReds(Integer maxNum, Integer loopNum){
		Set<Integer> hitSet = new HashSet<>();
		List<Integer> reds = new ArrayList<>();
		for(int i = 1; i < maxNum + 1; i ++){
			reds.add(i);
		}
		
		int hitNum = 0;
		while(hitNum < loopNum){
			Random r = new Random();
			int curRed = r.nextInt((maxNum-hitNum) - MIN_NUM + 1) + MIN_NUM;
			hitSet.add(reds.get(curRed-1));
			//重排列表reds数组，将命中数后的元素往前移动 
			for(int j = curRed; j < reds.size(); j++){
				reds.set(j-1, reds.get(j));
			}
			//移除最后一个元素
			reds.remove(reds.size()-1);
			hitNum++;
		}
		
		return hitSet;
	}
	
	public static void main(String[] args) {
		Set<Integer> hitRed = generateReds(MAX_RED, 5);
		System.out.print("Red: ");
		for(Integer red : hitRed){
			System.out.print(red + ",");
		}
		
		Set<Integer> hitBlue = generateReds(MAX_BLUE, 2);
		System.out.print("\nBlue: ");
		for(Integer blue : hitBlue){
			System.out.print(blue + ",");
		}
	}
}
