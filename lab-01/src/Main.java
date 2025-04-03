import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.Exception;
import java.util.*;
import java.time.LocalDate;
import service.SearchExercise;
import streams.entity.*;
import streams.vo.*;

public class Main {
    public static void main(String[] args) {
        /*try
        {
            Task1();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }*/

        /*Task2();*/

        /*Task3();*/

        /*Task4();*/

        /*Task5();*/

        /*Task6();*/

        /*Task7();*/

        /*Task8();*/

        /*Task9();*/

        /*Task10();*/

        /*Task11();*/

        Task12();
    }

    public static void Task12()
    {
        Item apple = new Item("Apple", null, new BigDecimal("1.5"));
        Item jalapeno = new Item("Jalapeno", "Spicy", new BigDecimal("20"));
        User user = new User();
        Order order = new Order(PaymentMethod.CASH_ON_DELIVERY);
        OrderLine line1 = new OrderLine(apple, false, 5);
        OrderLine line2 = new OrderLine(jalapeno, true, 15);
        order.addOrderLine(line1);
        order.addOrderLine(line2);
        order.setStatus(OrderStatus.ACTIVE);
        user.addOrder(order);

        System.out.println(SearchExercise.getActiveOrders(user));
        System.out.println(SearchExercise.getActiveOrdersByIteration(user));

        System.out.println(SearchExercise.getOrderById(user.getOrders(), 1000));
        System.out.println(SearchExercise.getOrderByIdIteration(user.getOrders(), 1001));

        System.out.println(SearchExercise.hasActiveOrders(user));

        System.out.println(SearchExercise.canBeReturned(order));

        System.out.println(SearchExercise.getMaxPriceOrder(user));

        System.out.println(SearchExercise.getMaxPriceOrder(user));

    }

    public static void Task11()
    {
        // Step 1: Create flight legs (from airport, to airport, date)
        FlightLeg leg1 = new FlightLeg("LBSF", "EBBR", LocalDate.of(2025, 2, 26));
        FlightLeg leg2 = new FlightLeg("EBBR", "LBSF", LocalDate.of(2025, 2, 27));
        FlightLeg leg3 = new FlightLeg("LBSF", "EGLL", LocalDate.of(2025, 3, 1));
        FlightLeg leg4 = new FlightLeg("EGLL", "EBBR", LocalDate.of(2025, 3, 2));

        // Step 2: Create an aircraft and associate flight legs with it
        Aircraft aircraft = new Aircraft("9H-VCA");
        aircraft.addFlightLeg(leg1);
        aircraft.addFlightLeg(leg2);
        aircraft.addFlightLeg(leg3);
        aircraft.addFlightLeg(leg4);

        // Step 3: Use a map to associate the aircraft tail number with its flight legs
        Map<String, List<FlightLeg>> aircraftData = new HashMap<>();
        aircraftData.put(aircraft.getTailNumber(), aircraft.getFlightLegs());

        // Step 4: Display all flight legs for the aircraft
        System.out.println("=== Flight Legs for Aircraft " + aircraft.getTailNumber() + " ===");
        for (FlightLeg flightLeg : aircraftData.get("9H-VCA")) {
            System.out.println(flightLeg);
        }

        // Step 5: Filter and display flight legs involving the airport LBSF
        System.out.println("\n=== Flight Legs Involving LBSF Airport ===");
        List<FlightLeg> filteredLegs = aircraft.filterLegsByAirport("LBSF");
        for (FlightLeg filteredLeg : filteredLegs) {
            System.out.println(filteredLeg);
        }
    }

    public static void Task10()
    {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        System.out.println(countMappings(map));
    }

    public static <K,V> int countMappings(Map<K,V> map)
    {
        return map.size();
    }

    public static void Task9()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        replaceSecondElement(list, "Grapes");
        System.out.println(list);
    }

    public static <T> void replaceSecondElement(ArrayList<T> arr, T element)
    {
        arr.set(1, element);
    }

    public static void Task8()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        boolean found = searchElement(list, "Bob");
        System.out.println(found);
    }

    public static <T> boolean searchElement(ArrayList<T> arr, T element)
    {
        return arr.contains(element);
    }

    public static void Task7()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
        removeThirdElement(list);
        System.out.println(list);
    }

    public static <T> void removeThirdElement(ArrayList<T> arr)
    {
        arr.remove(2);
    }

    public static void Task6()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        String element = retrieveElement(list, 1);
        System.out.println(element);
    }

    public static <T> T retrieveElement(ArrayList<T> arr, int i)
    {
        return arr.get(i);
    }

    public static void Task5()
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        InsertAt(list, 0,"John");
        System.out.println(list);
    }

    public static <Type> void InsertAt(ArrayList<Type> arr, int i, Type element)
    {
        arr.add(i, element);
    }

    public static void Task4()
    {
        Person person1 = new Person();
        System.out.println(person1);
        Person person2 = new Person("Alice");
        System.out.println(person2);
        Person person3 = new Person("Bob", 25);
        System.out.println(person3);
    }

    public static void Task3()
    {
        // Immutable String
        String s = "Hello";
        s.concat(" World"); // Not modifying original string
        System.out.println("String: " + s); // Output: Hello

        // Mutable StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Modifies the original object
        System.out.println("StringBuilder: " + sb); // Output: Hello World
    }

    public static void Task2()
    {
        // Autoboxing (int -> Integer)
        int num = 10;
        Integer obj = num;
        System.out.println("Autoboxed: " + obj);

        // Unboxing (Integer -> int)
        Integer wrappedNum = 20;
        int primitiveNum = wrappedNum;
        System.out.println("Unboxed: " + primitiveNum);
    }

    public static void Task1() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: n = ");
        int n = scanner.nextInt();
        System.out.print("Enter elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter k: k = ");
        int k = scanner.nextInt();
        int kthOddElement = NthOddElement(arr,k);
        if(kthOddElement == -1)
        {
            throw new Exception("Index out of bounds for odd elements");
        }
        String orderString = "th";
        if(k % 10 == 1)
        {
            orderString = "st";
        }
        else if(k % 10 == 2)
        {
            orderString = "nd";
        }
        else if(k % 10 == 3)
        {
            orderString = "rd";
        }
        if(k == 11 || k == 12 || k == 13)
        {
            orderString = "th";
        }
        System.out.print("The " + k + "-" + orderString + " odd element is " + kthOddElement);
    }

    public static int NthOddElement(int[] arr, int n)
    {
        if(n <= 0) return -1;
        int i = 0;
        while(n > 0 && i < arr.length)
        {
            if(arr[i] % 2 == 1)
            {
                n--;
            }
            i++;
        }
        if(n == 0)
        {
            return arr[i-1];
        }
        return -1;
    }
}
