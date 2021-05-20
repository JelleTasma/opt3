import com.sun.tools.javac.Main;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class main {
    private static boolean started = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(!started) {
            System.out.println("Wilt u starten?");
            System.out.println("(y/n)");
            String start = scanner.nextLine();
            if(start.equals("y")) {
                Hour.start();
                System.out.println("gelukt! Uw uren worden nu geklokt");
                started = true;
                main(args);
            } else {
                overview(args);
            }
        } else {
            System.out.println("Wilt u stoppen?");
            System.out.println("(y/n)");
            String stop = scanner.nextLine();
            if(stop.equals("y")) {
                started = false;
                Hour.stop();
                overview(args);
            } else {
                overview(args);

            }
        }
    }

    public static void overview(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wilt u uw overzicht zien?");
        System.out.println("(y/n)");
        String overview = scanner.nextLine();
        if(overview.equals("y")) {
            User.overview();
            main(args);
        } else {
            main(args);
        }
    }
}

class User {
    private String username;
    private String email;
    private int phone;
    private static String startTime;
    public static ArrayList<Hour> hours = new ArrayList<Hour>();
    public static ArrayList<TotalHour> totals = new ArrayList<TotalHour>();

    public void User(String username, String email, int phone){
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Boolean addAccount(String username, String email, int phone)
    {
        if ((email != null || phone != 0) && username != null){
            this.username = username;
            this.email = email;
            this.phone = phone;
            return true;
        }
        return false;
    }

    public String getUsername(){return this.username;}
    public String getEmail(){return this.email;}
    public int getPhone(){return this.phone;}
    public static void overview(){
        for(Hour hour : hours) {
            System.out.println(hour.getHour() + " op " + hour.getDate());
        }
    }
}

class Hour {
    private int hour;
    private String date;
    private static Timer timer = new Timer();
    private static int currentlyHour = 0;

    public Hour(int hour, String date) {
        this.hour = hour;
        this.date = date;
        User.hours.add(this);
    }

    public int getHour() {
        return this.hour;
    }

    public String getDate() {
        return this.date;
    }

    public static void start() {
        timer.schedule(new TimerTask() {
            public void run() {
                currentlyHour += 1;
            }
        }, 0, 1 * 1000);
    }

    public static void stop() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        new Hour(currentlyHour, currentDate);
        timer.cancel();
        timer = new Timer();
        currentlyHour = 0;
    }
}

class TotalHour{
    private int totalHour;
    private String date;

    public TotalHour(int totalHour, String date){
        this.totalHour = totalHour;
        this.date = date;
        User.totals.add(this);
    }

    public int getTotalHour(){return this.totalHour;}
    public String getDate(){return this.date;}
}
