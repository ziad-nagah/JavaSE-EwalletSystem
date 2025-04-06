package Task.Service;

import Task.Model.Acount;
import Task.Model.WhalletHQ;
import Task.Service.InterF.AcService;
import Task.Service.InterF.DValidation;
import java.util.*;

public class AcountService implements AcService {
 private final DValidation dValidation= new DataValidation();
 private final WhalletHQ whalletHQ = new WhalletHQ();
    @Override
    public void addAcount(Acount acount) {
       Acount user = dValidation.userVerfication(acount.getUserName());
       boolean pass = dValidation.passwordVerfication(acount.getPassword());
        if(user == null && pass){
            whalletHQ.getAcounts().add(acount);
        } else if (user != null && pass) {
            throw new InputMismatchException("User Name is already Exists");
        }
    }

    @Override
    public Acount checkAcount(Acount acount , byte count) {
        Acount testusr = dValidation.userVerfication(acount.getUserName());

            if (testusr != null && testusr.getUserName().equals(acount.getUserName())){if(count == 4 || !testusr.isActive()){testusr.setActive(false); throw new InputMismatchException("Sorry you can't Log in any more unless you come to our HQ");}
            if(acount.getPassword().equals(testusr.getPassword())){
                if (testusr.isActive()){return testusr;}else {throw new InputMismatchException("You're Not Active ");}
            }else{throw new InputMismatchException("Wrong Password Please Try Again , you have only "+(4-count)+" trials");}
            }

        throw new InputMismatchException("Sorry the User Name isn't true or not Exist, "+(count!=4?"you have only "+(4-count):"You are out of")+" trials");
        }


    @Override
    public void resetUsername(Acount acount) {
        Scanner scanner7 = new Scanner(System.in);
        System.out.println("________Reset UserName___________");
        while (true){
            System.out.println("Enter your new user name ");
            String user = scanner7.nextLine();
            try {
                Acount newUser = dValidation.userVerfication(user);
                if(newUser == null){acount.setUserName(user);break;}
                else {System.out.println("The user name is already exist");}
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public void resetPassword(Acount acount) {
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("______Reset Password_________");
        while (true){
            try{
                System.out.println("Enter your new password");
                String pass = scanner6.nextLine();
                boolean newPass = dValidation.passwordVerfication(pass);
                if(newPass){acount.setPassword(pass);}
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void createAcount() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("______Create Account______");
        // Entring the Data
        while (true){
            System.out.println("Enter UserName(Must be Unique!)");
            String user = scanner3.nextLine();
            System.out.println("Enter Password (Must be more than 8  chars)");
            String pass = scanner3.nextLine();
            //Check Validation
            Acount acount = new Acount(user, pass);
            try {
                addAcount(acount);
                System.out.println("Created Successfully at " + acount.getCreatedAt());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    @Override
    public void deposit(Acount acount){
        Scanner scanner4 = new Scanner(System.in);
        showBalance(acount);
        System.out.println("Enter the Amount :");
        int prc = scanner4.nextInt();
        acount.setBalance((acount.getBalance() + prc));
        System.out.println("done , your Balance now :" + acount.getBalance());

    }
    @Override
    public void withdrow(Acount acount){
        Scanner scanner4 = new Scanner(System.in);
        showBalance(acount);
        while (true) {
            System.out.println("Enter the Amount :");
           int prc = scanner4.nextInt();
            if (prc > acount.getBalance()) {
                System.out.println("Enter valid price !");
            } else {
                acount.setBalance((acount.getBalance() - prc));
                System.out.println("done , your Balance now :" + acount.getBalance());
                break;
            }
        }
    }
    @Override
    public void showBalance(Acount acount){
        System.out.println("Available : " + acount.getBalance() + "$");
    }

    @Override
    public void trancefare(Acount acount){
        Scanner scanner8 = new Scanner(System.in);
        System.out.println("Enter the user name to send to");
        String reciever = scanner8.nextLine();
        Acount rec = dValidation.userVerfication(reciever);
        System.out.println(acount.getBalance() + " $");
        System.out.println("Enter the price");
        int price = scanner8.nextInt();


       if (rec != null && acount.getBalance()>price){rec.setBalance(rec.getBalance() + price);acount.setBalance(acount.getBalance() - price);}
       else if (rec == null){System.out.println("The user name doesn't exist");}
       else if (acount.getBalance()<price) {System.out.println("You don't have enough money");}
    }

    @Override
    public void showAcountDetails(Acount acount) {
        System.out.println("Details:");
        System.out.println("User Name: " + acount.getUserName());
        System.out.println("password: "+ acount.getPassword().replace(acount.getPassword().substring(3,8),"*****"));
        System.out.println("created at: " +acount.getCreatedAt() );
        System.out.println("logs:\n"+acount.getLogs());
    }
}

