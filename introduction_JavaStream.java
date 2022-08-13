import java.util.ArrayList;
import java.util.stream.Stream;

public class introduction_JavaStream {

	public static void main(String[] args) {
		regularCode();
		streamCode();
	}

	
	public static void regularCode() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Ali");
		names.add("Akbar");
		names.add("Junaid");
		names.add("Anwer");
		names.add("Saim");
		names.add("Soul");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}

		}
		System.out.println("Regular Code : "+count);
	}
	
	public static void streamCode() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ali");
		names.add("Akbar");
		names.add("Junaid");
		names.add("Anwer");
		names.add("Saim");
		names.add("Soul");
		
	Long  c=	names.stream().filter(s -> s.startsWith("A")).count();
				// names.stream()  : converting ArrayList into Stream
				// filter()      :  It is the intermediate operation creating new Stream
				//filter(s -> s.startsWith("A"))  : 's' will iterate in stream parallely
				//Count  : it is the terminal operation without this we will not getting any result
	System.out.println("Stream Filter: " +c);
	
	//We always do noyt have to have any collection to make a stream we can create it on run time like :
	Long  c1= Stream.of("Ali","Akbar", "Raj").filter(s -> 
	{
		s.startsWith("A");
		return false;
	}).count();
	System.out.println("Stream Filter: " +c1);
	
	// Print names having characters > 4 in array list:
//	names.stream().filter(s-> s.length() > 4).forEach(s -> System.out.println(s));
	
//	names.stream().filter(s->s.startsWith("A")).forEach(s-> System.out.println(s));
	//names.stream().forEach(s-> System.out.println(s));
	
	names.stream().filter(s-> s.length()>4).limit(1).forEach(s-> System.out.println(s));
	}
}
