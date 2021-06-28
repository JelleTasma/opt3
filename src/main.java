import com.sun.tools.javac.Main;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class main {
    // The user who is logged in
    public static User user;
    private static Boolean create = false;

    public static void main(String[] args) {
        if(!create){
            userFactory user = new userFactory();
            user.create("admin");
            user.create("user");
            create = true;
        }
        Scanner scanner = new Scanner(System.in);
        // check if any user is logged in, if not ask user to loggin or register
        if (user == null) {
            System.out.println("1. Inloggen");
            System.out.println("2. Registreren");
            System.out.println("Maak een keuze:");
            int log = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");
            // check if user wants to login
            switch(log){
                case 1:
                    user = Login.login();
                    break;
                // check if user want to register
                case 2:
                    user = Login.register();
                    break;
                default:
                    System.out.println("Verkeerde invoer");
                    main(args);
            }
            // if something went wrong block here
            if (user == null) {
                System.out.println("Geen gebruiker gevonden!");
                main(args);
            }
        }
        // if logged in show menu
        System.out.println("Maak een keuze:");
        // check if user started with his work day
        if(!user.getStarted()) {
            System.out.println("1. Starten");
        } else {
            System.out.println("1. Stoppen");
        }
        System.out.println("2. Overzicht");
        System.out.println("3. Uitloggen");
        System.out.println("Voer het getal in:");
        int chosen = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        // check if user wants to start or stop with clocking
        if(chosen == 1 && !user.getStarted()){
            Hour.start(user);
            user.setStarted(true);
            main(args);
        } else if (chosen == 1 && user.getStarted()){
            Hour.stop(user);
            user.setStarted(false);
            main(args);
            //check if user wants to see his overview
        } else if(chosen == 2){
            user.overview();
            main(args);
            // check if user wants to logout
        } else if(chosen == 3) {
            user = null;
            main(args);
            // if user puts another number in block here
        } else {
            System.out.println("Verkeerde invoer!");
            main(args);
        }
    }
}

class User {
    private boolean started;
    private String username;
    private String password;
    private String email;
    private int phone;
    private Boolean admin;
    private String startTime;
    private String startMonth;
    private static final ArrayList<User> users = new ArrayList<>();
    public ArrayList<Hour> hours;

    // make a new user in the constructor
    public User(String username, String password, String email, int phone, Boolean admin){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.startTime = null;
        this.startMonth = null;
        this.started = false;
        this.hours = new ArrayList<>();
        users.add(this);
    }

    // add the get and set methods
    public String getUsername(){return this.username;}
    public String getPassword(){return password;}
    public static ArrayList getUsers(){return users;}
    public Boolean getStarted(){return this.started;}
    public void setStarted(Boolean start){this.started = start;}
    public String getStartTime(){return this.startTime;}
    public void setStartTime(String time){this.startTime = time;}
    public String getStartMonth(){return this.startMonth;}
    public void setStartMonth(String time){this.startMonth = time;}

    // make the overview method who calculate the total hours
    public void overview(){
        int totalSeconds;
        int totalMinutes;
        System.out.println("Losse uren:");
        // show the hours every day and calculate the hours from start to end
        for(Hour hour : this.hours) {
            if (!hour.getTotal()) {
                int hoursStart = Integer.parseInt(hour.getStarted().substring(11,13));
                int minutesStart = Integer.parseInt(hour.getStarted().substring(14,16));
                int secondsStart = Integer.parseInt(hour.getStarted().substring(17));
                int hoursEnd = Integer.parseInt(hour.getStopped().substring(11, 13));
                int minutesEnd = Integer.parseInt(hour.getStopped().substring(14,16));
                int secondsEnd = Integer.parseInt(hour.getStopped().substring(17));
                int totalHours = hoursEnd - hoursStart;
                if(minutesEnd < minutesStart){
                    totalMinutes = (minutesEnd + 60) - minutesStart;
                } else {
                    totalMinutes = minutesEnd - minutesStart;
                }

                if(secondsEnd < secondsStart){
                    totalSeconds = (secondsEnd + 60) - secondsStart;
                } else {
                    totalSeconds = secondsEnd - secondsStart;
                }

                System.out.println("van " + hour.getStarted() + " tot " +  hour.getStopped() + " : " + totalMinutes + " uur en " + totalSeconds + " minuten");
            }
        }
        System.out.println(" ");
        System.out.println("Aantal uren einde maand:");
        // show every the amound of hours in the end of the month
        for(Hour hour : hours) {
            if (hour.getTotal()) {
                System.out.println("van " + hour.getStarted() + " tot " +  hour.getStopped() + " : " + hour.getHour());
            }
        }
        System.out.println(" ");
    }
}

class Hour {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter dtftime = DateTimeFormatter.ofPattern("HH:mm:ss");
    private int hour;
    private Boolean total;
    private String date;
    private String started;
    private String stopped;
    private static Timer timer = new Timer();
    private static int currentlyHour = 0;
    private static int currentMonth = 0;

    // make new hour and add it to the user his arraylist
    public Hour(int hour, String date, Boolean total, String started, String stopped) {
        this.hour = hour;
        this.date = date;
        this.total = total;
        this.started = started;
        this.stopped = stopped;
        main.user.hours.add(this);
    }
    // make the get methods
    public Boolean getTotal(){return this.total;}
    public int getHour() {return this.hour; }
    public String getDate() {return this.date; }
    public String getStarted(){return this.started;}
    public String getStopped(){return this.stopped;}

    // make the start function, that adds the start time to the user
    public static void start(User user) {
        LocalDateTime now = LocalDateTime.now();
        timer.schedule(new TimerTask() {
            public void run() {
                currentlyHour += 1;
            }
        }, 0, 1000);
        user.setStartTime(dtftime.format(now));
        user.setStartMonth(dtf.format(now));
    }
    // The stop function adds the end time to the user
    public static void stop(User user) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        String currentTime = dtftime.format(now);
        new Hour(currentlyHour, currentDate, false, user.getStartMonth() + " " + user.getStartTime(), currentDate + " " + currentTime);
        user.setStartTime(null);
        timer.cancel();
        timer = new Timer();
        currentMonth += currentlyHour;
        currentlyHour = 0;
        // ask if the user wants to ends the month end add the total to his account
        System.out.println("Wilt u de maand afsluiten?");
        System.out.println("y/n");
        String end = scanner.nextLine();
        if(end.equals("y")){
            new Hour(currentMonth, currentDate,true, user.getStartMonth(), dtf.format(now));
            user.setStartMonth(null);
            currentMonth = 0;
            System.out.println("De maand is afgesloten!");
        }
        System.out.println(" ");
    }
}

class Login{
    private static final ArrayList<User> users = User.getUsers();

    // The login method ask the username and password and checks if they exist
    public static User login(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Voer uw gebruikersnaam in:");
        String username = scanner.nextLine();
        System.out.println("Voer uw wachtwoord in:");
        String password = scanner.nextLine();
        System.out.println(" ");
        AuthenticationNormal Auth = new AuthenticationNormal();
        if(!Auth.Authentication(username, password)){return null;};
        for (User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // The register method collects all the data that's needed to create a new user
    public static User register(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Voer uw gebruikersnaam in:");
        String username = scanner.nextLine();
        System.out.println("Voer uw wachtwoord in:");
        String password = scanner.nextLine();
        System.out.println("Voer uw email in:");
        String email = scanner.nextLine();
        System.out.println("Voer uw telefoonnummer in 06:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        return new User(username, password, email, phone, false);
    }
}

abstract class Authentication{
    // create the methods, but make them abstract
    public abstract Boolean checkUsername(String username);
    public abstract Boolean checkPassword(String password);

    // Authentication splits the username and password to two functions
    public Boolean Authentication(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            return true;
        }
        return false;
    }
}
// The simple class checks the username, but returns always true by password;
class AuthenticationSimple extends Authentication{
    private final ArrayList<User> users = User.getUsers();
    @Override
    public Boolean checkUsername(String username){
        for (User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean checkPassword(String password){
        return true;
    }
}

// the normal class checks the username and password for real;
class AuthenticationNormal extends Authentication{
    private final ArrayList<User> users = User.getUsers();
    @Override
    public Boolean checkUsername(String username){
        for (User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean checkPassword(String password){
        for (User user : users){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

// interface for the type of users
interface userTypes{
    public void generate();
}

// the class for normal users
class normalUser implements userTypes{
    @Override
    public void generate(){
        User user1 = new User("q", "q", "jelletasma@live.nl", 12345678, false);
    }
}

// the class for admins
class admin implements userTypes{
    @Override
    public void generate(){
        User user1 = new User("p", "p", "jelletasma@live.nl", 12345678, true);
    }
}

// the interface for the factory (abstract factory)
interface AbstractFactory<T> {
    T create(String userType) ;
}

// the user factory that will make users
class userFactory implements AbstractFactory<userTypes> {
    @Override
    public userTypes create(String userType) {
        if ("admin".equalsIgnoreCase(userType)) {
            userTypes admin = new admin();
            admin.generate();
            return admin;
        } else if ("user".equalsIgnoreCase(userType)) {
            userTypes user = new normalUser();
            user.generate();
            return user;
        }

        return null;
    }
}