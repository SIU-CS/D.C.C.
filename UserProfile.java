package database2;

public class UserProfile extends GenData implements User  {
    private String ID,email,pass;
    LinkedList groups,current,created;
    GroupTree tree=MainActivity.test;//when we get a data base we will make tree call the database function get tree.
    public UserProfile(String Id, String Email, String Password){
        setId(Id);
        setEmail(Email);
        setPass(Password);
        groups= new LinkedList("myGroups");
    }
    @Override
    public boolean addToGroup(String group) {
        current=tree.getGroup(group);
        if(current!=null){
            current.add(this);
            groups.add(current);
            return true;

        }
        return false;
    }

    @Override
    public boolean isMember(String group) {
        current=tree.getGroup(group);
        if(current!=null){


            return groups.contains(current);

        }
        return false;
    }

    @Override
    public boolean removeFromGroup(String group) {
        current=tree.getGroup(group);
        if(current!=null){
            current.remove(this);
            groups.remove(current);
            return true;

        }
        return false;
    }


    @Override
    public LinkedList GetGroups() {
        return groups;
    }

    @Override
    public LinkedList GetCreatedGroups() {
        return created;
    }

    @Override
    public boolean createGroup(String name,String sub) {
        return tree.addGroup(name,sub);
    }

    @Override
    public boolean removeGroup(String name) {
        return false;
    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Get and Set Methods                                                                                                |
//-----------------------------------------------------------------------------------------------------------------------------------+
    @Override
    public void setId(String Id){
        this.ID=Id;
    }
    @Override
    public String getId(){
        return ID;
    }

    @Override
    public void setEmail(String email){
        this.email=email;
    }
    @Override
    public String getEmail(){
        return email;
    }

    @Override
    public void setPass(String password){
        this.pass=password;
    }
    @Override
    public String getPass(){
        return pass;
    }

    @Override
    public String toString(){
        return "( " + ID + ", " + email +" )\n";
    }

}

