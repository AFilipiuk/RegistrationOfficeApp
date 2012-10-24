package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import registerOffice.businessObjects.cars.Car;
import registerOffice.businessObjects.cars.PersonCar;
import registerOffice.businessObjects.cars.TruckCar;
import registerOffice.businessObjects.persons.*;
import registerOffice.management.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ManagerInterface<Person> mgr= new PersonManager();
		
		mgr.save(new Person("Adam","1234","Gdańsk"));
		mgr.save(new Person("Adam","12345","Elbląg"));
		mgr.save(new Person("Adam","12344","Gdańsk"));
		mgr.save(new Person("Adam","1234534","Gdynia"));
		mgr.save(new Person("Adam","1236544","Sopot"));
		mgr.save(new Person("Adam","12342","Sopot"));
		mgr.save(new Person("Adam","12344","Gdańsk"));
		mgr.save(new Person("Adam","12354","Gdynia"));
		
		Condition<Person> byname=new GetByNameCondition("Adam");
		Condition<Person> byaddress=new GetByAddressCondition("Sopot");
		Condition<Person> mainCondition=new Condition<Person>()
				{
					@Override
					protected boolean check(Person obj) {
						return true;
					}};
		
		byname.setCondition(byaddress);
		mainCondition.setCondition(byname);
		for(Person p:mgr.getAll(mainCondition))
		{
			System.out.println(p.getName()
					+" "
					+p.getAddress()
					+" "+ p.getPesel());
		}
		
	}

}
