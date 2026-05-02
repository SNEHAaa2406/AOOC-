class LowBalanceException extends Exception{
public LowBalanceException(String message){
super(message);
}
}

class NegativeNumberException extends Exception{
public NegativeNumberException(String message){
super(message);
}
}

class BankAccount{
double balance;
BankAccount(double balance){
this.balance=balance;
}
void balanceEnquiry(){
System.out.println("Current Balance: "+balance);
}
void deposit(double amount) throws NegativeNumberException{
if(amount<0){
throw new NegativeNumberException("Cannot deposit negative amount");
}
balance+=amount;
System.out.println("Deposited: "+amount);
}
void withdraw(double amount) throws LowBalanceException,NegativeNumberException{
if(amount<0){
throw new NegativeNumberException("Cannot withdraw negative amount");
}
if(amount>balance){
throw new LowBalanceException("Insufficient balance");
}
balance-=amount;
System.out.println("Withdrawn: "+amount);
}
}

public class BankApp{
public static void main(String[] args){
BankAccount acc=new BankAccount(1000);
try{
acc.deposit(500);
acc.withdraw(200);
acc.withdraw(2000);
}catch(LowBalanceException | NegativeNumberException e){
System.out.println("Error: "+e.getMessage());
}
acc.balanceEnquiry();
}
}