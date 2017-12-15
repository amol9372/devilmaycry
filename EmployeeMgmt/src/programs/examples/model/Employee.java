package programs.examples.model;

public class Employee extends Thread implements Comparable<Employee>
{
   private int id;
   private String firstName;
   private String lastName;
   private Subject subject;
  
   public static void main(String args[]){
	   Employee e1 = new Employee();
	   e1.start();
   }
   public void run(){
	 System.out.println("Threan name is : "+Thread.currentThread().getName());   
   }
   
 	@Override
	public int compareTo(Employee e) {
		if(this.firstName.compareToIgnoreCase(e.firstName) == 0)
			return this.lastName.compareToIgnoreCase(e.lastName);
		else 
			return this.firstName.compareToIgnoreCase(e.firstName);
	}
 	public Employee(int id,String firstName,String lastName){
 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.id = id;
 	}
 	public Employee(){}
	
 	public boolean equals(Object o){
 		if (this.getId() == id)
 			return true;
 		else 
 			return false;
 	}
 	
//    public int getId() {
//		return id;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject
				+ "]";
	}
   
}

enum Subject
{
	MATHS,PHYSICS,CHEMISTRY,ENGLISH;
}