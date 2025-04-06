package Exiption;

public class MainE {

    public static void main(String[] args) {
        UserValid userValid = new UserValid();
        try{
            userValid.checkVal("ALi");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
