package database2;

public abstract class GenData {
	 @Override
	    abstract public String toString();
	    abstract public void setId(String Id);
	    abstract public String getId();
	//------------------------------------------------------------------------------------------------------------------
//	           User Methods to Override
	//----------------------------------------------------------------------------------------------------------------
	    public boolean addToGroup(String group){return false;}
	    public boolean isMember(String group){return false;}
	    public boolean removeFromGroup(String group){return false;}

	    public LinkedList GetGroups(){return null;}
	    public LinkedList GetCreatedGroups(){return null;}
	    public boolean createGroup(String name,String sub){return false;}
	    public boolean removeGroup(String name){return false;}


	//-------------------------------------------------------------------------------------------------------
//	           LinkedList Methods to Override
	//--------------------------------------------------------------------------------------------------------------

}
