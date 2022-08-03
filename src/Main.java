import domain.Account;
import domain.Statement;
import exceptions.InsufficientBalanceException;

import java.text.ParseException;

import static builders.DateBuilder.date;
import static domain.Amount.amountOf;

public class Main {

    public static void main(String[] args) throws ParseException, InsufficientBalanceException {
        Account account = new Account(new Statement());

        account.deposit(amountOf(100), date("10/01/2022"));
        account.deposit(amountOf(20), date("13/01/2022"));
        account.withdrawal(amountOf(10), date("14/01/2022"));
        //account.withdrawal(amountOf(111),date("02/08/2022"));
        account.printStatement(System.out);
    }

}
