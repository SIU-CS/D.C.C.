package database2;

public interface User {
    boolean addToGroup(String group);
    boolean isMember(String group);
    boolean removeFromGroup(String group);
    LinkedList GetGroups();
    LinkedList GetCreatedGroups();
    boolean createGroup(String name,String sub);
    boolean removeGroup(String name);
    String getPass();
    void setPass(String pass);
    String getId();
    void setId(String Id);
    String getEmail();
    void setEmail(String email);
    String toString();
}
