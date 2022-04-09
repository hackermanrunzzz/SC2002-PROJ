package initialize;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.*;
import classmgr.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create restaurant class
 */
public class Restaurant {
    /**
     * resturant opens at 12pm
     */
    public static final int OPENING_HOUR = 12;
    /**
     * restaurant closes at 10pm
     */
    public static final int CLOSING_HOUR = 22;
    /**
     * gst is fixed at 7%
     */
    public static final double gstAmount= 0.07;
    /**
     * service charge is at 10%
     */
    public static final double serviceCharge = 0.1;
    /**
     * array of tables
     */
    public static ArrayList<Table> tables;
    /**
     * table manager in restaurant
     */
    public static TableManager tableManager;
    /**
     * staff manager in restaurant
     */
    public static StaffManager staffManager;
    /**
     * member manager in restaurant
     */
    public static MemberManager memberManager;
    /**
     * menu to order from in restaurant
     */
    public static Menu menu;
    /**
     * all menus in restaurant
     */
    public static Menu allMenu = new Menu();
    /**
     * old menus in restaurant
     */
    public static Menu oldMenu = new Menu();
    /**
     * order manager in restaurant
     */
    public static OrderManager allOrders;
    /**
     * array of pending orders
     */
    public static ArrayList<Order> pendingOrders;
    /**
     * array of paid orders
     */
    public static ArrayList<Order> paidOrders;
    /**
     * array of reservations
     */
    public static ArrayList<Reservation> reservations;
    /**
     * reservation of manager in restaurant
     */
    public static ReservationManager reservationManager;
    /**
     * report in restaurant
     */
    public static Report report;

    /**
     * instantiate staff members and add to staff manager
     */
    public static void initialiseStaff(){
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff(1, "Jerome ", "Waiter", false));
        staffs.add(new Staff(2, "Seth   ", "Waitress", false));
        staffs.add(new Staff(3, "Gladys ", "Waitress", false));
        staffs.add(new Staff(4, "Rachel ", "Chef", false));
        staffs.add(new Staff(5, "Gabriel", "CEO", false));
        Restaurant.staffManager= new StaffManager(staffs);
    }

    /**
     * instantiate tables and add to table manager
     */
    public static void initialiseTables(){
        Restaurant.tableManager = new TableManager();
        ArrayList<Table> tables = new ArrayList<>();
        for(int i =1; i<3; i++){
            tables.add(new Table(i,2));
        }
        for(int i =3; i<5; i++){
            tables.add(new Table(i,4));
        }
        for(int i =5; i<7; i++){
            tables.add(new Table(i,6));
        }
        for(int i =7; i<9; i++){
            tables.add(new Table(i,8));
        }
        for(int i =9; i<11; i++){
            tables.add(new Table(i,10));
        }
        Restaurant.tableManager.setTables(tables);
        Restaurant.tables = tables;
        Restaurant.tables.get(0).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(1).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(2).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(4).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(5).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(3).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(6).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(9).setTableStatus(Table.TableStatus.OCCUPIED);
        Restaurant.tables.get(8).setTableStatus(Table.TableStatus.OCCUPIED);
    }

    /**
     * instantiate menu by adding individual food and promotion items
     */
    public static void initialiseMenu(){
        Menu menu = new Menu();
        Food food1 = new Food("Shepherd's Pie", "A juicy fragrant pie with potato and peas " +
                "with carrots on top.","Main",10.90 );
        Food food2 = new Food("Cheese Burger with Fries", "A hamburger with cheese, lettuce, onion " +
                "and thin crispy fries.","Main",12.90 );
        Food food3 = new Food("Rib-eye Steak", "A tender American Rib-eye Steak " +
                "cooked to your desired done-ness.","Main",15.90 );
        Food food6 = new Food("Molten Lava Cake", "Chocolate cake filled with smooth" +
                " watery chocolate in the middle.","Dessert",6.90 );
        Food food7 = new Food("Blueberry Cheese Cake", "A blueberry cheesecake with" +
                " cream on top.","Dessert",6.90 );
        Food food4 = new Food("Mountain Dew", "A mountain and a dew " +
                "in a can.","Beverage",1.90 );
        Food food5 = new Food("Root-beer Float", "A mug of root-beer with a scoop " +
                "of vanilla ice-cream.","Beverage",4.90 );

        PromotionSet promo1 = new PromotionSet("Burger Set","Cheese Burger with Fries, Mountain Dew" +
                " and a Blueberry Cream Cheese Cake", 20);
        promo1.addFoodToSet(food2);
        promo1.addFoodToSet(food4);
        promo1.addFoodToSet(food6);

        PromotionSet promo2 = new PromotionSet("Steak and Beer Set","Rib-eye Steak, Root-beer Float" +
                " and a Molten Lava Cake", 25);
        promo2.addFoodToSet(food3);
        promo2.addFoodToSet(food5);
        promo2.addFoodToSet(food7);

        menu.addMenu(food1);
        menu.addMenu(food2);
        menu.addMenu(food3);
        menu.addMenu(food4);
        menu.addMenu(food5);
        menu.addMenu(food6);
        menu.addMenu(food7);
        menu.addMenu(promo1);
        menu.addMenu(promo2);

        Restaurant.menu = menu;
        Restaurant.allMenu =menu;
    }

    /**
     * initialise members and add to member manager
     */
    public static void initialiseMembers(){
        ArrayList<Member> members = new ArrayList<Member>();
        Member member1 = new Member("Charmaine Lye", "98224256");
        Member member2 = new Member("Jeslyn Lim","92724627");
        Member member3 = new Member("John Cena","94214789");
        Member member4 = new Member("Peter Chao","85367587");
        Member member5 = new Member("Belgium Jerome","81512514");
        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);

        Restaurant.memberManager = new MemberManager(members);
    }

    /**
     * create array of pending and paid orders
     */
    public static void initialiseOrders(){
        Restaurant.pendingOrders = new ArrayList<Order>();
        Restaurant.paidOrders = new ArrayList<Order>();
    }

    /**
     * create order manager
     */
    public static void initialiseAllOrders(){
        Restaurant.allOrders= new OrderManager(Restaurant.pendingOrders, Restaurant.paidOrders);
    }


    /**
     * This is to simulate the existing reservations
     */
    public static void initialiseReservationManager(){
        ArrayList<Reservation> reservation = new ArrayList<Reservation>();
        // reservationManager.setReservations(Restaurant.reservations);
        //reservationManager.setTables(Restaurant.tables);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2= Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        Calendar calendar6 = Calendar.getInstance();
        Calendar calendar7 = Calendar.getInstance();
        Calendar calendar8 = Calendar.getInstance();
        Calendar calendar9 = Calendar.getInstance();


        String date1 = "13/11/2021 15:30";
        String date2 = "13/11/2021 14:30";
        String date3 = "13/11/2021 21:30";
        String date4 = "13/11/2021 13:30";
        String date5 = "13/11/2021 14:00";
        String date6 = "13/11/2021 18:30";
        String date7 = "14/11/2021 19:30";
        String date8 = "14/11/2021 20:30";
        String date9 = "14/11/2021 21:00";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date d1 = dateFormat.parse(date1);
            calendar1.setTime(d1);
            Date d2 = dateFormat.parse(date2);
            calendar2.setTime(d2);
            Date d3 = dateFormat.parse(date3);
            calendar3.setTime(d3);
            Date d4 = dateFormat.parse(date4);
            calendar4.setTime(d4);
            Date d5 = dateFormat.parse(date5);
            calendar5.setTime(d5);
            Date d6 = dateFormat.parse(date6);
            calendar6.setTime(d6);
            Date d7 = dateFormat.parse(date7);
            calendar7.setTime(d7);
            Date d8 = dateFormat.parse(date8);
            calendar8.setTime(d8);
            Date d9 = dateFormat.parse(date9);
            calendar9.setTime(d9);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reservation res1 = new Reservation(10000, 2, "Jeremiah Wong", 98791269, true, calendar1, 1);
        Reservation res2 = new Reservation(10001, 2, "Bobby Charles", 98352168, true, calendar2, 2);
        Reservation res3 = new Reservation(10002, 5, "Bukayo Saka", 98208367, true, calendar3, 5);
        Reservation res4 = new Reservation(10003, 6, "Emile Smith-Rowe", 87294567, true, calendar4, 6);
        Reservation res5 = new Reservation(10004, 3, "Slyvia Chan", 93934531, true, calendar5, 4);
        Reservation res6 = new Reservation(10005, 8, "Lionel Messi", 98001241, true, calendar6, 7);
        Reservation res7 = new Reservation(10006, 10, "Charmine Lye", 98342112, true, calendar7, 10);
        Reservation res8 = new Reservation(10007, 9, "Vincent Kompany", 87974499, true, calendar8, 9);
        Reservation res9 = new Reservation(10008, 3, "Seth Lye", 87974499, true, calendar9, 3);

        reservation.add(res1);
        reservation.add(res2);
        reservation.add(res3);
        reservation.add(res4);
        reservation.add(res5);
        reservation.add(res6);
        reservation.add(res7);
        reservation.add(res8);
        reservation.add(res9);

        Restaurant.reservationManager = new ReservationManager(reservation, Restaurant.tables);

    }

    /**
     * initialise the report
     */
    public static void initialiseReport(){
        Restaurant.report = new Report();

        Order order1 = new Order();
        for(int i=0; i<184;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(0));}
        for(int i=0; i<166;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(1));}
        for(int i=0; i<151;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(2));}
        for(int i=0; i<161;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(3));}
        for(int i=0; i<145;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(4));}
        for(int i=0; i<131;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(5));}
        for(int i=0; i<121;i++){order1.getMenu().getFoods().add(Restaurant.menu.getFoods().get(6));}
        for(int i=0; i<163;i++){order1.getMenu().getPromos().add(Restaurant.menu.getPromos().get(0));}
        for(int i=0; i<175;i++){order1.getMenu().getPromos().add(Restaurant.menu.getPromos().get(1));}
        order1.setTotalAmount(order1.calculateAmount());
        Invoice invoice1 = new Invoice(1, "96373732", 4, order1, new GregorianCalendar(2021,9,15));
        invoice1 = invoice1.createInvoice(invoice1);


        Order order2 = new Order();
        for(int i=0; i<11;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(0));}
        for(int i=0; i<18;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(1));}
        for(int i=0; i<15;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(2));}
        for(int i=0; i<12;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(3));}
        for(int i=0; i<14;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(4));}
        for(int i=0; i<21;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(5));}
        for(int i=0; i<12;i++){order2.getMenu().getFoods().add(Restaurant.menu.getFoods().get(6));}
        for(int i=0; i<13;i++){order2.getMenu().getPromos().add(Restaurant.menu.getPromos().get(0));}
        for(int i=0; i<16;i++){order2.getMenu().getPromos().add(Restaurant.menu.getPromos().get(1));}
        order2.setTotalAmount(order2.calculateAmount());
        Invoice invoice2 = new Invoice(1,  "96373732",4, order2, new GregorianCalendar(2021,10,12));
        invoice2 = invoice2.createInvoice(invoice2);

        Order order3 = new Order();
        for(int i=0; i<1949;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(0));}
        for(int i=0; i<1768;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(1));}
        for(int i=0; i<1818;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(2));}
        for(int i=0; i<1618;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(3));}
        for(int i=0; i<1677;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(4));}
        for(int i=0; i<1655;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(5));}
        for(int i=0; i<1866;i++){order3.getMenu().getFoods().add(Restaurant.menu.getFoods().get(6));}
        for(int i=0; i<1966;i++){order3.getMenu().getPromos().add(Restaurant.menu.getPromos().get(0));}
        for(int i=0; i<1765;i++){order3.getMenu().getPromos().add(Restaurant.menu.getPromos().get(1));}
        order3.setTotalAmount(order3.calculateAmount());
        Invoice invoice3 = new Invoice(1, "96373732", 4, order3, new GregorianCalendar(2020,10,15));
        invoice3 = invoice3.createInvoice(invoice3);

        Order order4 = new Order();
        for(int i=0; i<1967;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(0));}
        for(int i=0; i<1966;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(1));}
        for(int i=0; i<2231;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(2));}
        for(int i=0; i<1988;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(3));}
        for(int i=0; i<1789;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(4));}
        for(int i=0; i<1865;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(5));}
        for(int i=0; i<2192;i++){order4.getMenu().getFoods().add(Restaurant.menu.getFoods().get(6));}
        for(int i=0; i<2311;i++){order4.getMenu().getPromos().add(Restaurant.menu.getPromos().get(0));}
        for(int i=0; i<2523;i++){order4.getMenu().getPromos().add(Restaurant.menu.getPromos().get(1));}
        order4.setTotalAmount(order4.calculateAmount());
        Invoice invoice4 = new Invoice(1, "96373732", 4, order4, new GregorianCalendar(2021,3,15));
        invoice4 = invoice4.createInvoice(invoice4);

        Restaurant.report.getInvoices().add(invoice1);
        Restaurant.report.getInvoices().add(invoice2);
        Restaurant.report.getInvoices().add(invoice3);
        Restaurant.report.getInvoices().add(invoice4);

    }

    /**
     * This is to set the timer to run schedule for every 50 seconds
     */
    public static void autoRemoveReservations(){
        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(Restaurant.reservationManager.getReservations()); // Instantiate ScheduledTask class
        time.schedule(st, 0,50000); // Create Repetitively task for every 50 seconds
    }

    /**
     * initialise the restaurant
     */
    public static void initialiseRestaurant(){
        initialiseStaff();
        initialiseTables();
        initialiseMenu();
        initialiseMembers();
        initialiseOrders();
        initialiseAllOrders();
        initialiseReservationManager();
        initialiseReport();
        autoRemoveReservations();

    }


}