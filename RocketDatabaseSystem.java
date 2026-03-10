import java.util.*;

class Rocket
{
    String name;
    String agency;
    int launchYear;

    Rocket(String n,String a,int y)
    {
        name=n;
        agency=a;
        launchYear=y;
    }

    void display()
    {
        System.out.println(name+" | "+agency+" | "+launchYear);
    }
}

public class RocketDatabaseSystem
{

    static ArrayList<Rocket> rockets = new ArrayList<>();

    static Stack<String> launchHistory = new Stack<>();

    static Queue<String> launchQueue = new LinkedList<>();


    // ADD ROCKET
    static void addRocket(Scanner sc)
    {
        System.out.print("Enter Rocket Name: ");
        String name=sc.nextLine();

        System.out.print("Enter Agency: ");
        String agency=sc.nextLine();

        System.out.print("Enter Launch Year: ");
        int year=sc.nextInt();
        sc.nextLine();

        rockets.add(new Rocket(name,agency,year));

        System.out.println("Rocket Added Successfully\n");
    }


    // DISPLAY ROCKETS
    static void displayRockets()
    {
        if(rockets.isEmpty())
        {
            System.out.println("No Rockets in Database\n");
            return;
        }

        System.out.println("\nRocket Database");

        for(Rocket r: rockets)
        {
            r.display();
        }

        System.out.println();
    }


    // LINEAR SEARCH
    static void linearSearch(Scanner sc)
    {
        System.out.print("Enter Rocket Name to Search: ");
        String key=sc.nextLine();

        boolean found=false;

        for(Rocket r: rockets)
        {
            if(r.name.equalsIgnoreCase(key))
            {
                r.display();
                found=true;
            }
        }

        if(!found)
            System.out.println("Rocket Not Found\n");
    }


    // BUBBLE SORT
    static void bubbleSort()
    {
        for(int i=0;i<rockets.size()-1;i++)
        {
            for(int j=0;j<rockets.size()-i-1;j++)
            {
                if(rockets.get(j).name.compareTo(rockets.get(j+1).name)>0)
                {
                    Rocket temp=rockets.get(j);
                    rockets.set(j,rockets.get(j+1));
                    rockets.set(j+1,temp);
                }
            }
        }

        System.out.println("Rockets Sorted by Name\n");
    }


    // BINARY SEARCH
    static void binarySearch(Scanner sc)
    {
        bubbleSort();

        System.out.print("Enter Rocket Name: ");
        String key=sc.nextLine();

        int low=0;
        int high=rockets.size()-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            int cmp=rockets.get(mid).name.compareToIgnoreCase(key);

            if(cmp==0)
            {
                rockets.get(mid).display();
                return;
            }

            else if(cmp<0)
                low=mid+1;

            else
                high=mid-1;
        }

        System.out.println("Rocket Not Found\n");
    }


    // STACK OPERATIONS
    static void addLaunchHistory(Scanner sc)
    {
        System.out.print("Enter Launch Mission: ");
        String mission=sc.nextLine();

        launchHistory.push(mission);

        System.out.println("Mission added to Launch History\n");
    }

    static void showLaunchHistory()
    {
        if(launchHistory.isEmpty())
        {
            System.out.println("No Launch History\n");
            return;
        }

        System.out.println("Launch History (LIFO)");

        for(String s: launchHistory)
        {
            System.out.println(s);
        }
    }


    // QUEUE OPERATIONS
    static void addLaunchQueue(Scanner sc)
    {
        System.out.print("Enter Upcoming Mission: ");
        String mission=sc.nextLine();

        launchQueue.add(mission);

        System.out.println("Mission added to Launch Queue\n");
    }

    static void processLaunchQueue()
    {
        if(launchQueue.isEmpty())
        {
            System.out.println("No Missions in Queue\n");
            return;
        }

        System.out.println("Processing Launch: "+launchQueue.poll());
    }



    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);

        int choice;

        do
        {

            System.out.println("\n===== Rocket Database System =====");

            System.out.println("1 Add Rocket");
            System.out.println("2 Display Rockets");
            System.out.println("3 Linear Search Rocket");
            System.out.println("4 Binary Search Rocket");
            System.out.println("5 Sort Rockets");
            System.out.println("6 Add Launch History (Stack)");
            System.out.println("7 Show Launch History");
            System.out.println("8 Add Launch Queue");
            System.out.println("9 Process Launch Queue");
            System.out.println("0 Exit");

            System.out.print("Enter Choice: ");

            choice=sc.nextInt();
            sc.nextLine();


            switch(choice)
            {

                case 1:
                    addRocket(sc);
                    break;

                case 2:
                    displayRockets();
                    break;

                case 3:
                    linearSearch(sc);
                    break;

                case 4:
                    binarySearch(sc);
                    break;

                case 5:
                    bubbleSort();
                    break;

                case 6:
                    addLaunchHistory(sc);
                    break;

                case 7:
                    showLaunchHistory();
                    break;

                case 8:
                    addLaunchQueue(sc);
                    break;

                case 9:
                    processLaunchQueue();
                    break;

                case 0:
                    System.out.println("Exiting Program");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        }while(choice!=0);

    }

}
