package Transaction;

import User.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransactionController {

    List<Transaction> transactions = new ArrayList<Transaction>();
    public  void minimizeTransactions(List<KeyValue> balances) {


        // Sort balances in ascending order
        Collections.sort(balances, Comparator.comparingInt(KeyValue::getValue));

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


    }

    public void displayTransactions(User user){
        for(int i=0;i<transactions.size();i++){
            Transaction t=transactions.get(i);
            if(user.UserName.contentEquals(t.from) || user.UserName.contentEquals(t.to))
            System.out.println(t.from + " owes " + t.to + " amount "+ t.amount);
        }
    }
}
