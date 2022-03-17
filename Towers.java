import java.util.Scanner;
public class Towers
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    String spare;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the amount of disks to start the game: ");
    int count = input.nextInt();
    System.out.println(count);
    //For checking count

    System.out.println("The towers starting from left to right will be named A, B , C.");
    System.out.println("Choose a tower to start: ");
    String source = input.next();
    System.out.println(source);
    //For checking source

    System.out.println("Choose a tower for the destination: ");
    String destination = input.next();
    System.out.println(destination);
    //For checking destination

    //if method to the remaining tower to spare
    spare = "";
    if ((source.equals("A") && destination.equals("B"))
        || (source.equals("B") && destination.equals("A")))
    {
        spare = "C";
    }
    else if ((source.equals("C") && destination.equals("A"))
        || (source.equals("A") && destination.equals("C")))
    {
        spare = "B";
    }
    else
    {
        spare = "A";
    }

    System.out.println();
    System.out.println(spare + " is the the spare");
    //For checking spare

    solveTowers(count, source, destination, spare);
  }

  public static void solveTowers(int count, String source, String destination, String spare)
  {
      if(count == 1)
      {
          System.out.println("Move disk from pole " + source + " to pole " + destination+".");
      }
      else
      {
          solveTowers(count - 1, source, spare, destination);
          solveTowers (1, source, destination, spare);
          solveTowers(count - 1, spare, destination, source);
      }
  }
  //This is the end of SolveTowers
}
