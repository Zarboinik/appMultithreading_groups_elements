package sample;

import javax.swing.*;

public class Main{

    public static void main(String[] args){
        GroupId groupId1 = new GroupId(1);
        GroupId groupId2 = new GroupId(2);
        GroupId groupId3 = new GroupId(3);
        GroupId groupId4 = new GroupId(4);
        GroupId groupId5 = new GroupId(5);
        GroupId groupId6 = new GroupId(6);

        AllWorksDone allWorksDone = new AllWorksDone();
        QueueOrder queueOrder = new QueueOrder();

        NewJFrame newJFrame = new NewJFrame();
        newJFrame.setVisible(true);
        JLabel jLabelAllWorks = newJFrame.getjLabel12();

        //Запуск потоков пополнения задач
        JLabel groupLabel1 = newJFrame.getjLabel5();
        Thread th1 = new Thread(new ThreadLoadGroup(groupId1, groupLabel1,2500,queueOrder));
        th1.start();

        JLabel groupLabel2 = newJFrame.getjLabel7();
        Thread th2 = new Thread(new ThreadLoadGroup(groupId2, groupLabel2, 3000,queueOrder));
        th2.start();

        JLabel groupLabel3 = newJFrame.getjLabel8();
        Thread th3 = new Thread(new ThreadLoadGroup(groupId3, groupLabel3, 4000,queueOrder));
        th3.start();

        JLabel groupLabel4 = newJFrame.getjLabel10();
        Thread th4 = new Thread(new ThreadLoadGroup(groupId4, groupLabel4, 5000,queueOrder));
        th4.start();

        JLabel groupLabel5 = newJFrame.getjLabel9();
        Thread th5 = new Thread(new ThreadLoadGroup(groupId5, groupLabel5, 6000,queueOrder));
        th5.start();

        JLabel groupLabel6 = newJFrame.getjLabel11();
        Thread th6 = new Thread(new ThreadLoadGroup(groupId6, groupLabel6, 7000,queueOrder));
        th6.start();

        //Запуск потоков Выполнения задач
        JLabel jobLable1 = newJFrame.getjLabel1();
        Thread tj1 = new Thread(new ThreadJobGroup(queueOrder, jobLable1,jLabelAllWorks, allWorksDone, 2000));
        tj1.start();

        JLabel jobLable2 = newJFrame.getjLabel2();
        Thread tj2 = new Thread(new ThreadJobGroup(queueOrder, jobLable2,jLabelAllWorks, allWorksDone, 3000));
        tj2.start();

        JLabel jobLable3 = newJFrame.getjLabel13();
        Thread tj3 = new Thread(new ThreadJobGroup(queueOrder, jobLable3,jLabelAllWorks, allWorksDone,4000));
        tj3.start();

        JLabel jobLable4 = newJFrame.getjLabel14();
        Thread tj4 = new Thread(new ThreadJobGroup(queueOrder, jobLable4,jLabelAllWorks, allWorksDone,5000));
        tj4.start();
    }
}
