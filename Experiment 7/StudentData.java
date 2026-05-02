import java.io.*;
import java.util.*;
public class StudentData{
public static void main(String[] args){
try{
Scanner sc=new Scanner(System.in);
System.out.print("Name: ");
String name=sc.nextLine();
System.out.print("Age: ");
int age=sc.nextInt();
System.out.print("Weight: ");
float weight=sc.nextFloat();
System.out.print("Height: ");
float height=sc.nextFloat();
sc.nextLine();
System.out.print("City: ");
String city=sc.nextLine();
System.out.print("Phone: ");
long phone=sc.nextLong();

FileOutputStream fos=new FileOutputStream("student.txt");
DataOutputStream dos=new DataOutputStream(fos);

dos.writeUTF(name);
dos.writeInt(age);
dos.writeFloat(weight);
dos.writeFloat(height);
dos.writeUTF(city);
dos.writeLong(phone);
dos.close();

FileInputStream fis=new FileInputStream("student.txt");
DataInputStream dis=new DataInputStream(fis);

System.out.println("Name: "+dis.readUTF());
System.out.println("Age: "+dis.readInt());
System.out.println("Weight: "+dis.readFloat());
System.out.println("Height: "+dis.readFloat());
System.out.println("City: "+dis.readUTF());
System.out.println("Phone: "+dis.readLong());
dis.close();

}catch(Exception e){
System.out.println(e);
}
}
}