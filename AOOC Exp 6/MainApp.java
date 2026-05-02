public class MainApp{
public static void main(String[] args){
Calculator calc=new Calculator();
try{
int result=calc.divide(10,0);
System.out.println("Result: "+result);
}catch(DivisionException e){
System.out.println("Error: "+e.getMessage());
}
}
}