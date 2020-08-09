import java.util.Scanner;

class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix="ascompany.com";
	
	//constructor to recieve first name and last name
	public Email(String firstName , String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	
		
		//call a method asking for the department - return a department
		this.department=setDepartment();

		
		//call a method that returns a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your password is : "+this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	
	}
	
	//Ask for the Deapartment
	public String setDepartment() {
		System.out.print("New Worker : "+firstName+" "+lastName+".\nDepartment Codes : \n1 for sales\n2 for development\n3 for accounting\n4 for none\nEnter Department Code : ");
		Scanner in=new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice==1) {return "sales";}
		else if(depChoice==2) { return "development";}
		else if(depChoice==3) { return "accounting";}
		else {return " ";}
		
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int ran=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(ran);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	
	//Change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password;}
	
	public String showInfo() {
		return "DISPLAY NAME : "+firstName+" "+lastName+"\nCOMPANY EMAIL : "+email+"\nMAILBOX CAPACITY : "+mailboxCapacity+"mb";
	}
}
public class Main {

	public static void main(String[] args) {
		Email em1=new Email("Annu","Singh");
		
		System.out.println(em1.showInfo());

	}

}
