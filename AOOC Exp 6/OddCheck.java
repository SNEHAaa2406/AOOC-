class OddNumberException extends Exception{
public OddNumberException(String message){
super(message);
}
}

public class OddCheck{
static void checkNumber(int num) throws OddNumberException{
if(num%2!=0){
throw new OddNumberException("Number is odd");
}else{
System.out.println("Number is even");
}
}
public static void main(String[] args){
try{
checkNumber(5);
}catch(Exception e){
System.out.println("Error: "+e.getMessage());
}
}
}