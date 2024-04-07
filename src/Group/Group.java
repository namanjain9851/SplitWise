package Group;

import Expense.Expense;
import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    
    public String groupId;
    public String groupName;
    public String description;
    public User CreatedByUser;
    public List<Expense> expenses = new ArrayList<Expense>();
    public List<User> users = new ArrayList<User>();

    public Group(String groupId, String groupName, String description,User CreatedByUser) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
        this.CreatedByUser = CreatedByUser;
    }



    public boolean getExpenseById(String expenseId) {
        for(Expense expense: expenses){
            if(Objects.equals(expense.getExpenseId(), expenseId))
                return true;
        }
        return false;
    }

    public void setExpense(List<Expense> expense) {
        this.expenses = expense;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
    public void addUsers(User user) {
        users.add(user);
        user.groups.add(this);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
