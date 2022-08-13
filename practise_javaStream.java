import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practise_javaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		practise_javaStream obj = new practise_javaStream();
		obj.javaStream();
		obj.streamMap();
	}

	public void javaStream() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Saif");
		names.add("Saim");
		names.add("Suleman");
		names.add("Salman");
		names.add("Haider");
		names.add("Haneef");

		//No. of records in array list.
		System.out.println("************************************");
		Long size=	names.stream().count();
		System.out.println(size);
		
		//Print all records		
		System.out.println("************************************");
		System.out.println("All Record: ");
		names.stream().forEach(s-> System.out.println(s));
		
		//Print records having char length >=4
		System.out.println("************************************");
		System.out.println("Names having char >= 4 : ");
		names.stream().filter(s-> s.length() >=4).forEach(s ->System.out.println(s ));

		//Print 1st record in the list
		System.out.println("************************************");
		System.out.println("1st Record of Array List :");
		names.stream().limit(1).forEach(s-> System.out.println(s));		
	}
	public void streamMap() {
		//map : it will map the stream coming from filter() operation into our
		//Print the name ends with a. Print in uppercase
		Stream.of("Aaliya", "Anamta", "Ali", "Alana").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
		.forEach(s-> System.out.println(s));
		System.out.println("************************************");
		//Print all names in lowercase
		Stream.of("Aaliya", "Anamta", "Ali", "Alana").map(s-> s.toLowerCase())
		.forEach(s-> System.out.println(s));
	
		//print names which have 1st letter as a with upercase and sorted.
		System.out.println("************************************");
	List<String>	list= Arrays.asList("azliya", "anamta", "laila", "alana");
		list.stream().filter(s-> s.startsWith("a")).sorted().map(s->s.toUpperCase())
		.forEach(s-> System.out.println(s));
		//print names in sorted manner.
		System.out.println("************************************");
		list.stream().sorted().forEach(s-> System.out.println(s));
		
		//Merge 2 lists then sort it 
		List<String>	list2= Arrays.asList("haider", "kamran", "star", "zee");
		System.out.println("************************************");
		Stream.concat(list.stream(), list2.stream()).sorted().forEach(s-> System.out.println(s));
		
		//Match check in the merge stream the required name is present or not.
		System.out.println("************************************");
		boolean decision = Stream.concat(list.stream(), list2.stream()).anyMatch(s->s.equalsIgnoreCase("star"));
		System.out.println(decision);

		//Collect : used to collect the result and convert it into new list
		System.out.println("************************************");
	List<String>	newList = Stream.of("Aaliya", "Anamta", "Ali", "Alana").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
		.collect(Collectors.toList());
	System.out.println(newList.get(0));
	
	
	//print 1st record with collect method.
	System.out.println("************************************");

 Stream.of("Aaliya", "Anamta", "Ali", "Alana").filter(s-> s.endsWith("a")).map(s-> s.toUpperCase())
	.limit(1).forEach(s-> System.out.println(s));
 
 List<Integer> numList = Arrays.asList(4,6,6,7,7,7,2,1,9,14,1,10);
 //print unique number from this array.
 //sort the array and print the 3rd record only
	System.out.println("************************************");
	 numList.stream().distinct().forEach(s-> System.out.println(s));
 	
	System.out.println("************************************");
	List<Integer>	sortedList = numList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedList.get(2));
	}
	
}

//Terminal Operations:
// count, limit, sorted.
// filter, map, stream.concat, anyMatch
//Filter:   Filter is nothing without terminal operation. To get subset of result from main page so that you can perform another
//operation on the result that filter gives you
