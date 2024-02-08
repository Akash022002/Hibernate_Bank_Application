package ServiceImpl;
import Services.RBIBank;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Configure.HibernateUtil;
import com.Model.Account;

public class HDFCBank implements RBIBank {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction tnx = session.beginTransaction();
	Scanner s = new Scanner(System.in);
	@Override
	public void Create_account() {
		// Method for create the new Account into the database
		System.out.println("Enter the id, acname , address, mobile number, adhare number, PAN Number, balanace,Account Type and gender");
		int id = s.nextInt();
		String acname = s.next();
		String address = s.next();
		long mob = s.nextLong();
		long adhare = s.nextLong();
		String pan = s.next();
		double bal = s.nextDouble();
		String actype = s.next();
		String gender = s.next();
		
		Account a1 = new Account();
		a1.setId(id);
		a1.setAcname(acname);
		a1.setAddress(address);
		a1.setMob_no(mob);
		a1.setAdhar_no(adhare);
		a1.setPan_no(pan);
		a1.setBalance(bal);
		a1.setActype(actype);
		a1.setGender(gender);

		session.save(a1);
		tnx.commit();
 		
	}
	@Override
	public void view_details() {
				
				// Store the data into the format of the list for iterate it after
				List<Account> entities = session.createQuery("from Account",Account.class).getResultList();
				
				// Here create object and add the data
				// Show the data 
				for(Account entity : entities)
				{
					System.out.println(entity.getId()+"\t"+entity.getAcname()+"\t"+entity.getAddress()+"\t"+entity.getMob_no()+"\t"+entity.getAdhar_no()+"\t"+entity.getPan_no()+"\t"+entity.getBalance()+"\t"+entity.getActype()+"\t"+entity.getGender());
				}
				session.close();
				System.out.println("data Showed successfully....");
		
	}
	@Override
	public void Deposite_Money() {
		 // Code for update or deposit the money into the account.
		System.out.println("Enter id to Deposit money: ");
	    int id = s.nextInt();
	    Account account = session.get(Account.class, id);
	    if (account != null) {
	        System.out.println("Enter amount to Deposit: ");
	        double amount = s.nextDouble();
	        double currentBalance = account.getBalance();
	        if (currentBalance >= amount) {
	            account.setBalance(currentBalance + amount); // Subtract withdrawn amount from the current balance
	            session.update(account);
	            tnx.commit();
	            System.out.println("Depsite successful!");
	            System.out.println("Remaining Balance: " + account.getBalance()); // Display remaining balance after withdrawal
	        } else {
	            System.out.println("Insufficient balance!");
	        }
	    } else {
	        System.out.println("Account not found!");
	    }
	    session.close();
		
	}
	@Override
	public void Withdraw_Money() {
	    // Code for withdrawal from the account.
	    System.out.println("Enter id to withdraw money: ");
	    int id = s.nextInt();
	    Account account = session.get(Account.class, id);
	    if (account != null) {
	        System.out.println("Enter amount to withdraw: ");
	        double amount = s.nextDouble();
	        double currentBalance = account.getBalance();
	        if (currentBalance >= amount) {
	            account.setBalance(currentBalance - amount); // Subtract withdrawn amount from the current balance
	            session.update(account);
	            tnx.commit();
	            System.out.println("Withdrawal successful!");
	            System.out.println("Remaining Balance: " + account.getBalance()); // Display remaining balance after withdrawal
	        } else {
	            System.out.println("Insufficient balance!");
	        }
	    } else {
	        System.out.println("Account not found!");
	    }
	    session.close();
	}

	@Override
	public void Update_AccountDetails() {
		// Code for update account details.
 		System.out.println("Enter the Id whose data want to update:");
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		System.out.println("Enter the data you want to update the account details:");
		String acname = s.next();
		String address = s.next();
		long mob = s.nextLong();
		long adhare = s.nextLong();
		String pan = s.next();
		double bal = s.nextDouble();
		String actype = s.next();
		String gender = s.next();
		Account a1 = new Account();
		a1.setAcname(acname);
		a1.setAddress(address);
		a1.setMob_no(mob);
		a1.setAdhar_no(adhare);
		a1.setPan_no(pan);
		a1.setBalance(bal);
		a1.setActype(actype);
		a1.setGender(gender);
		 
		session.save(a1); 
		tnx.commit();
		System.out.println("Data Updated successfully....");
		
		
	}
	@Override
	public void Delete_Account() {
		// Code for delete the Account form the Bank database.
 		// Here create object and add the data
		System.out.println("Enter the rno whose data want to delete");
		Scanner s = new Scanner(System.in);
		int rno = s.nextInt();
		// Delete the data from the database
		Account s1 = new Account();
		s1.setId(rno);
		
		// Here we are delete the data into the database
		session.delete(s1); 
		tnx.commit();
		System.out.println("Data Deleted successfully....");
		
	}
}
