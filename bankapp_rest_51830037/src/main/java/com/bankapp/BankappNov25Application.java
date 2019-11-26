package com.bankapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.bankapp.model.entities.Account;
//import com.bankapp.model.entities.Customer;
//import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountService;
@EnableTransactionManagement
@SpringBootApplication
public class BankappNov25Application implements CommandLineRunner {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionLogRepository transactionLogRepository;
	
	@Autowired
	private AccountService accountService;
	

	public static void main(String[] args) {
		SpringApplication.run(BankappNov25Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// accountService.deposit(1L,1000.00);
		// accountService.withdraw(2L,500.00);
		 //accountService.transfer(2L,3L,500.00);
		 //accountService.createAccount(account4);;
		 
		 
		
		
		/*Customer customer1=new Customer("nuthana", "n@gmail.com", "9876543210", "Bangalore", "Karnataka", "India");
		Customer customer2=new Customer("gagna", "g@gmail.com", "8765432093", "Hyderabad", "Telangana", "India");
		Customer customer3=new Customer("tansi", "t@gmail.com", "856743215", "Chennai", "Tamilnadu", "India");
		
		Account account=new Account(10000.00,customer1,false);
		Account account2=new Account(20000.00,customer2,false);
		Account account3=new Account(30000.00,customer3,false);
		
		customer1.setAccount(account);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		
		accountRepository.save(account);
		accountRepository.save(account2);
		accountRepository.save(account3);
		
		User user1=new User("prathyu", "prathyu", "p@b.com", "8688766842", "Bangalore", 
				new String[]{"ROLE_ADMIN","ROLE_MGR","ROLE_CLERK"}, true);
		
		User user2=new User("sweety", "sweety", "s@b.com", "6302105217", "Hyderabad", 
				new String[]{"ROLE_MGR","ROLE_CLERK"}, true);
		
		User user3=new User("mahesh", "mahesh", "m@b.com", "9666551708", "Chennai", 
				new String[]{"ROLE_CLERK"}, true);

		User user4=new User("laxmi", "laxmi", "l@b.com", "9542319907", "Ongole", 
				new String[]{"ROLE_CLERK"}, true);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);*/
	
		
		
			}
		
	}














