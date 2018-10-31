package utils;
import java.util.ArrayList;
import java.util.Iterator;

public class samplearraylist {
	public static void  main(String args[])
	{
		ArrayList<Object> items=new ArrayList<>();
		items.add(456);
		items.add("MedPlus");
		items.add(null);
		items.add(56.6);
		items.add(456);
		System.out.println(items+" "+items.size());
		items.add("hyd");
		System.out.println(items+" "+items.size());
		items.remove("hyd");
		items.remove(new Integer(456));
		System.out.println(items+" "+items.size());
		Iterator<Object> itr=items.listIterator();
		while(itr.hasNext()) {
			Object obj= itr.next();
			if(obj instanceof Integer)
				System.out.println(obj);
		}
	}
}
