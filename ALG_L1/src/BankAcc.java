// Interface for bank account: specifies signatures of public methods
public interface BankAcc {
	public String getName();
	public Integer getAccNum();
	public Float getBalance();
	public Float deposit(Float amount);
	public boolean withdraw(Float amount);
}