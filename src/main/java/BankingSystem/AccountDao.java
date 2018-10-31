package BankingSystem;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface AccountDao {
	public int CreateAccount();
	public int Deposit();
	public int Withdraw();
	public List<TransactionList> ViewStatement();
	public int accnoGenerate();
	
}
