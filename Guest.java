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

        setfName(scan.nextLine());
        setlName(scan.nextLine());
        setCcn(scan.nextLine());

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
        // TODO Auto-generated method stub
        return super.toString();
    }
}