/*
java question 28 march
https://exploreidea.net/cpa-28-mar-2021-xplore-answer-java/
*/
import java.util.Scanner;
class theater{
    private int id;
    private String name;
    private int seatCapacity;
    private double theaterrate;
    private double rating;
    private boolean balconyavailable;

    public theater(int a,String b,int c,double d,double e,boolean f){
        this.id=a;
        this.name=b;
        this.seatCapacity=c;
        this.theaterrate=d;
        this.rating=e;
        this.balconyavailable=f;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getSeatCapacity(){
        return this.seatCapacity;
    }
    public double getTheaterRate(){
        return this.theaterrate;
    }
    public double getRating(){
        return this.rating;
    }
    public boolean isBalconyAvailable(){
        return this.balconyavailable;
    }
}
public class Main1
{
	public static void main(String[] args) {
		theater[] ar=new theater[4];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<ar.length;i++){
		    int a1=s.nextInt();
		    s.nextLine();
		    String a2=s.nextLine();
		    int a3=s.nextInt();
		    s.nextLine();
		    double a4=s.nextDouble();
		    s.nextLine();
		    double a5=s.nextDouble();
		    s.nextLine();
		    boolean a6=s.nextBoolean();
		    s.nextLine();
          ar[i]=new theater(a1,a2,a3,a4,a5,a6);
		}
		int TheaterId=s.nextInt();
		s.nextLine();
		int TheaterSeatCapacity=s.nextInt();
		s.close();

		String val1=findTheaterCategory(ar,TheaterId);
		if(val1==null)
		 System.out.println("not available");
		else
		 System.out.println(val1);

		theater[] obj= SearchTheaterbyCategory(ar,TheaterSeatCapacity);
		if(obj==null)
		 System.out.println("not available");
		else{
		    for(int i=0;i<obj.length;i++){
		        System.out.println(obj[i].getId());
		    }
		}
	}
	public static String findTheaterCategory(theater[] ar,int TheaterId){
	    for(int i=0;i<ar.length;i++){
	        if(ar[i].getId()==TheaterId){
	            if(ar[i].isBalconyAvailable() && ar[i].getRating()>4){
	                return "Ultra Premium !";
	            }
	            else if(ar[i].isBalconyAvailable() && (ar[i].getRating()<4 && ar[i].getRating() >= 4) ){
	                return "Primium !";
	            }
	            else{
	                return "Normal :)";
	            }
	        }
	    }
	    return null;
	}
	public static theater[] SearchTheaterbyCategory(theater[] ar,int TheaterSeatCapacity){
	    int c=0;
	    for(int i=0;i<ar.length;i++){
	        if(ar[i].getSeatCapacity() > TheaterSeatCapacity){
	            c++;
	        }
	    }

	    if(c==0)
	     return null;
	    theater[] ob=new theater[c];
	    c=0;
	    for(int i=0;i<ar.length;i++){
	        if(ar[i].getSeatCapacity() > TheaterSeatCapacity){
	           ob[c++]=ar[i];
	        }
	    }

	    for(int i=0;i<ob.length;i++){
	        for(int j=i+1;j<ob.length;j++){
	            if(ob[i].getTheaterRate() < ob[j].getTheaterRate()){
	                theater tmp=ob[i];
	                ob[i]=ob[j];
	                ob[j]=tmp;
	            }
	        }
	    }
	    return ob;
	}
}
