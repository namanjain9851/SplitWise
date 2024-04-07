package Expense;

import User.User;

import java.util.HashMap;

public class Expense {
    
    public String ExpenseId;
    public Integer ExpenseAmount;
    public User user;
    public ExpenseType expenseType;
    HashMap<User,Integer> UserAmountMap = new HashMap<User, Integer>();

    public Expense(String expenseId, Integer expenseAmount, User user, ExpenseType expenseType,HashMap<User,Integer> userAmountMap) {
        ExpenseId = expenseId;
        ExpenseAmount = expenseAmount;
        this.user = user;
        this.expenseType = expenseType;
        this.UserAmountMap =userAmountMap;
        computeUserExpense();
    }

    public void computeUserExpense(){

        user.setAmount(ExpenseAmount,ExpenseId);
        UserAmountMap.forEach((user,amount) -> {

            user.setAmount(amount,ExpenseId);
        });
    }

    public String getExpenseId() {
        return ExpenseId;
    }

    public void setExpenseId(String expenseId) {
        ExpenseId = expenseId;
    }

    public Integer getExpenseAmount() {
        return ExpenseAmount;
    }

    public void setExpenseAmount(Integer expenseAmount) {
        ExpenseAmount = expenseAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

}
