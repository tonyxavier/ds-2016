package lab.algorithms.search;

public class BinarySearch {

	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String args[])
	{
		
		int[] arr={0,1,2,3,4,5,6,7,8};
		
		
		//int indx=binarySearch(arr,0);
		
		int indx=binarySearchRecursive(arr,8,0,arr.length-1);
		
		if(indx<0)
		{
			System.out.println("Couldn't find");
		}
		else
			System.out.println("Found at "+indx);
			
		
		
	}
	
	
	//Returns position of key in sorted array a
	public static int binarySearch(int[] a,int key)
	{
		
		
		
		int begin=0,end=a.length-1, mid=end/2;
		
		
		while(begin<=end)
		{
			
			
			if(key>a[mid])
			{
				begin=mid+1;
				mid=(end+begin)/2;
			}
			else if(key<a[mid])
			{
				end=mid-1;
				mid=(end+begin)/2;
				
			}
			else if(key==a[mid])
			{  
				//System.out.println("Found key at"+mid);
				return mid;
			}
			else
			{
				//System.out.println("Cant find");
				return -1;
			}
			
			
		
			
			
		}
		
		return -1;
		
		
		
		
	}
	
	
	public static int binarySearchRecursive(int[] a,int key,int low,int high)
	{
		
		
	
		if(a[low]==key)
		{
			return low;
			
		}
		else if(a[high]==key)
		{
			return high;
		}		
		else
		{			
			
			int mid=(low+high)/2;
			
			if(key> a[mid])
			{	
				//The return is very important. Otherwise it'll go further down and return -1
				return binarySearchRecursive(a,key,mid+1,high);
				
			}
			else if(key<a[mid])
			{
				return binarySearchRecursive(a,key,low,mid-1);	
			}
			else if(key==a[mid])
			{
				return mid;
			}
			
		}
		
		return -1;
		
		
	}
	
	
	
	public int binarySearchRotated(int[] a, int key)
	{
		
		return 0;
		
	}
	

}
