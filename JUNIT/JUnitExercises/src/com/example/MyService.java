//package com.example;
//
//public class MyService {
//
//    private ExternalApi api;
//
//    public MyService(ExternalApi api) {
//        this.api = api;
//    }
//
//    public String fetchData() {
//        return api.getData();
//    }
//    public String fetchData(String input) {
//        return api.getData(input);
//    }
//}
package com.example;

public class MyService {

    private ExternalApi api;
    private NotificationService notificationService;

    public MyService(ExternalApi api) {
        this.api = api;
    }
    public MyService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public String fetchData() {
        return api.getData();
    }
    public String fetchData(String input) {
        return api.getData(input);
    }

    public void notifyUser() {
        notificationService.sendNotification("Welcome");
    }
    public void process() {

        api.connect();

        api.getData();

        api.disconnect();
    }
}