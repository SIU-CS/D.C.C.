package database2;

public class GroupTree {
    private LinkedList root;
    public GroupTree(){
        root = new LinkedList("root");

    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Set Methods: from general to specific                                                                              |
//-----------------------------------------------------------------------------------------------------------------------------------+
    public void addSub(GenData[] data){
        int x;
        for(x=0;x < data.length; x++) {
            root.add(data[x]);
            System.out.println(data[x].getId() + " was added");
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
            System.out.println(subject.getId() +" exists and " +group.getId()+ " was added");
            return true;
        }
        System.out.println("subject does not exist group was not added");

        return false;


    }
    public boolean addUser(GenData input, String groupId){
        LinkedList group = getGroup(groupId);
        if (group!=null) {

            group.add(input);
            System.out.println(group.getId() +" exists and " + input.getId() + " was added");
            return true;
        }
        System.out.println("group does not exist user was not added");

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

    public LinkedList getGroup(String ID){

            LinkedList[] subjects = (LinkedList[])root.toArr();

            LinkedList[] current;
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


}
