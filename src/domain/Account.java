package domain;

import builders.Messages;
import exceptions.InsufficientBalanceException;

import java.io.PrintStream;
import java.util.Date;

import static domain.Amount.amountOf;

public class Account {

    private Statement statement;

    private Amount balance = amountOf(0);

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(Amount value, Date date) {
        recordTransaction(value, date);
    }

    public void withdrawal(Amount value, Date date) throws InsufficientBalanceException {

        if (value.getValue() > balance.getValue())
            throw new InsufficientBalanceException(Messages.INSUFFICIENT_BALANCE);
        recordTransaction(value.negative(), date);
    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }

    private synchronized void recordTransaction(Amount value, Date date) {
        Transaction transaction = new Transaction(value, date);
        Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
        balance = balanceAfterTransaction;
        statement.addStatementLine(transaction, balanceAfterTransaction);
    }

}
