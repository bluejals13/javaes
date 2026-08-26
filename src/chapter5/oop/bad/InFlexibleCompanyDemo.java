package chapter5.oop.bad;

public class InFlexibleCompanyDemo {
    public static void main(String[] args) {
        
    	//Employee emp = new Employee();
    	Employee emp1 = new MereClerk("철수", 100);
    	Employee emp2 = new MereClerk("영희", 100);
    	Employee emp3 = new Manager("홍길동", 200, "인사부");
    	
    	System.out.println(emp3.getName());
   		System.out.println(emp3.getSalary());
   		
   		Manager mgr = (Manager)emp3;
   		System.out.println(mgr.getDeptName());
   		
   		Manager emp4 = new Manager("둘리", 200, "개발부");
   		System.out.println(emp4.getName());
   		System.out.println(emp4.getSalary());
   		System.out.println(emp4.getDeptName());
   		
        MereClerk mereClerk1 = new MereClerk("철수", 100);
        MereClerk mereClerk2 = new MereClerk("영희", 100);
        Manager manager = new Manager("홍길동", 200);

        
        
        System.out.println("현재 월급입니다.");
        
        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");

        System.out.println("");
        
        
        System.out.println("올린 후의 월급입니다.");
        
        mereClerk1.manageSalary(10);
        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
        
        mereClerk2.manageSalary(10);
        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
        
        manager.manageSalary(10);
        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");
        
   }
}

