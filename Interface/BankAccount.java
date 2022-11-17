package Interface;
/**
   A bank account has a balance that can be changed by
   deposits and withdrawals.
*/
public class BankAccount implements Measurable
{
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {
      balance = balance + amount;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }

   /**
      Adds interest to the bank account.
      @param rate The percentage rate of interest gained.
   */
   public void addInterest(double rate)
   {
      balance = balance + balance * rate / 100;
   }

   /**
    4 Computes the average of the measures of the given
    objects.
    5 @param objects an array of Measurable objects
    6 @return the average of the measures7 */

   public static double average(Measurable[] objects) {
      double sum = 0;
      for (Measurable obj : objects) {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0) {
         return sum / objects.length;
      } else { return 0; }
   }

   public double getMeasure(){
      return balance;
   }
}
