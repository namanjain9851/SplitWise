package User;

import BalanceSheet.BalanceSheet;
import Expense.Expense;
import Group.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    public String UserId;
    public String UserName;
    public HashMap<String, Integer>ExpenseVsAmountMapping = new HashMap<>();

    public List<Group> groups = new ArrayList<Group>();

    public User(String userId, String userName) {
        UserId = userId;
        UserName = userName;
    }

    public void setAmount(int amount, String ExpenseId){
        if(ExpenseVsAmountMapping.containsKey(ExpenseId)){
            ExpenseVsAmountMapping.put(ExpenseId,ExpenseVsAmountMapping.get(ExpenseId)+amount);
        } else {
            ExpenseVsAmountMapping.put(ExpenseId,amount);
        }

    }



}
