package com.example.chris.studygroup;

/**
 * Created by Chris on 10/30/2016.
 */

public class LinkedList extends GenData{
    private Node header,prev;
    private String ID;
    private Queue messages;

    public LinkedList(String id) {
        header = new Node(null);
        setId(id);
    }

    public void add(GenData data) {
        Node temp = new Node(data);
        Node current = header;
        while (!current.isLast()) {

            current = current.getNext();
        }
        current.setNext(temp);
    }


    public Node searchByData(GenData data) {
        if (hasData()) {
            Node current = header.getNext();
            Node prev=header;
            do {

                if (current.getData()==data) return current;
                else {
                    prev=current;
                    current = current.getNext();
                }

            }
            while (!current.isLast());
            if(current.getData()==data)return current;
            else {
                System.out.println("data was not found");
                return null;
            }

        } else {
            System.out.println("there is no data to search");
            return null;
        }
    }
    public Boolean contains(GenData data) {
        if (hasData()) {
            Node current = header.getNext();
            prev=header;
            do {

                if (current.getData()==data) return true;
                else {
                    prev=current;
                    current = current.getNext();
                }

            }
            while (!current.isLast());
            System.out.println("data was not found");
            return false;

        } else {
            System.out.println("there is no data to search");
            return false;
        }
    }


    public boolean remove(GenData data) {
        Node current = searchByData(data);

        if(current==null)return false;
        else{
            if(current.isLast())prev.setNext(null);
            else prev.setNext(current.getNext());
            return true;
        }
    }
    public int getLength(){
        Node current = header;
        int count = 0;
        while (!current.isLast()) {
            count++;
            current=current.getNext();
        }
        return count;
    }
    public GenData[] toArr(){
        Node current=header.getNext();
        GenData[] ret = new LinkedList[this.getLength()];
        for (int x= 0;x<this.getLength();x++){
            ret[x]=current.getData();
            current=current.getNext();
        }
        return ret;
    }
    @Override
    public String toString() {
        String ret;
        if(hasData()){
            Node current = header.getNext();
            ret = getId()+ ": \n";

            while (!current.isLast()){
                ret +=  current.getData().toString();
                current=current.getNext();
            }
            ret += current.getData().toString()+"\n";

        }else return getId() + ": there is no data\n";
        ret +="\n";
        return ret;
    }
    private boolean hasData(){
        if (header.isLast()){
            return false;

        }
        else return true;
    }
    @Override
    public String getId(){
        return ID;
    }
    @Override
    public void setId(String id){
        this.ID=id;
    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Group Specific methods                                                                                            |
//-----------------------------------------------------------------------------------------------------------------------------------+

    public void strtMsgQ(int length){
        messages=new Queue(length);
    }

    public void addMsg(Message msg){
        messages.push(msg);
    }
    @Override
    public String getMessages(){
        return messages.toString();
    }

}
class Node{
    private GenData data;
    private Node next;
    private boolean last;
    Node(GenData data) {
        setData(data);
        setNext(null);
        reSetLast();
    }

    public void setData(GenData data){
        this.data=data;
    }
    public GenData getData(){
        return data;
    }
    public void setNext(Node next){
        this.next=next;
        last=false;
    }
    public void reSetLast(){
        last=true;
    }

    public Node getNext(){
        return next;
    }
    public boolean isLast(){
        if( last){
            return true;
        }else return false;
    }
}
