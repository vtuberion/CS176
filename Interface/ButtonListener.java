package Interface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ButtonListener implements ActionListener
{
   private Measurable[] objects;
   private String metric;

   public ButtonListener(Measurable[] objects,String metric)
   {
      this.objects = objects;
      this.metric = metric;
   }

   public void actionPerformed(ActionEvent event)
   {
      // The listener method accesses the account variable
      // from the surrounding block
	  double result = 0;
	  
	   if (metric=="Maximum")
	   {result = Data.max(objects);}
	   if (metric=="Minimum")
	   {result = Data.min(objects);}
	   if (metric=="Average") 
	   {result = Data.average(objects);}
      if (objects[0].getClass().getName().equals("BankAccount")) 
      {System.out.println(metric + " Account Balance is "+result);}
      if (objects[0].getClass().getName().equals("Country")) 
      {System.out.println(metric + " Country Area is "+result);}
      if (objects[0].getClass().getName().equals("Quiz")) 
      {System.out.println(metric + " Quiz Score is "+result);}
      
   }
}
