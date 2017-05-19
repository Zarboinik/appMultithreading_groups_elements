package sample;

import javax.swing.*;

public class ThreadLoadGroup implements Runnable {
    private GroupId groupId;
    private JLabel jLabel;
    private QueueOrder queueOrder;
    private int i;
    private int timeout;

    public ThreadLoadGroup(GroupId groupID, JLabel jLabel, int timeout, QueueOrder queueOrder) {
        this.groupId = groupID;
        this.jLabel = jLabel;
        this.timeout = timeout;
        this.queueOrder = queueOrder;
    }

    @Override
    public void run() {
        while (true) {
            i++;
            groupId.setElements(new Elem(i));
            queueOrder.add(groupId);
            jLabel.setText(String.valueOf(groupId.getSize() -1));
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
