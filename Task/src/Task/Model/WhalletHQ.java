package Task.Model;

import java.util.ArrayList;
import java.util.List;

public class WhalletHQ {
    private final String walletName = "ZiadCash$";
    private static List<Acount> acounts = new ArrayList<>();

    //Mutators
// Getters
    public String getWalletName() {
        return walletName;
    }

    public List<Acount> getAcounts() {
        return acounts;
    }
// Setters

    public void setAcounts(List<Acount> acounts) {
        this.acounts = acounts;
    }
}
