package Group;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groups =  new ArrayList<Group>();

    public void addGroup(Group grp) {
        if(grp!=null)
            groups.add(grp);
    }

    public Group getGroup(String groupID) {
        for(Group grp: groups){
            if(grp.groupId.equals(groupID)){
                return grp;
            }
        }
        return null;
    }
    public List<Group> getGroupsList(){
        return groups;
    }
}
