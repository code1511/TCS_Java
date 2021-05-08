//cpa-12-mar-2021-xplore-answer-java
/*
question link
https://exploreidea.net/cpa-12-mar-2021-xplore-answer-java/
*/


import java.util.Scanner;
class docter{
    private int docterId;
    private String docterName;
    private double docterfee;
    private boolean sundayAvailable;
    private String department;
    
    public docter(int a, String b,double c,boolean d,String e){
        this.docterId=a;
        this.docterName=b;
        this.docterfee=c;
        this.sundayAvailable=d;
        this.department=e;
    }
    public int getId(){
        return this.docterId;
    }
    public String getName(){
        return this.docterName;
    }
    public double getFee(){
        return this.docterfee;
    }
    public boolean isSundayAvailable(){
        return this.sundayAvailable;
    }
    public String getDepartment(){
        return this.department;
    }
}
public class Main
{
	public static void main(String[] args) {
		docter[] arr=new docter[4];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<arr.length;i++){
		    int a=s.nextInt();
		    s.nextLine();
		    String b=s.nextLine();
		    double c=s.nextDouble();
		    s.nextLine();
		    boolean d=s.nextBoolean();
		    s.nextLine();
		    String e=s.nextLine();
		   // s.nextLine();
		    arr[i]=new docter(a,b,c,d,e);
		}
		String deP=s.nextLine();
		s.close();
		double Dfee=findtotalfeebyDepartment(arr,deP);
		if(Dfee==0)
		 System.out.println("Department not Available");
		else
		 System.out.println(Dfee);
		 
		docter[] obj=searchdocterbyAvialablity(arr);
		if(obj==null)
		 System.out.println("No docter Available on sunday");
		else{
		    for(int i=0;i<obj.length;i++){
		        System.out.println(obj[i].getId());
		    }
		} 
	}
	public static double findtotalfeebyDepartment(docter[] arr,String deP){
	    double f=0;
	    for(int i=0;i<arr.length;i++){
	        if(deP.equalsIgnoreCase(arr[i].getDepartment())){
	            f+=arr[i].getFee();
	        }
	    }
	    return f;
	}
	public static docter[] searchdocterbyAvialablity(docter[] arr){
	    int c=0;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i].isSundayAvailable()){
	            c++;
	        }
	    }
	    if(c==0)
	      return null;
	      
	    docter[] o = new docter[c];
	    int t=0;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i].isSundayAvailable()){
	           o[t++]=arr[i];
	        }
	    }
	    for(int i=0;i<o.length;i++){
	        for(int j=i+1;j<o.length;j++){
	            if(o[i].getId() > o[j].getId()){
	                docter tmp=o[i];
	                o[i]=o[j];
	                o[j]=tmp;
	            }
	        }
	    }
	    return o;
	}
}
