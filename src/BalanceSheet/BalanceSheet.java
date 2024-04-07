package BalanceSheet;

import Group.Group;
import Transaction.*;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {

    int amount;
    public void displayBalanceSheet(User user) {

        System.out.println("Expense for User:" + user.UserName);
        for(int i=0;i<user.groups.size();i++){
            Group group=user.groups.get(i);
            List<User> users=user.groups.get(i).users;
            System.out.println("Expense for group:" + group.groupName);
            List<KeyValue> balances = new ArrayList<KeyValue>();
            for(int j=0;j<users.size();j++){
                int totalAmountOfUserInGroup=0;
                for(Map.Entry<String, Integer> m: users.get(j).ExpenseVsAmountMapping.entrySet()){
                    if(group.getExpenseById(m.getKey())){
                        totalAmountOfUserInGroup=totalAmountOfUserInGroup+m.getValue();
                    }
                }
                balances.add(new KeyValue(users.get(j),totalAmountOfUserInGroup));
            }

            TransactionController t =new TransactionController();
            t.minimizeTransactions(new ArrayList<KeyValue>(balances));
            t.displayTransactions(user);
        }


    }


}
