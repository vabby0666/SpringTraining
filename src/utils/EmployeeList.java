package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class EmployeeList {
	
	public static void main(String args[])
	{
		
		ArrayList<employee> items=new ArrayList<>();
		items.add(new employee("bbb",124,2000));
		items.add(new employee("sbb",124,2000));
		items.add(new employee("gbb",124,2000));
		Collections.sort(items, new SortByName());
		//items.sort(new SortByName()); //both works
		for (employee employee : items) {
			System.out.println(employee.getName());
		}
	}
}
