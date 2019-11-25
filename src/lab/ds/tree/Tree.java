package lab.ds.tree;

import java.util.Stack;

//Just a binary tree that does not assume any ordering of elements
public class Tree 
{

	Node root;
	
		
	
	public static void main(String args[])
	{
		
		Tree tree=new Tree();
		
		tree.buildTree();
		
	//	tree.preOrderTraversal(tree.root);

	//	tree.preOrderIterative(tree.root);
		
	//	tree.inorderTraversal(tree.root);
		

		//tree.inorderIterative(tree.root);
		
		tree.postOrderTraversal(tree.root);
		
		System.out.println("");
		tree.postOrderTraversalIterative_2Stacks(tree.root);
		
		
		
		
	//	System.out.println("Height is:"+tree.height(tree.root));
		
	//	tree.levelOrderTraversalRecursive(tree.root);
		
	//	tree.mirror(tree.root);
		
	//	int d=tree.diameter(tree.root);
	//	System.out.println("Diameter of the tree is:"+d);
		
	//	tree.preOrderTraversal(tree.root);
		
		
	}
	
	
	public void buildTree()
	{
		
		Node newnode=new Node(1);
		createTree(newnode);
		
		newnode=new Node(2);
		insertLeft(root,1,newnode);
		
		
		newnode=new Node(3);
		insertRight(root,1,newnode);
		
		
		newnode=new Node(4);
		insertLeft(root,2,newnode);
		
		
		newnode=new Node(5);
		insertRight(root,2,newnode);
		
		
		newnode=new Node(6);
		insertLeft(root,3,newnode);
		
		newnode=new Node(7);
		insertRight(root,3,newnode);
		
		newnode=new Node(8);
		insertLeft(root,4,newnode);
		
		newnode=new Node(9);
		insertRight(root,4,newnode);		
		
		newnode=new Node(10);
		insertLeft(root,5,newnode);
		
		newnode=new Node(11);
		insertRight(root,5,newnode);		
		
		
		
	}
	
	
//Diameter is the longest path from any two nodes in the tree	
 public int diameter(Node root)
 {
	 
	 if(root==null)
		 return 0;
	 
	 
	 int lheight=height(root.left)-1;//1 is subtracted to make it the number of edges instead of number of nodes
	 int rheight=height(root.right)-1;
	 
	 int ldiameter=diameter(root.left);
	 int rdiameter=diameter(root.right);
	 
	 

	 return Math.max(lheight+rheight+2, Math.max(ldiameter, rdiameter));
	 
	 
	 
 }
 
 
	
	
	//O(n2)
   public void levelOrderTraversalRecursive(Node tree)
   {
	   
	   
	   int h=height(tree);
	   
	   boolean lleft2Right=true; //Flag to allow ZIG ZAG order traversal
	   
	   for(int i=1;i<=h;i++)
	   {		   
		 traverseSingleLevel(tree,i,lleft2Right);  
		 System.out.println();
		// lleft2Right=!lleft2Right; //flip the flag after each level so that the traversal is ZIG ZAG
		   
	   }    
	  
	   
	  
   }
   
   
   public void traverseSingleLevel(Node root,int level, boolean left2Right)
   {
	   
	   if(root!=null)
	   {
	      if(level<1)
	      {
		   return;
	      }
	        else if(level==1)
	        {
		   
		     System.out.print(root.key+" "); 
		   
	         }
	        else
	        {
		      if(left2Right)
		      {
		      traverseSingleLevel(root.left,level-1,left2Right); 
		      traverseSingleLevel(root.right,level-1,left2Right);
		      }
		      else
		      {
		      traverseSingleLevel(root.right,level-1,left2Right);
		      traverseSingleLevel(root.left,level-1,left2Right); 
		      }
		   
		   
	        }	   
	   
         }
   
   } 
   
   
   
   
  //This method returns the number of nodes in the longest path
  //If number of edges is required, need to write a wrapper method and subtract 1 from the final height
  public int height(Node tree)
  {	  
	  
	  if(tree==null)
	  {
		  return 0; 
	  }	  
	  else
	  {
		  
		  return 1+ Math.max(height(tree.left), height(tree.right));
		  
	  }  
	  
	  
  }
   
   
   
   public void preOrderTraversal(Node tree)
   {
	   
	   if(tree!=null)
	   {
		   
		   System.out.print(tree.key+" ");
		   preOrderTraversal(tree.left);
		   preOrderTraversal(tree.right);		   
		   
	   }
	   
	   
	   
	   
   }
   
   
   public void preOrderIterative(Node tree)
   {
	   
	 if(tree==null)
		 return;
	 
	 
	 Stack<Node> stack=new Stack<Node>();
	 
	 stack.push(tree);
	 
	 while(!stack.isEmpty())
	 {
		 Node temp=stack.pop();		 
		 System.out.print(temp.key+" ");
		 
		 if(temp.right!=null)
			 stack.push(temp.right);
		 
		 if(temp.left!=null)
			 stack.push(temp.left); 
		 
		 
	 }

	 
	   
	   
	   
	   
   }
   
   

   public void inorderTraversal(Node tree)
   {
	 
	   if(tree==null)
		   return;
	   
	   
		   
		   inorderTraversal(tree.left);
		   System.out.print(tree.key+" ");
		   inorderTraversal(tree.right);   
	   
	   
   }
   
   
   
   public void inorderIterative(Node node)
   {
	   
	 if(node==null)
		 return;
	 
	 
	 Stack<Node> stack=new Stack<Node>();
	 
	 while(node!=null)
	 {
		stack.push(node);
		node=node.left; 
		 
	 }
	 
	 while(!stack.isEmpty())
	 {
		 
		 Node current=stack.pop();
		 
		 System.out.print(current.key+" ");
		 
		 if(current.right!=null)
		 {
			 current=current.right;
			 		 
			 while(current!=null)
			 {
				stack.push(current);	 
				current=current.left;
				 
			 }
			 
			 
		 }
		 
		 
		 
	 }
	   
	   
	   
	   
   }
   
   
   public void postOrderTraversal(Node tree)
   {
	   
	   if(tree==null)
		   return;
	   
	   
	   postOrderTraversal(tree.left);
	   postOrderTraversal(tree.right);
	   System.out.print(tree.key+" ");   
	   
	   
   }
   
   
   
   /*
    * Observation - A modified pre-order traversal visits the nodes in the 
    * reverse order of post-order traversal. So reversing the result of this 
    * modified pre-order traversal results in post order traversal.
    * 
    * The modification in pre-order traversal is that right node has to be  
    * visisted before left node.   * 
    * 
    * 
    */
   public void postOrderTraversalIterative_2Stacks(Node tree)
   {
	
	   Stack<Node> s1=new Stack<Node>();
	   Stack<Node> s2=new Stack<Node>();
	   
	   if(tree==null)
		   return;
	   
	   
	   s1.push(tree);
	   
	   Node current=tree;
	   
	   while(!s1.isEmpty())
	   {
		   
		   current=s1.pop();		
		   s2.push(current);
		   
		  
		   
		   
		   if(current.left!=null)
		   {
			   s1.push(current.left);
		   }
		   
		   
		   if(current.right!=null)
		   {
			   s1.push(current.right);
		   }
		   
		   
	   }
	   
	   while(!s2.isEmpty())
	   {
		   Node temp=s2.pop();
		   
		   System.out.print(temp.key+" ");
		   
		   
	   }
	   
	 
	   
	   
   }
   
   
   
   public void postOrder_NoextraMemory(Node tree)
   {
	   
	   
   }
   
   
   public Node preOrderSearch(Node tree,int key)
   {
	   
	   if(tree==null)
		   return null;
	   else
	   {
		   
		   if(key==tree.key)
		   {
			   return tree;
		   }
		   else
		   {
			   Node found=null;
			   
			   found=preOrderSearch(tree.left,key);
			   
			   if(found==null)//if the key was not found in the left subtree 
			   {
				   found=preOrderSearch(tree.right,key); 
			   }
			   
			  return found;
			   
		   }
		   
		   
	    }  
	   
	
   }
   
   
   
  public void createTree(Node newnode)
  {
	  
	 root=newnode;
	  
  }
	
	
  public void insertLeft(Node tree,int key,Node newnode)
  {
	  
	  
	  Node temp=preOrderSearch(tree,key);
	  
	  if(temp==null)
	  {
		  
		  System.out.println("No such node exists in the tree");
		  
	  }
	  else
	  {
		 
		  temp.left=newnode;
		  
	  }
	  
	  
	  
	  
  }
  
  
  public void insertRight(Node tree,int key,Node newnode)
  {
	  
     Node temp=preOrderSearch(tree,key);
	  
	  if(temp==null)
	  {
		  
		  System.out.println("No such node exists in the tree");
		  
	  }
	  else
	  {
		 
		  temp.right=newnode;
		  
	  }
	  
	  
  }	
	
  
  
  //Generate the mirror image of a tree
  public Node mirror(Node node)
	{
		
		
		
		if(node==null)
			return null;
		else
		{
			Node temp1,temp2;
			
			temp1=mirror(node.left);
		    temp2=mirror(node.right);
		    
		    node.left=temp2;
		    node.right=temp1;
		    
		    return node;		
			
		}
		
		
		
		
		
	}
	

	
	

}
