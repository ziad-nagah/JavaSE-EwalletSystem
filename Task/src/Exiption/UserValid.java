package Exiption;

public class UserValid {
    void checkVal(String string){

        if(string.length() < 5){
            throw  new RuntimeException(" inter name more than 5 letters");
        }
    }
}
//TODO send the password validation in independent interface then inherit it