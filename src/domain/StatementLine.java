package domain;

import java.io.PrintStream;

public class StatementLine {

    private Transaction transaction;
    private Amount currentBalance;

    public StatementLine(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    public void printTo(PrintStream printStream) {
        this.transaction.printTo(printStream, currentBalance);
    }
}
