import java.io.*;
public class FileAnalysis{
public static void main(String[] args){
try{
FileInputStream f=new FileInputStream("sample.txt");
int i,vowels=0,words=1,aCount=0;
char ch;
while((i=f.read())!=-1){
ch=(char)i;
if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
vowels++;
}
if(ch=='a'||ch=='A'){
aCount++;
}
if(ch==' '||ch=='\n'){
words++;
}
}
f.close();
System.out.println("Vowels: "+vowels);
System.out.println("Words: "+words);
System.out.println("a count: "+aCount);
}catch(Exception e){
System.out.println(e);
}
}
}