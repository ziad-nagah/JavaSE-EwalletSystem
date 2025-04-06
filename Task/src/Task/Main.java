
package Task;

import Task.Service.ApplicationService;
import Task.Service.InterF.AppService;

public class Main {
    public static void main(String[] args) {
        AppService appService = new ApplicationService();
        appService.StartApp();
    }
}
