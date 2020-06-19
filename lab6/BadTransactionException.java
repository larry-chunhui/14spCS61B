public class BadTransactionException extends Exception{
    public int amountNumber;
    public BadTransactionException(int badAmount){
        super("Invalid amount: "+ badAmount);
        amountNumber=badAmount;
    }
}