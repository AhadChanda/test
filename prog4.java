import java.io.*;
import java.util.*;
class record{
int attr[] = new int[7];
}
public class prog4{
static record[] rc = new record[2];
public static void main(String args[]) throws FileNotFoundException,IOException
{
BufferedReader CSV=new BufferedReader(new FileReader(new File("data4.csv")));
String data=CSV.readLine();
int totalOfCol[] = new int[7];
int i=0;
while(data!=null)
{
rc[i]=new record();
String[] dataArray=data.split(",");
for(int j=0;j<7;j++)
 	rc[i].attr[j]=Integer.parseInt(dataArray[j]);
data=CSV.readLine();
i++;
}
double entropyOfCol[] = new double[7];
double giniOfCol[] = new double[7];
double entropy[] = new double[3];
double gini[] = new double[3];
double gain[] = new double[3];
//total of col
for(i=0; i<rc.length; i++){
			for(int j=0; j<totalOfCol.length; j++){
				totalOfCol[j] += rc[i].attr[j];
			}
}
//calculateentgini
for(i = 0; i<rc.length; i++){
			for(int j=0; j<totalOfCol.length; j++){
				double temp = rc[i].attr[j]/(totalOfCol[j]*1.0);
				giniOfCol[j] += Math.pow(temp, 2);
				entropyOfCol[j] += temp * Math.log(temp)/ Math.log(2);
			}
}
for(i=0; i<totalOfCol.length; i++){
			giniOfCol[i] = 1 - giniOfCol[i];
			entropyOfCol[i] = -1 * entropyOfCol[i];
		}
		int x=totalOfCol[4] + totalOfCol[5] + totalOfCol[6];
		gini[0] = (giniOfCol[0] * totalOfCol[0] / (totalOfCol[0] + totalOfCol[1])) + (giniOfCol[1] * totalOfCol[1]/ (totalOfCol[0] + totalOfCol[1]));
		gini[1] = (giniOfCol[2] * totalOfCol[2] / (totalOfCol[2] + totalOfCol[4])) + (giniOfCol[3] * totalOfCol[3]/ (totalOfCol[2] + totalOfCol[3]));
		gini[2] = (giniOfCol[4] * totalOfCol[4] / x) + (giniOfCol[5] * totalOfCol[5]/ x) + (giniOfCol[6] * totalOfCol[6]/ x);
		entropy[0] = (entropyOfCol[0] * totalOfCol[0] / (totalOfCol[0] + totalOfCol[1])) + (entropyOfCol[1] * totalOfCol[1]/ (totalOfCol[0] + totalOfCol[1]));
		entropy[1] = (entropyOfCol[2] * totalOfCol[2] / (totalOfCol[2] + totalOfCol[4])) + (entropyOfCol[3] * totalOfCol[3]/ (totalOfCol[2] + totalOfCol[3]));
		entropy[2] = (entropyOfCol[4] * totalOfCol[4] / x) + (entropyOfCol[5] * totalOfCol[5]/ x) + (entropyOfCol[6] * totalOfCol[6]/ x);
	
		double parentEntropy=1.0;
	    double parentGini=0.5;
	    for(i=0; i<gini.length; i++){
	    	gain[i] = parentEntropy - entropy[i];
	    }	    
	    System.out.println("Parent:");
	    System.out.println("Entropy: " + parentEntropy);
	    System.out.println("Gini: " + parentGini);
	    
	    System.out.println("\nNumerical Attributes: ");
	    System.out.println("Entropy: " + entropy[0]);
	    System.out.println("Gain: " + gain[0]);
	    System.out.println("Gini: " + gini[0]);
	    
	    System.out.println("\nBinary Attributes: ");
	    System.out.println("Entropy: " + entropy[1]);
	    System.out.println("Gain: " + gain[1]);
	    System.out.println("Gini: " + gini[1]);
	    
	    System.out.println("\nMultiway split Attributes: ");
	    System.out.println("Entropy: " + entropy[2]);
	    System.out.println("Gain: " + gain[2]);
		System.out.println("Gini: " + gini[2]);
}
}
