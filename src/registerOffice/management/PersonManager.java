package registerOffice.management;

import java.util.ArrayList;
import java.util.List;

import registerOffice.businessObjects.persons.Person;
import registerOffice.management.conditions.Condition;

public class PersonManager implements ManagerInterface<Person>{

	List<Person> persons= DatabaseContext.getPersons();
	
	@Override
	public Person get(Condition<Person> condition) {
		
		for(Person p: persons)
		{
			if(condition.checkCondition(p))
				return p;
		}
		
		return null;
	}

	@Override
	public List<Person> getAll(Condition<Person> condition) {
		
		List<Person> results=new ArrayList<Person>();
		for(Person p: persons)
		{
			if(condition.checkCondition(p))
				results.add(p);
		}
		return results;
	}

	@Override
	public boolean save(Person obj) {
		return persons.add(obj);
	}

	@Override
	public boolean delete(Person obj) {
		return persons.remove(obj);
	}

}
