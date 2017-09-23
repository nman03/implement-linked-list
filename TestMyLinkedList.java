package implLinkedList;

public class TestMyLinkedList {

	public static void main(String[] args) {
		
		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add("America");
		System.out.println(list);

		list.add(0, "Canada");
		System.out.println(list);
		
		list.add("Russia");
		System.out.println(list);
		
		list.add("France");
		System.out.println(list);
		
		list.add(2, "Germany");
		System.out.println(list);
		
		list.add(5, "Norway");
		System.out.println(list);
		
		System.out.println("Removed Canada? " + list.remove("Canada"));
		System.out.println(list);
		
		System.out.println("Removed Norway? " + list.remove("Norway"));
		System.out.println(list);
		
		list.add("America");
		System.out.println(list);
		
		System.out.println("Contains Germany? " + list.contains("Germany"));
		System.out.println("Contains Norway? " + list.contains("Norway"));
		
		System.out.println("Index 2: "+ list.get(2));
		System.out.println("First index of America: " + list.indexOf("America"));
		System.out.println("Last index of America: " + list.lastIndexOf("America"));
		
		System.out.println("IsEmpty? " + list.isEmpty());
		
		System.out.print("Return Index 0: " + list.set(0, "Murrica") + " and replace with 'Murrica': ");
		System.out.println(list);
		
		System.out.println("Size: " + list.size());
		System.out.println("Clear!");
		list.clear();
		System.out.println(list);
		System.out.println("Size: " + list.size());
		
	}

}
