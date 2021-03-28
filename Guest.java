import java.util.Scanner;

public class Guest{
    
    private String fName;
    private String lName;
    private String ccn;

    public Guest(){
        collectData();
    }

    public void collectData(){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first name:");
        setfName(scan.nextLine());
        System.out.println("Enter your last name:");
        setlName(scan.nextLine());
        System.out.println("Enter your credit card Number:");
        setCcn(scan.nextLine());
        //scan.close();

    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCcn(String ccn) {
        this.ccn = ccn;
    }

    @Override
    public String toString() {
        return "Guest [fName=" + fName + ", lName=" + lName + ", ccn=" + ccn + "]";
    }
}