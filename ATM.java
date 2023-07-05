import java.util.*;
public class ATM  {
	public int actualPin=1234;
	private String cardNumber="12345678910";
	private String cardName="Nigam";
	private boolean blocked =false;
	private String balance="57891.23";
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	ATM atm=new ATM();
	System.out.print("Enter your card No:");
	String cardNo=sc.nextLine();
	//System.out.println(cardNo);
	//Account ac=new Account();
	if(cardNo.equals(atm.cardNumber)){
		  System.out.println("Welcome "+atm.cardName+"!!!");
		atm.processAfterValidCard(atm,sc);
	}else{
	System.out.println("Invalid Account Number");
	}
	
  }
  public void processAfterValidCard(ATM atm,Scanner sc){
	  
	System.out.print("Please enter your pin:");
	int pin=sc.nextInt();
	if(pin==atm.actualPin){
		atm.displayMenu(atm,sc);

	}else{
		System.out.println("Invalid Pin");
	}
  }
  public void displayMenu(ATM atm,Scanner sc){
	  System.out.println();
	  System.out.println("Menu");
	  System.out.println("1. Balance Enquiry");
	  System.out.println("2. Mini Statement");
	  System.out.println("3. PIN change");
	  System.out.println("4. Withdraw");
	  System.out.println("Exit");
	  System.out.println();
	  System.out.print("Please enter your choice:");
	  int choice=sc.nextInt();
	  System.out.println();
	  switch(choice){
		  case 1:
		  atm.balanceEnquiry(atm,sc);
		  break;
		  case 2:
		  atm.miniStatement(atm,sc);
		  break;
		  case 3:
		  atm.pinChange(atm,sc);
		  break;
		  case 4:
		  atm.withdraw(atm,sc);
		  break;
		  case 5:
		  atm.Exit();
		  break;
		  default:
		  System.out.println("Invalid choice");
		  break;
	  }
  }
  public void balanceEnquiry(ATM atm,Scanner sc){
	 
	  System.out.println("Your balance is:"+atm.balance);
	 
	  atm.displayMenu(atm,sc);
  }
  public void miniStatement(ATM atm,Scanner sc){ 
  System.out.println("Your previous five transactions are given below:");
	  System.out.println();
	  System.out.println("You transferred Rs500 in 5th April");
	  System.out.println("You received Rs1000 in 10th April");
	  System.out.println("You received Rs500 in 12th April");
	  System.out.println("You transferred Rs200 in 15th April");
	  System.out.println("You received Rs2000 in 20th April");
	  atm.displayMenu(atm,sc);
  }
  public void pinChange(ATM atm,Scanner sc){
	  System.out.print("Enter the old PIN:");
	  int oldPin=sc.nextInt();
	  System.out.print("Enter the new PIN:");
	  int newPin=sc.nextInt();
	  System.out.print("Enter the new PIN again:");
	  int newPinMatch=sc.nextInt();
	  if(atm.actualPin==oldPin){
		  if(newPin==newPinMatch){
			  System.out.println("Your pin has been changed succesfully");
		  }
	  }else{
		  System.out.println("Old pin is wrong");
	  }
  }
  public void withdraw(ATM atm,Scanner sc){
	  System.out.print("Enter the amount you want to withdraw:");
	  sc.nextLine();
	  String  withdrawAmt=sc.nextLine();	
	  System.out.println("You have sucessfully withdrawn Rs. "+withdrawAmt);
	  float adjustedBalance=Float.parseFloat(atm.balance)-Float.parseFloat(withdrawAmt);
	  System.out.println("The new balance after withdraw is:"+adjustedBalance);
	  atm.displayMenu(atm,sc);
	  
  }
  public void Exit(){
	  System.exit(0);
  }
    
}