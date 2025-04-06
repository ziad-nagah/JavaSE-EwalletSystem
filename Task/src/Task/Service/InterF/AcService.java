package Task.Service.InterF;

import Task.Model.Acount;

public interface AcService {
    void addAcount(Acount acount);
    Acount checkAcount(Acount acount , byte count);
    void resetUsername(Acount acount);
    void resetPassword(Acount acount);
    void createAcount();
    void deposit(Acount acount);
    void withdrow(Acount acount);
    void showBalance(Acount acount);
    void trancefare(Acount acount);
    void showAcountDetails(Acount acount);


}
