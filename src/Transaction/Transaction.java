package Transaction;

import java.util.*;


public class Transaction {

    String from;
    String to;
    int amount;


    Transaction(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public static List<Transaction> minimizeTransactions(List<KeyValue> balances) {
        List<Transaction> transactions = new ArrayList<>();

        // Sort balances in ascending order
        Collections.sort(balances, (a, b) -> Integer.compare(a.getValue(), b.getValue()));

        int i = 0, j = balances.size() - 1;
        while (i < j) {
            int minDebt = Math.min(Math.abs(balances.get(i).getValue()), Math.abs(balances.get(j).getValue()));
            Transaction t = new Transaction(balances.get(i).getKey().UserName, balances.get(j).getKey().UserName, minDebt);

            transactions.add(t);

            balances.get(i).value += (balances.get(i).value > 0 ? -minDebt : minDebt);
            balances.get(j).value += (balances.get(j).value > 0 ? -minDebt : minDebt);

            if (balances.get(i).value == 0) i++;
            if (balances.get(j).value == 0) j--;
        }

        return transactions;
    }

}
