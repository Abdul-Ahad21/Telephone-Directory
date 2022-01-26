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
public class Contact 
{
	String name;
	String Num1;
        String Num2;
	Contact(String name, String Num1, String Num2)
	{
		this.name=name;
		this.Num1=Num1;
                this.Num2 = Num2;
	}
	public String toString()
	{
		return "Name: " + name + " Primary Number: " + Num1 + " Secondary Number: " + Num2;
	}
        public int compareTo(Contact c)
        {
            if(this.name.compareTo(c.name)>0)
            {
                return 1;
            }
            else if(this.name.compareTo(c.name)>0)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
}

