package MyPackage;
public class poll
{
  String opta,optb,optc,qn;
  int a,b,c;
  poll(String quest,String A,String B,String C)
  {
    qn=quest;
    opta=A;
    optb=B;
    optc=C;
    a=0;
    b=0;
    c=0;
  }
  public String getQues()
  {
    return qn;
  }
  public String getOptA()
  {
    return opta;
  }
  public String getOptB()
  {
    return optb;
  }
  public String getOptC()
  {
    return optc;
  }
  public void addOptionA()
  {
    a++;
  }
  public void addOptionB()
  {
    b++;
  }
  public void addOptionC()
  {
    c++;
  }
  public int getA()
  {
    return a;
  }
  public int getB()
  {
    return b;
  }
  public int getC()
  {
    return c;
  }
}