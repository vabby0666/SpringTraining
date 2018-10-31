package BankingSystem;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import BankingSystem.CreateAccountPSS;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	int can;
	@Autowired
	CreateAccountPSS pss;
	Scanner in=new Scanner(System.in);
	@Autowired
	Address address;
	@Autowired
	Account acc;
	@Autowired
	TransactionList tra;
	@Autowired
	public AccountDaoImpl(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	@Override
	public int accnoGenerate() {
        String sql="select max(AccountNo) from AccountTable";
        Integer rows;
        rows=getJdbcTemplate().queryForObject(sql, null,Integer.class);
        if(rows==null)
            can=5001;
        else
            can=++rows;
        return can;
    }
	
	@Override
	public int CreateAccount() {
		can=accnoGenerate();
		String sql="insert into AccountTable values(?,?,?,?)";
		getJdbcTemplate().update(sql, pss);
		String sql1="insert into AddressTable values(?,?,?)";
		address.setStreet(in.next());
		address.setCity(in.next());
		acc.setAddress(address);
		acc.setAccNo(can);
		Object[] args= {acc.getAccNo(),acc.getAddress().getStreet(),acc.getAddress().getCity()};
		getJdbcTemplate().update(sql1, args);
		can++;
		String sql2="insert into TransactionTable values(?,?,?,?,?,?)";
		Object[] args1= {acc.getAccNo(),acc.getDate(),"credit","Create",acc.getBalance(),acc.getBalance()};
		getJdbcTemplate().update(sql2, args1);
		return acc.getAccNo();
	}

	@Override
	public int Deposit() {
		String sql="update AccountTable set Balance=? where AccountNo=?";
		System.out.println("Enter account number, amount & date to deposit\n");
		acc.setAccNo(in.nextInt());
		acc.setAmount(in.nextInt());
		acc.setDate(DateParsing.convertToUtilDate(in.next()));
		String sql1="select Balance from AccountTable where AccountNo=?";
        double rows;
        rows=getJdbcTemplate().queryForInt(sql1, acc.getAccNo());
        double rw=rows+acc.getAmount();
		Object[] args= {rw, acc.getAccNo()};
		getJdbcTemplate().update(sql, args);
		String sql2="insert into TransactionTable values(?,?,?,?,?,?)";
		Object[] args1= {acc.getAccNo(),acc.getDate(),"credit","deposit",acc.getAmount(),rw};
		getJdbcTemplate().update(sql2, args1);
		int am=(int)rw;
		return am;
	}

	@Override
	public int Withdraw() {
		String sql="update AccountTable set Balance=? where AccountNo=?";
		System.out.println("Enter account number, amount & date to withdraw\n");
		acc.setAccNo(in.nextInt());
		acc.setAmount(in.nextInt());
		acc.setDate(DateParsing.convertToUtilDate(in.next()));
		String sql1="select Balance from AccountTable where AccountNo=?";
        double rows;
        rows=getJdbcTemplate().queryForInt(sql1, acc.getAccNo());
        double rw=rows-acc.getAmount();
		Object[] args= {rw, acc.getAccNo()};
		getJdbcTemplate().update(sql, args);
		String sql2="insert into TransactionTable values(?,?,?,?,?,?)";
		Object[] args1= {acc.getAccNo(),acc.getDate(),"debit","withdraw",acc.getAmount(),rw};
		getJdbcTemplate().update(sql2, args1);
		int am=(int)rw;
		return am;
	}

	@Override
	public List<TransactionList> ViewStatement() {
		String sql="select * from TransactionTable where AccNo=?";
		System.out.println("Enter Account No to View your Transaction Statements\n");

		tra.setAccNo(in.nextInt());
		Object[] args= {tra.getAccNo()};
		List<TransactionList> tranList=getJdbcTemplate().query(sql,args,new BeanPropertyRowMapper<TransactionList>(TransactionList.class));
		return tranList;
	}
}
