package sample;

public class AllWorksDone {
    private int worksDone = 0;

    public synchronized int getWorksDone() {
        return worksDone;
    }

    public synchronized void setWorksDone(int worksDone) {
        this.worksDone = worksDone;
    }

    public AllWorksDone() {

    }
}
