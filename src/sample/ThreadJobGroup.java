package sample;

import javax.swing.*;

public class ThreadJobGroup implements Runnable{
    private JLabel jLabelWork;
    private JLabel jLabelAllWorks;
    private AllWorksDone allWorksDone;
    private QueueOrder queueOrder;
    private int timeout;

    public ThreadJobGroup(QueueOrder queueOrder, JLabel jLabelWork, JLabel jLabelAllWorks,
                          AllWorksDone allWorksDone, int timeout) {
        this.jLabelWork = jLabelWork;
        this.jLabelAllWorks = jLabelAllWorks;
        this.allWorksDone = allWorksDone;
        this.queueOrder = queueOrder;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true){
                GroupId groupId = queueOrder.getGroupId();
                if (groupId != null) {
                    if (groupId.getSize() != 0) {
                        jLabelWork.setText(groupId.job());
                        allWorksDone.setWorksDone(allWorksDone.getWorksDone() + 1);
                        jLabelAllWorks.setText(String.valueOf(allWorksDone.getWorksDone()));
                    }
                }
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
