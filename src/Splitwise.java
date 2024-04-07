import BalanceSheet.BalanceSheet;
import Expense.Expense;
import Expense.ExpenseType;
import Group.Group;
import Group.GroupController;
import User.User;
import User.UserController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Splitwise {

    Splitwise(){
        UserController userController = new UserController();
        GroupController groupController = new GroupController();
        BalanceSheet balanceSheet = new BalanceSheet();
        userController.addUser(new User("U1","name1"));
        userController.addUser(new User("U2","name2"));
        userController.addUser(new User("U3","name3"));
        userController.addUser(new User("U4","name4"));
        userController.addUser(new User("U5","name5"));




        User u1=userController.getUser("U1");
        User u2=userController.getUser("U2");
        User u3= userController.getUser("U3");
        HashMap<User,Integer> UserAmountMap=new HashMap<>();
        UserAmountMap.put(u1,-200);
        UserAmountMap.put(u2,-200);
        UserAmountMap.put(u3,-200);
        Expense expense = new Expense("Exp1",600,u1, ExpenseType.EQUAL,UserAmountMap);

        UserAmountMap.clear();
        UserAmountMap.put(u2,-100);
        UserAmountMap.put(u3,-500);

        Expense expense2 = new Expense("Exp2",600,u1, ExpenseType.UNEQUAL,UserAmountMap);





        groupController.addGroup(new Group("G1","LUNCH","lunch amount",u1));
        groupController.getGroup("G1").addUsers(u1);
        groupController.getGroup("G1").addUsers(u2);
        groupController.getGroup("G1").addUsers(u3);
        groupController.getGroup("G1").addExpense(expense);
        groupController.getGroup("G1").addExpense(expense2);


        groupController.addGroup(new Group("G2","Dinner","Dinner amount",u2));
        groupController.getGroup("G2").addUsers(u1);
        groupController.getGroup("G2").addUsers(u2);
        groupController.getGroup("G2").addUsers(u3);
        groupController.getGroup("G2").addExpense(expense);
        groupController.getGroup("G2").addExpense(expense2);

        balanceSheet.displayBalanceSheet(u1);







    }

}
