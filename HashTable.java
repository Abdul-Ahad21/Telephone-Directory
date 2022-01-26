package Project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameer
 */

public class HashTable 
{
    Contact[] Table;

    int numofCollisions ;
    int numofOccupiedCells;
    HashTable(int s)
    {
    // table size should be a prime number and 1/3 extra.
        numofCollisions=0;
        numofOccupiedCells=0;
        int size=s+(s/3);
        int newSize = getPrime(size);
        
        Table=new Contact [newSize]; // if value is 0 for integer the cell will consider empty.
    }
    private int getPrime(int n) 
    {
        while(true) {
        if (isPrime(n)) return n;
        n++;
        }
    }
    private boolean isPrime(int n) 
    {
        for (int i = 2; i <= n/2; i++) {
        if (n % i == 0) return false;
    }
    return true;
    }
    public int Hash(String name)
    {
        String s=name;
        s=s.toLowerCase();
        int p = 31;
        int m = Table.length;
        int hashvalue = 0;
        int p_pow = 1;
        for (char c=0; c<s.length(); c++) 
        {
            hashvalue = (hashvalue + (s.charAt(c) - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p);
        }
        return Math.abs(hashvalue);
    //compute hash value by taking mod on key value and return remainder
    }
    public int Rehash(int hashvalue, int i)
    {
        //Quadratic
        int rehashvalue= (hashvalue+(i*i))%(Table.length);
        return rehashvalue;
    // first test linear probing, then test Quadratic probing and compare both technique on same datawith respect to number of collision
    }
    public void insert(Contact key)
    { // keep maintain 1/3 empty cells
    // call Hash(key) and save return hash-value
    // if (no collision on hash-value) then place in table
    //else call rehash function until empty cell found or reached to threshold limit of rehashes
    // also count number of collisions on each key insertion
        int hashvalue=Hash(key.name);
        numofOccupiedCells++;
        if(Table[hashvalue]==null || Table[hashvalue].name=="empty"){
            Table[hashvalue]=key;
        }
        else{
            int rehashvalue=hashvalue;
            int i=1;
            while(Table[rehashvalue] != null  && Table[rehashvalue].name!="empty" ){
                rehashvalue=Rehash(hashvalue, i );
                i++;
                numofCollisions++;
            }
            if(i>=Table.length){
            	System.out.println("insertion failed");
            }
            else{
            	Table[rehashvalue]=key;
            }
        }
    }
    public Contact search(String name) {
        
    // search word in a hash table
    // call Hash(key) and save return hash-value
    // if (value match at hash-value index) return true
    //else call rehash function until empty cell found or it reaches threshold limit of rehashes.
        name = name.toLowerCase();
        int hashvalue= Hash(name);
        Contact C = new Contact("","","");
        Contact c1 = Table[hashvalue];
        String n = "";
        n = c1.name;
        n = n.toLowerCase();
        if(c1!=null && n!= "empty"){
	        if(n.equals(name)){
	            C= Table[hashvalue];
	        }
	        else{
	            int rehashvalue=hashvalue;
	            int i=1;
                    Contact c2 = Table[rehashvalue];
                    String n2 = c2.name;
	            while(!n2.equals(name)){
	                rehashvalue=Rehash(hashvalue, i );
                        c2 = Table[rehashvalue];
                        n2 = c2.name;
	                //if(Table[rehashvalue]==null)break;
	                i++;
	                numofCollisions++;
	            }
	            if(c2==null || n2.equals("empty"))
	                C= new Contact("Not Found", "", "");
	            else if(n2.equals(name))
	                C= Table[rehashvalue];
	        }
        }
        else{
        C= new Contact("Not Found", "", "");
        }
        return C;
    }
    public void Delete(String name)
    {
        Integer hashvalue = Hash(name);
        Contact c;
        if(!Table[hashvalue].equals(null))
        {
            Contact c1 = Table[hashvalue];
            String n = c1.name;
	        if(n.equals(name))
	        {
                    c= new Contact("empty","-  ","-  ");
	            Table[hashvalue]=null;
	        }
	        else
	        {
	            int rehashvalue=hashvalue;
	            int i=1;
	            while(!Table[rehashvalue].name.equals(name) && i<Table.length)
	            {
	                rehashvalue=Rehash(hashvalue, i );
	                if(Table[rehashvalue].equals(null))
		                break;
	                i++;
	                numofCollisions++;
	            }
	            if(Table[rehashvalue].equals(null))
	                System.out.println("contact does not exist");
	            else if(Table[rehashvalue].name.equals(name))
                    {
	                c= new Contact("empty","- ","- ");
                        Table[hashvalue]=null;
                    }
	        }
        }
    }
    public String toString()
    {
        String str="";
        for (int i = 0; i < Table.length; i++) {
            if(Table[i]!=null)
                str=str+"["+i+"] "+Table[i].name+"\n";
            else
                str=str+"["+i+"] "+"null"+"\n";
        }
        return str;
    }
    public String list()
    {
        String str="";
        for (int i = 0; i < Table.length; i++) {
            if(Table[i]!=null)
                str=str+Table[i].name+"  ";
        }
        return str;
    }
    public String list2()
    {
        String str="";
        for (int i = 0; i < Table.length; i++) {
            if(Table[i]!=null)
                str=str+Table[i].Num1+"  ";
        }
        return str;
    }
    public String list3()
    {
        String str="";
        for (int i = 0; i < Table.length; i++) {
            if(Table[i] != null){
                if(Table[i].Num2 == "")
                    str = str+"-  ";
                else
                    str=str+Table[i].Num2 + "  ";
            }
        }
        return str;
    }
} 


