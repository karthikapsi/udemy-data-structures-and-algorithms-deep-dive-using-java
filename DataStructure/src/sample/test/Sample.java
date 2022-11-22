package sample.test;

import java.util.ArrayList;
import java.util.List;

public class Sample {

	
	public static void main(String[] args) {
		/*ISampleInterface i = new SampleInterface();
		i.getDetail();		
		i.getName();*/
		
		new Sample().getNum(3);
		
		//1, 11,121,
	}
	
	private  List<List<Integer>> getNum(int row){
		
		List<List<Integer>> rows = new ArrayList<>();

		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		rows.add(firstRow);
		
		for(int i=1;i<row;i++) {
		//	List<Integer> each = 
		}
		
		rows.add(firstRow);
		
		System.out.println(" list " + rows);
		
		return null;		
	}
	
}
