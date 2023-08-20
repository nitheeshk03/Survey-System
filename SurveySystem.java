//import required classes and packages  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;
import MyPackage.QnList;

class PasswordMismatchException extends Exception
{
  PasswordMismatchException()
  {
    Handler h=new Handler();
    h.setSize(300,70);
    h.setVisible(true);
  }
}
class Handler extends JFrame
{
  JPanel newPanel;
  JLabel msg;
  Handler()
  {
    setDefaultCloseOperation(javax.swing. WindowConstants.DISPOSE_ON_CLOSE);
    msg= new JLabel();
    msg.setText("Incorrect Username or Password");
    newPanel=new JPanel();
    newPanel.add(msg);
    add(newPanel, BorderLayout.CENTER);
  }
}
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener
{  
    //initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    CreateLoginForm()  
    {     
        setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)   //pass action listener as a parameter  
    {  
      String userValue = textField1.getText();        //get user entered username from the textField1  
      String passValue = textField2.getText();        //get user entered pasword from the textField2  
      try
      {  
        //can use file concept to load the user names and password to check whether the credentials are authentic or not  
        if (userValue.equals("admin@gmail.com") && passValue.equals("admin")) 
        {  //if authentic, navigate user to a new page  
            this.dispose();
            //create instance of the NewPage  
            NewPage1 page = new NewPage1();  
              
            //make page visible to the user  
            page.setVisible(true);  
              
        }
        else if (userValue.equals("user1@gmail.com") && passValue.equals("user1") || userValue.equals("user2@gmail.com") && passValue.equals("user2") || userValue.equals("user3@gmail.com") && passValue.equals("user3")|| userValue.equals("user4@gmail.com") && passValue.equals("user4")|| userValue.equals("user5@gmail.com") && passValue.equals("user5"))
        {
          this.dispose();
          newpage1 page= new newpage1();
          page.setVisible(true);
        }
        else
          throw new PasswordMismatchException();
      }
        catch(PasswordMismatchException e){}
    }  
} 
//create NewPage class to create a new page on which user will navigate  
class NewPage1 extends JFrame implements ActionListener
{  
    JPanel newPanel,NewPanel;
    JButton b2,b3,logout;
    //constructor  
    NewPage1()  
    {  
        setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);  
        setTitle("DASHBOARD");  
        setSize(400, 200);  
        b2=new JButton("Create Poll");
        b3=new JButton("View Results");

        NewPanel=new JPanel();
        logout=new JButton("logout");
        NewPanel.add(logout);
        add(NewPanel,BorderLayout.EAST);

        newPanel = new JPanel(new GridLayout(1,1));
        newPanel.add(b2);
        newPanel.add(b3);
        add(newPanel, BorderLayout.CENTER); 
        b2.addActionListener(this);
        b3.addActionListener(this);
        logout.addActionListener(this);
    } 
   public void actionPerformed(ActionEvent ae)
   {
     if(ae.getSource()==b2)
     {
        NewPage2 page = new NewPage2();
        page.setVisible(true); 
     }
     else if(ae.getSource()==b3)
     {
       NewPage3 page = new NewPage3();
       page.setVisible(true);
     }
     else
     {
       this.dispose();
       CreateLoginForm form = new CreateLoginForm();  
       form.setSize(300,100);  //set size of the frame  
       form.setVisible(true);
     }
   } 
}
class NewPage2 extends JFrame implements ActionListener
{
  JPanel newPanel,NewPanel;
  JButton q1,q2,q3,q4,q5,goback;
  NewPage2()
  {
    setDefaultCloseOperation(javax.swing.  WindowConstants.DISPOSE_ON_CLOSE);  
    setTitle("Question Pallete");
    setSize(400,200);

    q1=new JButton("Question 1");
    q2=new JButton("Question 2");
    q3=new JButton("Question 3");
    q4=new JButton("Question 4");
    q5=new JButton("Question 5");

    newPanel = new JPanel(new GridLayout(5,1));
    q1.addActionListener(this);
    newPanel.add(q1);
    q2.addActionListener(this);
    newPanel.add(q2);
    q3.addActionListener(this);
    newPanel.add(q3);
    q4.addActionListener(this);
    newPanel.add(q4);
    q5.addActionListener(this);
    newPanel.add(q5);
    add(newPanel, BorderLayout.CENTER);

    NewPanel=new JPanel();
    goback=new JButton("Back");
    NewPanel.add(goback);
    goback.addActionListener(this);
    add(NewPanel,BorderLayout.WEST);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==q1)
    {
      QuestionPage page=new QuestionPage(1);
      page.setVisible(true);
    }
    else if(ae.getSource()==q2)
    {
      QuestionPage page=new QuestionPage(2);
      page.setVisible(true);
    }
    else if(ae.getSource()==q3)
    {
      QuestionPage page=new QuestionPage(3);
      page.setVisible(true);
    }
    else if(ae.getSource()==q4)
    {
      QuestionPage page=new QuestionPage(4);
      page.setVisible(true);
    }
    else if(ae.getSource()==q5)
    {
      QuestionPage page=new QuestionPage(5);
      page.setVisible(true);
    }
    else
      this.dispose();
  }
}
class QuestionPage extends JFrame implements ActionListener
{
  int choice;
  JPanel newPanel;
  JLabel question,A,B,C;
  JTextField opta,optb,optc,qn;
  JButton b4;
  QuestionPage(int ch)
  {
    choice=ch;
    setDefaultCloseOperation(javax.swing.  WindowConstants.DISPOSE_ON_CLOSE);  
    setTitle("Set Question");
    setSize(400,300);

    question = new JLabel();  
    question.setText("Question");
    qn = new JTextField(40);

    A = new JLabel();  
    A.setText("Option A");
    opta = new JTextField(40);

    B = new JLabel();  
    B.setText("Option B");
    optb = new JTextField(40);

    C = new JLabel();  
    C.setText("Option C");
    optc = new JTextField(40);
    
    newPanel = new JPanel(new GridLayout(5, 2));  
    newPanel.add(question);
    newPanel.add(qn);
    newPanel.add(A);
    newPanel.add(opta);
    newPanel.add(B);
    newPanel.add(optb);
    newPanel.add(C);
    newPanel.add(optc);
    b4=new JButton("Create");
    b4.addActionListener(this);
    newPanel.add(b4);
    add(newPanel, BorderLayout.CENTER);
  }
  public void actionPerformed(ActionEvent ae)
  {
    QnList q=new QnList();
    q.addQues(choice,qn.getText(),opta.getText(),optb.getText(),optc.getText());
    this.dispose();
  }
}
class NewPage3 extends JFrame implements ActionListener
{
  JPanel newPanel,NewPanel;
  JButton q1,q2,q3,q4,q5,goback;
  JLabel note;
  NewPage3()
  {
    setDefaultCloseOperation(javax.swing.  WindowConstants.DISPOSE_ON_CLOSE);  
    setTitle("Answer Pallete");
    setSize(400,300);

    q1=new JButton("Question 1");
    q2=new JButton("Question 2");
    q3=new JButton("Question 3");
    q4=new JButton("Question 4");
    q5=new JButton("Question 5");
    note = new JLabel();  
    note.setText("Select the question to view results");

    newPanel = new JPanel(new GridLayout(6,1));
    newPanel.add(note);
    q1.addActionListener(this);
    newPanel.add(q1);
    q2.addActionListener(this);
    newPanel.add(q2);
    q3.addActionListener(this);
    newPanel.add(q3);
    q4.addActionListener(this);
    newPanel.add(q4);
    q5.addActionListener(this);
    newPanel.add(q5);
    add(newPanel, BorderLayout.CENTER);

    NewPanel=new JPanel();
    goback=new JButton("Back");
    NewPanel.add(goback);
    goback.addActionListener(this);
    add(NewPanel,BorderLayout.WEST);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==q1)
    {
      JFrame frame = new JFrame();
      frame.setSize(350, 300);
      setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new Bargraph(1,"Question 1"));
      frame.setVisible(true);
    }
    else if(ae.getSource()==q2)
    {
      JFrame frame = new JFrame();
      frame.setSize(350, 300);
      setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new Bargraph(2,"Question 2"));
      frame.setVisible(true);
    }
    else if(ae.getSource()==q3)
    {
      JFrame frame = new JFrame();
      frame.setSize(350, 300);
      setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new Bargraph(3,"Question 3"));
      frame.setVisible(true);
    }
    else if(ae.getSource()==q4)
    {
      JFrame frame = new JFrame();
      frame.setSize(350, 300);
      setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new Bargraph(4,"Question 4"));
      frame.setVisible(true);
    }
    else if(ae.getSource()==q5)
    {
      JFrame frame = new JFrame();
      frame.setSize(350, 300);
      setDefaultCloseOperation(javax.swing.  
        WindowConstants.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new Bargraph(5,"Question 5"));
      frame.setVisible(true);
    }
    else
      this.dispose();
  }
}

class Bargraph extends JPanel 
{
  int choice;
  double value[];
  String options[], title;

  public Bargraph(int ch,String t) 
  {
    choice=ch;
    value= new double[3];
    options = new String[3];

    QnList q= new QnList();
    value[0] = q.getObj(choice).getA();
    options[0] = q.getObj(choice).getOptA();

    value[1] = q.getObj(choice).getB();
    options[1] = q.getObj(choice).getOptB();

    value[2] = q.getObj(choice).getC();
    options[2] = q.getObj(choice).getOptC();

    title=t; 
  }
  public void paintComponent(Graphics graphics) 
  {
    super.paintComponent(graphics);
    if (value == null || value.length == 0)
    return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < value.length; i++) 
    {
      if (minValue > value[i])
        minValue = value[i];
      if (maxValue < value[i])
        maxValue = value[i];
    }
    Dimension dim = getSize();
    int clientWidth = dim.width;
    int clientHeight = dim.height;
    int barWidth = clientWidth / value.length;
    Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
    FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
    Font labelFont = new Font("Book Antiqua", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
    int titleWidth = titleFontMetrics.stringWidth(title);
    int q = titleFontMetrics.getAscent();
    int p = (clientWidth - titleWidth) / 2;
    graphics.setFont(titleFont);
    graphics.drawString(title, p, q);
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    q = clientHeight - labelFontMetrics.getDescent();
    graphics.setFont(labelFont);
    for (int j = 0; j < value.length; j++) 
    {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (value[j] * scale);
      if (value[j] >= 0)
        valueQ += (int) ((maxValue - value[j]) * scale);
      else 
      {
        valueQ += (int) (maxValue * scale);
        height = -height;
      }
      graphics.setColor(Color.blue);
      graphics.fillRect(valueP, valueQ, barWidth - 2, height);
      graphics.setColor(Color.black);
      graphics.drawRect(valueP, valueQ, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(options[j]);
      p = j * barWidth + (barWidth - labelWidth) / 2;
      graphics.drawString(options[j], p, q);
    }
  }
}

class newpage1 extends JFrame implements ActionListener
{
  JPanel newpanel;
  JButton b6,logout;
  newpage1()
  {
    setDefaultCloseOperation(javax.swing.  WindowConstants.DISPOSE_ON_CLOSE);  
    setTitle("Home");
    setSize(300,300);
    b6=new JButton("Poll");
    logout=new JButton("logout");
    newpanel=new JPanel();
    newpanel.add(b6);
    newpanel.add(logout);
    add(newpanel,BorderLayout.CENTER);
    b6.addActionListener(this);
    logout.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b6)
    {
      newpage2 page= new newpage2();
      page.setVisible(true);
    }
    else
    {
      this.dispose();
      CreateLoginForm form = new CreateLoginForm();  
      form.setSize(300,100);  //set size of the frame  
      form.setVisible(true);
    }
  }
}
class newpage2 extends JFrame implements ActionListener
{
  JComboBox<String> cb1,cb2,cb3,cb4,cb5;
  JLabel question,qn1,qn2,qn3,qn4,qn5;
  JButton b1;
  JPanel newpanel,NewPanel;
  newpage2()
  {
    setDefaultCloseOperation(javax.swing.  WindowConstants.DISPOSE_ON_CLOSE);  
    setTitle("Polling");
    setSize(600,300);

    String arr1[]=new String[3];
    String arr2[]=new String[3];
    String arr3[]=new String[3];
    String arr4[]=new String[3];
    String arr5[]=new String[3];
    QnList q=new QnList();

    //question = new JLabel();  
    //question.setText("Question : ");
    qn1=new JLabel(q.getObj(1).getQues());
    arr1[0]=q.getObj(1).getOptA(); 
    arr1[1]=q.getObj(1).getOptB(); 
    arr1[2]=q.getObj(1).getOptC();
    qn2=new JLabel(q.getObj(2).getQues());
    arr2[0]=q.getObj(2).getOptA(); 
    arr2[1]=q.getObj(2).getOptB(); 
    arr2[2]=q.getObj(2).getOptC();
    qn3=new JLabel(q.getObj(3).getQues());
    arr3[0]=q.getObj(3).getOptA(); 
    arr3[1]=q.getObj(3).getOptB(); 
    arr3[2]=q.getObj(3).getOptC();
    qn4=new JLabel(q.getObj(4).getQues());
    arr4[0]=q.getObj(4).getOptA(); 
    arr4[1]=q.getObj(4).getOptB(); 
    arr4[2]=q.getObj(4).getOptC();
    qn5=new JLabel(q.getObj(5).getQues());
    arr5[0]=q.getObj(5).getOptA(); 
    arr5[1]=q.getObj(5).getOptB(); 
    arr5[2]=q.getObj(5).getOptC();

    cb1=new JComboBox<String>(arr1);
    cb2=new JComboBox<String>(arr2);
    cb3=new JComboBox<String>(arr3);
    cb4=new JComboBox<String>(arr4);
    cb5=new JComboBox<String>(arr5);

    newpanel= new JPanel(new GridLayout(5, 2));
    newpanel.add(qn1);
    newpanel.add(cb1);
    newpanel.add(qn2);
    newpanel.add(cb2);
    newpanel.add(qn3);
    newpanel.add(cb3);
    newpanel.add(qn4);
    newpanel.add(cb4);
    newpanel.add(qn5);
    newpanel.add(cb5);
    add(newpanel, BorderLayout.CENTER);

    NewPanel=new JPanel();
    b1=new JButton("Vote");
    b1.addActionListener(this);
    NewPanel.add(b1);
    add(NewPanel, BorderLayout.SOUTH);
    NewPanel.setLocation((NewPanel.getWidth()-NewPanel.getWidth())/2, 0);
  }
  public void actionPerformed(ActionEvent ae)
  {
    this.dispose();
    QnList q=new QnList();

    String x=String.valueOf(cb1.getSelectedItem());
    if(x.equals(q.getObj(1).getOptA()))
      q.getObj(1).addOptionA();
    else if(x.equals(q.getObj(1).getOptB()))
      q.getObj(1).addOptionB();
    else
      q.getObj(1).addOptionC();
  
    String y=String.valueOf(cb2.getSelectedItem());
    if(y.equals(q.getObj(2).getOptA()))
      q.getObj(2).addOptionA();
    else if(y.equals(q.getObj(2).getOptB()))
      q.getObj(2).addOptionB();
    else
      q.getObj(2).addOptionC();

    String z=String.valueOf(cb3.getSelectedItem());
    if(z.equals(q.getObj(3).getOptA()))
      q.getObj(3).addOptionA();
    else if(z.equals(q.getObj(3).getOptB()))
      q.getObj(3).addOptionB();
    else
      q.getObj(3).addOptionC();

    String w=String.valueOf(cb4.getSelectedItem());
    if(w.equals(q.getObj(4).getOptA()))
      q.getObj(4).addOptionA();
    else if(w.equals(q.getObj(4).getOptB()))
      q.getObj(4).addOptionB();
    else
      q.getObj(4).addOptionC();

    String u=String.valueOf(cb5.getSelectedItem());
    if(u.equals(q.getObj(5).getOptA()))
      q.getObj(5).addOptionA();
    else if(u.equals(q.getObj(5).getOptB()))
      q.getObj(5).addOptionB();
    else
      q.getObj(5).addOptionC();
  }
}
//create the main class  
class SurveySystem  
{  
  //main() method start  
  public static void main(String [] args)  
  {  
    //create instance of the CreateLoginForm  
    CreateLoginForm form = new CreateLoginForm();  
    form.setSize(300,100);  //set size of the frame  
    form.setVisible(true);  //make form visible to the user 
  }  
} 