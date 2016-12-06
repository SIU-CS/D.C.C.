package com.example.chris.studygroup;

/**
 * Created by Chris on 10/31/2016.
 */

public class GroupTree {
    private LinkedList root;
    private int numOfGroups;
    public GroupTree(){
        root = new LinkedList("root");
        numOfGroups=0;
    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Set Methods: from general to specific         only these need to prompt the database for changes                                                                     |
//-----------------------------------------------------------------------------------------------------------------------------------+
    public void addSub(GenData[] data){
        int x;
        for(x=0;x < data.length; x++) {
            root.add(data[x]);
            System.out.println(data[x].getId() + " was added");
        }

    }
    public void addSubArr(String[] data){
        int x;

        for(x=0;x < data.length; x++) {
            GenData sub = new LinkedList(data[x]);
            root.add(sub);
            System.out.println(data[x] + " was added");
        }
    }
    public void addSub(LinkedList data){
        root.add(data);
        System.out.println(data.toString() + " was added");
    }

    public boolean addGroup(String groupId,String subId){
        LinkedList group= new LinkedList(groupId);
        LinkedList subject = getSub(subId);
        if (subject!=null) {
            System.out.println(subject.getId() +" exists and " +group.getId()+ " was added");
            subject.add(group);
            numOfGroups++;
            //database push
            return true;
        }
        System.out.println("subject:" +subId +" does not exist group was not added");

        return false;


    }
    public boolean addUser(GenData input, String groupId){
        LinkedList group = getGroup(groupId);
        if (group!=null) {

            group.add(input);
            System.out.println(group.getId() +" exists and " + input.getId() + " was added");
            //database push
            return true;
        }
        System.out.println("group:" + groupId +" does not exist user was not added");

        return false;
    }

//-----------------------------------------------------------------------------------------------------------------------------------+
//                Search Methods: from general to specific                                                                           |
//-----------------------------------------------------------------------------------------------------------------------------------+

    public LinkedList getSub(String ID){



            LinkedList[] subjects = (LinkedList[]) root.toArr();

            int x=0;
            while(x<subjects.length && ID!=subjects[x].getId() ) {
                x++;
            }

            if(x<subjects.length) return subjects[x];

        return null;
    }

    public GenData[] getGroups(){
        LinkedList[] current,subjects =(LinkedList[])root.toArr();
        GenData[] ret= new GenData[numOfGroups];
        int x,y,z=0;

        for(x=0;x<subjects.length;x++) {
            y=0;
            current=(LinkedList[])subjects[x].toArr();
            while(y < current.length) {
                ret[z]=current[y];
                y++;
                z++;
            }

        }
        return ret;
    }
    public GenData[] Search(String keyword){

        LinkedList[] current,subjects =(LinkedList[])root.toArr();
        GenData[] ret= new GenData[numOfGroups];
        int x,y,z=0;
        for(x=0;x<subjects.length;x++) {
            y=0;
            current=(LinkedList[])subjects[x].toArr();
            while(y < current.length) {
                if(current[y].getId().contains(keyword)) {
                    ret[z]=current[y];
                    z++;
                }
                y++;

            }

        }
        return ret;
    }

    public LinkedList getGroup(String ID){

            LinkedList[] current, subjects = (LinkedList[])root.toArr();


            int x,y;
            for(x=0;x<subjects.length;x++) {
                current=(LinkedList[])subjects[x].toArr();
                y=0;
                while(y<current.length && current[y].getId()!= ID) {
                    y++;
                }
                if (y<current.length)return current[y];

            }


        return null;
    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                To String                                                                                                           |
//-----------------------------------------------------------------------------------------------------------------------------------+
    public String toString(){
    return root.toString();
 }

    public String SubToString(String subId){
        LinkedList subject=getSub(subId);
        String ret=subject.getId()+":\n";
        GenData[] groups=subject.toArr();

        for (int x=0;x<groups.length;x++){
            ret+=groups[x].toString();
            ret+=groups[x].getMessages();
        }
        return ret;
    }

}
