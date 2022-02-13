package zoz;
import java.util.*;

public class Main{
    public static void main(String [] args){
        GenericTree tree = new GenericTree();
        Scanner s =new Scanner(System.in);
        tree.display();
       tree.levelDisplay();
       tree.adduser(s);
       tree.removeuser(s);
       tree.removeLeaves(s);
    //   tree.levelDisplay();
      // tree.removeuser(s);
      System.out.println(  "8.Number of users from top is " + tree.size());
      System.out.println(  "9.The Height of the heierachy tree is " + tree.height());
     
    }
}

class GenericTree{
    class Node{
        String data;
        LinkedList <Node> subroles;
		 LinkedList<String> name;
		 Node(String data)
		 {

		             this.data = data;
		             subroles = new LinkedList <> ();
		             name=new LinkedList<>();
		         }

    }

    private Node root;

    GenericTree(){
        Scanner s = new Scanner(System.in);
        this.root = constructGT(s, null, 0);
  
}
    private Node constructGT(Scanner s, Node parent, int i){
        if(parent == null){
            System.out.println("Enter the data for the root role...");

        }
        else{
            System.out.println("Enter the data for the " + i + "th subrole of " + parent.data);
        }

       String data = s.next();
        Node node = new Node(data);
        

        System.out.println("Enter the number of subrole for " + node.data);
        int n = s.nextInt();

        for(int j = 0; j<n; j++){
            Node child = constructGT(s,node,j);
            node.subroles.add(child);
        }

        return node;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
      
        String str = node.data + " => ";

        for(Node child: node.subroles){
            str += child.data + ", ";
        }

        System.out.println(str);

        for(Node child: node.subroles){
            display(child);
        }
    }
    
    
    public int height()
	{
		return this.height(root);
	}
	
	private int height(Node node)
	{
		int th = 0;
for(Node child: node.subroles)
		{
			int ch = height(child);   
			if(ch>th)
				th = ch;
		}
		return th+1;
		
		
	}

    //size using recursion
	public int size()
	{
		return this.size(this.root);
	}
	
	private int size(Node node)
	{
		int ts = 1;  
		
		for(Node nn: node.subroles)
		{
			int cs = size(nn);   
			ts += cs;
		}
		
		return ts;
	}
	
public void adduser(Scanner s)
{
	adduser(this.root,s);
}

private void adduser(Node node,Scanner s){
	System.out.println("add User");
	String name=s.next();
	String mat=s.next();
	
	if(root.data.matches(mat))
	{
		node.name.add(name);
		System.out.println("User of "+ mat +" "+ name);
	}
	else
	{
	for(int i = 0; i<=node.subroles.size()-1; i++){
        Node child = node.subroles.get(i);  
    
        if(child.data.matches(mat))
        {
        	node.name.add(name);
        	System.out.println("User of "+ mat +" "+name);
        }
}
}
}

public void levelDisplay()
{
	levelDisplay(this.root);
}


	private void levelDisplay(Node node) {
		System.out.print("Tree hierarchy is "+ root.data+" ");
		for(int i = 0; i<=node.subroles.size()-1; i++){
            Node child = node.subroles.get(i);
            
            System.out.print(child.data+" ");
		}
		   System.out.println("");	
	}
	
	public void removeuser(Scanner s)
	{
		removeuser(this.root,s);
	}
	

	private void removeuser(Node node,Scanner s) {
		System.out.println("Remove user");
		String lev=s.next();
    
    	for(int i = 0; i<=node.name.size(); i++){
           if(node.name.contains(lev))
           {
        	   node.name.remove();
        	   System.out.println("The "+lev+" user is removed" );
        	   }
        }
		
	}

	public void removeLeaves(Scanner s){
        removeLeaves(this.root,s);
    }
	

	private void removeLeaves(Node node,Scanner s){
		System.out.println("Remove Subrole");
		String lev=s.next();
    
    	for(int i = 0; i<=node.subroles.size()-1; i++){
            Node child = node.subroles.get(i);
         
           if(child.data.matches(lev))
        	   {
        	   node.subroles.remove(child);
        	   System.out.println("The "+lev+" role is removed" );
        	   }
        }
}
    
}




 


