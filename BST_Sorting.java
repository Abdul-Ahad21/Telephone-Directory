/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author User
 */
class node<T> {
    T data;
    T primary_Num;
    T secondary_Num;
    node<T> left; node<T> right;

    node(T d, T p_N, T s_N){
        data=d;
        primary_Num= p_N;
        secondary_Num= s_N;
    }
}

public class BST_Sorting<T extends Comparable<T>> {
    node<T> root;
    PhoneDirectory p = Application.get_P();
	
    public void insert(T key, T p_N, T s_N){ // required non-recursive implementation
        node<T> n= new node<T>(key,p_N,s_N);
        node<T> tempprev=root;
        node<T> temp=root;
        if(root==null)
            root=n;
        else
        {
            while(temp!=null)
            {
                tempprev=temp;
                if(n.data.compareTo(temp.data)>=0)
                    temp=temp.right;
                else 
                    temp=temp.left;
            }
            if(n.data.compareTo(tempprev.data)>=0)
               tempprev.right=n;
            else 
               tempprev.left=n;
        }
    }
    public void LNR(node n)
    {
        if(n==null)
            return;
        else
        {
            LNR(n.left);
            p.populate((String)n.data, (String)n.primary_Num, (String)n.secondary_Num);
            LNR(n.right);
        }
    }


}
