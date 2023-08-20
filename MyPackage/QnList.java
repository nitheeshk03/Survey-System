package MyPackage;
import java.util.*;
public class QnList
{
  static final ArrayList<poll> al=new ArrayList<poll>();
  
  public void addQues(int ch,String quest,String A,String B,String C)
  {
    if(ch==1)
    {
      poll q1=new poll(quest,A,B,C);
      al.add(0,q1);
    }
    if(ch==2)
    {
      poll q2=new poll(quest,A,B,C);
      al.add(1,q2);
    }
    if(ch==3)
    {
      poll q3=new poll(quest,A,B,C);
      al.add(2,q3);
    }
    if(ch==4)
    {
      poll q4=new poll(quest,A,B,C);
      al.add(3,q4);
    }
    if(ch==5)
    {
      poll q5=new poll(quest,A,B,C);
      al.add(4,q5);
    }
  }
  public poll getObj(int c)
  {
    return al.get(c-1);
  }
}