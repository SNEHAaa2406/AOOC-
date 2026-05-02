import java.io.*;
public class ReadFile{
public static void main(String[] args){
try{
FileInputStream f=new FileInputStream("C:\\Users\\HP\\Desktop\\sample.txt");
int i;
while((i=f.read())!=-1){
System.out.print((char)i);
}
f.close();
}catch(Exception e){
System.out.println(e);
}
}
}