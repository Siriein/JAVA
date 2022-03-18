import java.util.Scanner;
public class Main 
{
  public static void main(String[] args) 
  {
    Scanner input=new Scanner(System.in);
    SudokuPuzzle game;
    game=new SudokuPuzzle();
    game.addInitial(0,1,6);
    game.addInitial(0,3,3);
    game.addInitial(0,7,5);
    game.addInitial(0,8,8);
    game.addInitial(1,1,4);
    game.addInitial(1,2,3);
    game.addInitial(1,3,6);
    game.addInitial(1,4,8);
    game.addInitial(1,7,1);
    game.addInitial(2,3,9);
    game.addInitial(2,4,1);
    game.addInitial(2,5,7);
    game.addInitial(2,6,3);
    game.addInitial(2,7,6);
    game.addInitial(3,1,9);
    game.addInitial(3,2,4);
    game.addInitial(3,4,7);
    game.addInitial(3,5,3);
    game.addInitial(3,8,1);
    game.addInitial(4,0,3);
    game.addInitial(4,2,6);
    game.addInitial(4,5,8);
    game.addInitial(4,6,4);
    game.addInitial(5,0,2);
    game.addInitial(5,2,8);
    game.addInitial(5,4,6);
    game.addInitial(5,6,5);
    game.addInitial(6,0,1);
    game.addInitial(6,3,8);
    game.addInitial(6,6,7);
    game.addInitial(6,8,9);
    game.addInitial(7,0,6);
    game.addInitial(7,4,3);
    game.addInitial(7,6,1);
    game.addInitial(7,8,5);
    game.addInitial(8,1,2);
    game.addInitial(8,2,9);
    game.addInitial(8,3,7);
    System.out.println(game);
    while (game.isFull()==false)
    {
      int r, c, val;
      System.out.println("Enter a row number from 1 - 9: ");
      r=input.nextInt();
      if (r<10&&r>0)
      {
        r--;
      }
      else
      {
        while(r>=10||r<=0)
        {
        System.out.println("\nInvalid row. Please enter a row from 1 - 9 only.");
        r=input.nextInt();
        if (r<10&&r>=0)
        {
         r--;
        }
        }
      }
      System.out.println("\nEnter a column number from 1 - 9: ");
      c=input.nextInt();
      if (c<10&&c>0)
      {
        c--;
      }
      else
      {
        while(c>=10||c<=0)
        {
        System.out.println("\nInvalid column. Please enter a column from 1 - 9 only.");
        c=input.nextInt();
        if (c<10&&c>0)
        {
          c--;
        }
        }
      }
      System.out.println("\nEnter a guess number from 1 - 9: ");
      val=input.nextInt();
      if (val<10&&val>0)
      {
        game.addGuess(r,c,val);
        if(game.checkPuzzle()==false)
        {
          while(val >= 10 || val <= 0){
            System.out.println("There is a duplicate. Please re-enter: ");
            val = input.nextInt();
            if (val<10&&val>0)
            {
              game.addGuess(r,c,val);
            }          
          }
        }
      }
      else
      {
        while(val>=10||val<=0)
        {
          System.out.println("\nInvalid number. Please enter a number from 1 - 9 only.");
          val=input.nextInt();
          if (val<10&&val>0)
          {
            game.addGuess(r,c,val);
          }
        }
      }
      System.out.println(game);
    }
  }
}
