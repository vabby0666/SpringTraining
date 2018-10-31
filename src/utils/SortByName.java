package utils;

import java.util.Comparator;

public class SortByName implements Comparator<employee> {

	@Override
	public int compare(employee o1, employee o2) {
		int diff=o1.getName().compareTo(o2.getName());
		return diff;
	}
	
}
