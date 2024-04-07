package User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> users=new ArrayList<User>();

    public void addUser(User user) {
        if(user!=null)
         users.add(user);
    }

    public User getUser(String userId) {
        for(User user: users){
            if(user.UserId.equals(userId)){
                return user;
            }
        }
        return null;
    }
    public List<User> getUserList(){
        return users;
    }
}
