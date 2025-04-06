package Task.Service.InterF;

import Task.Model.Acount;

public interface DValidation {

    Acount userVerfication(String user);
    boolean passwordVerfication(String pass);
}
