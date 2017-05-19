package sample;

import java.util.ArrayList;

public class GroupId {
    private int id;
    private ArrayList<Elem> elements = new ArrayList();
    public GroupId(int id) {
        this.id = id;
    }

    public synchronized void setElements(Elem elem) {
        elements.add(elem);
    }

    public synchronized String job(){
        Elem elem = elements.get(0);
        this.elements.remove(elem);
        return String.valueOf(id) +" " + String.valueOf(elem.getElemId());
    }

    public synchronized int getSize(){
        return elements.size();
    }
}
