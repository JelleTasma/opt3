import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class main {
    private boolean started = false;
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(!started) {
            System.out.println("Wilt u starten?");
            System.out.println("(y/n)");
            String start = scanner.nextLine();
            if(start == "y") {
                User.start();
            }
        } else {
            System.out.println("Wilt u uw overzicht zien?");
            System.out.println("(y/n)");
            String overview = scanner.nextLine();
            if(overview == "y") {
                //User.getOverview();
            }
        }
    }

    public String gab(String terug) {
        return terug;
    }
}

class User {
    private String username;
    private String email;
    private int phone;
    private static String startTime;

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
    public static String start(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        startTime = dtf.format(now);
        return dtf.format(now);
    }
}

class Hour{
    private int hour;
    private String date;

    public void User(int hour, String date){
        this.hour = hour;
        this.date = date;
    }

    public int getHour(){return this.hour;}
    public String getDate(){return this.date;}
}

class TotalHour{
    private int totalHour;
    private String date;

    public void User(int totalHour, String date){
        this.totalHour = totalHour;
        this.date = date;
    }

    public int getTotalHour(){return this.totalHour;}
    public String getDate(){return this.date;}
}