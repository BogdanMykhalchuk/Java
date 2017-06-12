package Test.Java_8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Vasya", 20));
		personList.add(new Person("Petro", 50));
		personList.add(new Person("Petro", 30));
		personList.add(new Person("Ivan", 25));
		personList.add(new Person("Alexander", 17));
		personList.add(new Person("Mykola", 18));

		// sort by age ascending
		personList.sort(Comparator.comparing(Person::getAge));

//	    personList.sort((p1, p2) -> p1.getAge().compareTo(p2.getAge())); might be done in this way, but Comparator.comparing is preferable
		System.out.println(personList);

		// sort by name descending
		personList.sort(Comparator.comparing(Person::getName).reversed());
		System.out.println(personList);

		// sort by name and then by age

		personList.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		System.out.println(personList);

		// get person with max age
		Person personWithMaxAge = personList.stream().max(Comparator.comparing(Person::getAge)).get();
		System.out.println(personWithMaxAge);

		// get person with the shortest name
		Person personWithTheShortestName = personList.stream().min(Comparator.comparingInt(p -> p.getName().length())).get();
		System.out.println(personWithTheShortestName);

		// get average age of all adult(age >= 18) persons in the list
		Double avarageAgeOfAdultPersons = personList.stream().filter(p -> p.getAge() >= 18).mapToInt(Person::getAge).average().getAsDouble();
		System.out.println(avarageAgeOfAdultPersons);

		// get new list without adult persons
		List<Person> youngPersons = personList.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
		System.out.println(youngPersons);
	}


	static class Person {
		private String name;
		private Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Integer getAge() {
			return age;
		}


		public void setAge(Integer age) {
			this.age = age;
		}


		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}
}