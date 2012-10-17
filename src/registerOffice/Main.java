package registerOffice;

import java.sql.SQLPermission;

import registerOffice.businessObjects.persons.*;
import registerOffice.management.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PersonManager mgr = new PersonManager();
		
		mgr.save(new Person("a","1"));
		mgr.save(new Person("b","2"));
		mgr.save(new Person("c","3"));
		mgr.save(new Person("d","4"));
		mgr.save(new Person("e","5"));
		
		for(Person p : mgr.getAll())
		{
			System.out.println(p.getName());
		}
		
		Condition<Person> condition= new GetByNameCondition("b");
		condition.setCondition(new Condition<Person>()
		{

			@Override
			protected boolean check(Person obj) {
				// TODO Auto-generated method stub
				return obj.getPesel().equals("2");
			}
			
		});
		
		Person result = mgr.get(condition);
		
		System.out.println(result.getName()+" "+result.getPesel());
	}

}
