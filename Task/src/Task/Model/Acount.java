package Task.Model;

import java.util.Date;

public class Acount {
    // Attributes
    private String userName ;
    private String password ;
    private Date createdAt;
    private boolean active ;
    private StringBuilder logs;
    private int balance;
    // Constructors
    public Acount() {}

    public Acount(String userName, String password) {
        this.userName = userName;
        this.password = password;
        active = true ;
        createdAt = new Date();
        logs = new StringBuilder();
    }
    // Mutators
// Setters

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLogs() {
        logs.append(new Date().toString()).append("\n");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {this.password = password;}
// Getters

    public int getBalance() {
        return balance;
    }

    public StringBuilder getLogs() {return logs;
    }

    public String getUserName() {return userName;}

    public Date getCreatedAt() {return createdAt;}

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}
