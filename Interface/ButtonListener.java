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

   public void actionPerformed(ActionEvent event) {
       // The listener method accesses the account variable
       // from the surrounding block
       double result = 0;
       if (this.metric.equals("Maximum")) {
           result = Data.max(objects);
       } else if (this.metric.equals("Minimum")) {
           result = Data.min(objects);
       } else if (this.metric.equals("Average")) {
          result = Data.average(objects);
      }
      if (objects[0].getClass().getSimpleName().equals("BankAccount")) {
          System.out.println(this.metric + " Account Balance is " + result);
      } else if (objects[0].getClass().getSimpleName().equals("Country")) {
          System.out.println(this.metric + " Country Area is " + result);
      } else if (objects[0].getClass().getSimpleName().equals("Quiz")) {
          System.out.println(this.metric + " Quiz Score is " + result);
      }
   }
}
