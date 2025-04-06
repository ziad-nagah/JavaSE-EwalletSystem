package Task.Service;

import Task.Model.Acount;
import Task.Model.WhalletHQ;
import Task.Service.InterF.DValidation;

import java.util.InputMismatchException;
import java.util.List;

public class DataValidation implements DValidation {
    private final WhalletHQ whalletHQ = new WhalletHQ();
    private final List<Acount> acounts = whalletHQ.getAcounts();
    @Override
    public Acount userVerfication(String user) {

        if(user.isEmpty()){throw new InputMismatchException("The filed is empty please enter your user name ");}
        for(Acount a : acounts){
            if (a.getUserName().equals(user)){
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean passwordVerfication(String pass) {
        if(pass.length() < 8){
            throw new InputMismatchException(" the password must be more than 8 chars");
        }
        return true;
    }
}
