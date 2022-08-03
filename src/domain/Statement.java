package domain;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statement {

    private List<StatementLine> statementLines = new ArrayList<>();

    private static final String STATEMENT_HEADER = "date       | credit   | debit    | balance";

    private static final int TOP_OF_LIST = 0;

    public void addStatementLine(Transaction transaction, Amount currentBalance) {
        this.statementLines.add(TOP_OF_LIST, new StatementLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(STATEMENT_HEADER);
        printStatementLines(printer);
    }

    private void printStatementLines(PrintStream printer) {
        for (StatementLine statementLine : statementLines) {
            statementLine.printTo(printer);
        }
    }
}
