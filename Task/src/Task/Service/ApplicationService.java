package Task.Service;

import Task.Model.Acount;
import Task.Service.InterF.AcService;
import Task.Service.InterF.AppService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationService implements AppService {
    private final AcService acountService = new AcountService();
    @Override
    public void StartApp(){
        int count = 0 ;
        boolean leave = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________Welcome Sir________________________");

        // App Start
        while (leave){
            System.out.println("___________How Can I Help ?__________");
            System.out.println("1-Login\n2-CreateAcount\n3-Exit");
            try{int choice = scanner.nextInt();
            switch (choice){
                case 1 -> login();
                case 2 -> acountService.createAcount();
                case 3 -> {return;}
                default -> {leave = count == 4? false:true;System.out.println("Invalid inputs you have "+( 4-count)+" Tryals");count++;}
            }
            }catch (InputMismatchException e){scanner.nextLine();leave = count == 4? false:true;System.out.println("Invalid inputs you have "+( 4-count)+" Tryals");count++;}
        }
    }

    private void login() {
        Scanner scanner2 = new Scanner(System.in);
        Acount res = null ;
        byte count = 0;
        System.out.println("______Log In______");
        while (res == null){
            // Entring the Data
            System.out.println("Enter UserName :");
            String user = scanner2.nextLine();
            System.out.println("Enter Password");
            String pass = scanner2.nextLine();
            //Check Validation
            Acount acount = new Acount(user,pass);
            try{
            res = acountService.checkAcount(acount,count);
                if(res != null){res.setLogs();wallet(res);}
            break;
            }catch (Exception e){
                System.out.println(e.getMessage());
                if(count !=4){
                    count++;
                    continue;
                }break;

            }


        }

    }

    private void wallet(Acount acount) {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("_________Welcome "+acount.getUserName()+"___________");

        while (true){
            System.out.println("__________How Can We Help?_________");
            System.out.println("1-Check Balance\n2-Withdraw\n3-Show Login History\n4-Logout\n5-Deposit\n6-change password\n7-change UserName\n8-Trance fare\n9-About You");
            int choice = scanner4.nextInt();
            switch (choice) {
                case 1 -> System.out.println(acount.getBalance() + "$");
                case 2 -> acountService.withdrow(acount);
                case 3 -> System.out.println(acount.getLogs());
                case 4 -> {return;}
                case 5 -> acountService.deposit(acount);
                case 6 -> acountService.resetPassword(acount);
                case 7 -> acountService.resetUsername(acount);
                case 8 -> acountService.trancefare(acount);
                case 9 -> acountService.showAcountDetails(acount);
                default -> System.out.println("Enter a valid input");
            }
        }
    }

}
