package sample;

import java.util.ArrayList;

public class QueueOrder {
    private ArrayList<GroupId> order = new ArrayList();

    public QueueOrder() {
    }

    public synchronized ArrayList<GroupId> getOrder() {
        return order;
    }

    public synchronized void add(GroupId groupId) {
        order.add(groupId);
    }

    public synchronized GroupId getGroupId(){
        if (order.size() == 0){
            return null;
        }else {
            GroupId groupId = order.get(0);
            order.remove(groupId);
            return groupId;
        }
        }
}
