package com.example.chris.studygroup;

/**
 * Created by Chris on 11/14/2016.
 */

public class Queue {
    Node header,start,current;

    Queue(int length){
        header= new Node(null);
        start=header;
        current=header;

        for(int x=0;x<length-1;x++) {
            Node temp= new Node(null);
            current.setNext(temp);
            current = current.getNext();
        }
        current.setNext(header);
    }
    public void push(GenData data){
    current= start;
        while(current.getData()!=null&&current.getNext()!=start){
            current=current.getNext();
        }

        if(current.getData()!=null){
            start.setData(data);
            start=start.getNext();

        }else current.setData(data);
    }
    public GenData pop(){
        GenData temp;
        current=start;
        start=current.getNext();
        temp =current.getData();
        current.setData(null);
        return temp;

    }

    private GenData[] toArr(){
        GenData[] ret;
        current=start;

        return null;
    }

    public String toString(){
        String ret = " ";
        current=start;
        while(current.getData()!=null&&current.getNext()!=start){
            ret+=current.getData().toString();
            current=current.getNext();
        }
        if(current.getData()!=null) {
            ret += current.getData().toString();
            current = current.getNext();
        }
        return ret;
    }

}
