link of the question 
https://exploreidea.net/opa-13-nov-2020-xplore-answer-java/

/*
solution in java
*/

import java.util.Scanner;

class baker{
    private int bakerid;
    private String bakername;
    private char bakerclass;
    private double bakerrating;
    private boolean onlinedelivery;
    
    public baker(int a,String b, char c,double d,boolean e){
        this.bakerid=a;
        this.bakername=b;
        this.bakerclass=c;
        this.bakerrating=d;
        this.onlinedelivery=e;
    }
    public int getId(){
        return this.bakerid;
    }
    public String getname(){
        return this.bakername;
    }
    public char getclass(){
        return this.bakerclass;
    }
    public double getrating(){
        return this.bakerrating;
    }
    public boolean getonlinedelivery(){
        return this.onlinedelivery;
    }
}
public class Main
{
	public static void main(String[] args) {
		baker[] a= new baker[4];
		Scanner s=new Scanner(System.in);
		
		for(int i=0;i<a.length;i++){
		    int a1=s.nextInt();
		    s.nextLine();
		    String a2=s.nextLine();
		    char a3=s.next().charAt(0);
		    s.nextLine();
		    double a4=s.nextDouble();
		    s.nextLine();
		    boolean a5=s.nextBoolean();
		    s.nextLine();
		    a[i]=new baker(a1,a2,a3,a4,a5);
		}
		int baker_Id=s.nextInt();
		s.nextLine();
		char Baker_class=s.next().charAt(0);
		s.close();
		
		String val1=findDeliveryType(a,baker_Id);
		if(val1==null)
		 System.out.println("there is no baker with given id");
		else
		 System.out.println(val1);
		 
		baker[] Bk=sortBakerRatingofClass(a,Baker_class);
		if(Bk==null)
		 System.out.println(" Baker with this class is not present ");
		else{
		    for(int i=0;i<Bk.length;i++){
		        System.out.println(Bk[i].getrating());
		    }
		} 
	}
	
	public static String findDeliveryType(baker[] a, int baker_Id){
	    for(int i=0;i<a.length;i++){
	        if(a[i].getId()==baker_Id){
	            if(a[i].getonlinedelivery()){
	                return "Online Delivery Available";
	            }else{
	                return "Online Delivery not Available";
	            }
	        }
	    }
	    return null;
	}
	
	public static baker[] sortBakerRatingofClass(baker[] a,char Baker_class){
	    int c=0;
	    for(int i=0;i<a.length;i++){
	        if(a[i].getclass()==Baker_class){
	            c++;
	        }
	    }
	    baker[] b1=new baker[c];
	    c=0;
	    for(int i=0;i<a.length;i++){
	         if(a[i].getclass()==Baker_class){
	             b1[c++]=a[i];
	         }
	    }
	    for(int i=0;i<b1.length;i++){
	        for(int j=i+1;j<b1.length;j++){
	            if(b1[i].getrating()>b1[j].getrating()){
	                baker tmp=b1[i];
	                b1[i]=b1[j];
	                b1[j]=tmp;
	            }
	        }
	    }
	    return b1;
	}
}

