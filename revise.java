import java.io.*;
import java.util.*;

class revise{
public static void main(String args[]) throws FileNotFoundException, IOException
{
BufferedReader csv = new BufferedReader(new FileReader(new File("data.csv")));
String data = csv.readLine();
HashSet hs = new HashSet<String>();
while(data != null)
{
	String[] dataarray = data.split(",");
	String x = dataarray[0]+dataarray[1]+dataarray[2];
	hs.add(x);
	data = csv.readLine();
}
ArrayList<String> al = new ArrayList<String>(hs);
Collections.sort(al);
hs.clear();
for(int i=0;i<al.size();i++)
{
	for(int j=i+1;j<al.size();j++)
		{
			String x1 = al.get(i);
			String x2 = al.get(j);
			if(x1.charAt(0) == x2.charAt(0) && x1.charAt(1) == x2.charAt(1))
			{
				String result = x1+x2.charAt(2);
				hs.add(result);
			}
		}
}
al = new ArrayList<String>(hs);
Collections.sort(al);
for(int i=0;i<al.size();i++)
{
	System.out.print("[ ");
	String sep="";
	char[] result = (al.get(i)).toCharArray();
	for(char z:result){
		System.out.print(sep+z);
		sep=",";
		}
	System.out.println(" ]");
}
}
}		
