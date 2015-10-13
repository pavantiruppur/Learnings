package com.test.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EmployeeLink {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _count;
		_count = Integer.parseInt(in.nextLine());

		OutputCommonManager(_count, in);

	}
	
	static void OutputCommonManager(int count, Scanner in) {
		String firstSelected = in.nextLine();
		String secondSelected = in.nextLine();
		
		Map<String, Employee> employeeMap = new HashMap<String, Employee>();
		employeeMap.put(firstSelected, new Employee(firstSelected));
		employeeMap.put(secondSelected, new Employee(secondSelected));
		
		while(employeeMap.size() < count){
			String[] names = in.nextLine().split(" ");
			Employee emp1 = employeeMap.get(names[0]);
			if(emp1 == null){
				emp1 = new Employee(names[0]);
				employeeMap.put(names[0], emp1);
			}
			Employee emp2 = employeeMap.get(names[1]);
			if(emp2 == null){
				emp2 = new Employee(names[1]);
				employeeMap.put(names[1], emp2);
			}
			
			emp1.getManagingLine().add(names[1]);
			emp2.setManagerName(names[0]);
		}
		List<String> list1 = getList(employeeMap, new ArrayList<String>(), firstSelected);
		List<String> list2 = getList(employeeMap, new ArrayList<String>(), secondSelected);

		Set<String> set = new HashSet<String>();
		
		for(String list : list1){
			if(list2.contains(list)){
				set.add(list);
			}
		}
		for(String mostSrcDestination : set){
			System.out.println(mostSrcDestination);
		}

		
		
    }
	
	public static List<String> getList(Map<String, Employee> employeeMap, List<String> list, String name){
		Employee emp = employeeMap.get(name);
		if(emp == null){
			return list;
		}
		if(emp.getManagerName() != null){
			list.add(emp.getManagerName());
		}
		return getList(employeeMap, list, emp.getManagerName());
	}
	
	static class Employee{
		String name;
		String managerName;
		Set<String> managingLine = new HashSet<String>();
		
		public Employee(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public Set<String> getManagingLine() {
			return managingLine;
		}
		public void setManagingLine(Set<String> managingLine) {
			this.managingLine = managingLine;
		}
	}
}
