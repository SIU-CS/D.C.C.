package database2;

public class MainActivity {
//    static Intent Login,Group,Calendar,Profile,Search;

    static GroupTree test;



	public MainActivity() {
		// TODO Auto-generated constructor stub 
	test= new GroupTree();
	GenData art= new LinkedList("Art");
    GenData science= new LinkedList("Science");
    GenData reading= new LinkedList("Reading");

    GenData[]subjects = {art, science, reading};

    test.addSub(subjects);
    
	}

}
