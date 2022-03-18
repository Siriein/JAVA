import java.util.Scanner;
public class SudokuPuzzle
{
  private int row,col,value;
  private int[][]board=new int[9][9];
  private boolean[][]start=
    {{false, true, false, true, false, false, false, true, true},
    {false, true, true, true, true, false, false, true, false}, 
    {false, false, false, true, true, true, true, true, false}, 
    {false, true, true, false, true, true, false, false, true},
    {true, false, true, false, false, true, true, false, false}, 
    {true, false, true, false, true, false, true, false, false},
    {true, false, false, true, false, false, true, false, true}, 
    {true, false, false, false, true, false, true, false, true},
    {false, true, true, true, false, false, false, false, false}};
  Scanner input=new Scanner(System.in);
  public SudokuPuzzle()
  {
    for (row=0; row<board.length; row++)
    {
      for (col=0; col<board[row].length; col++)
      {
        board[row][col]=0;
      }
    }
  }
  public void addInitial(int r,int c,int val)
  {
    row=r;
    col=c;
    board[row][col]=val;
  }
  public void addGuess(int r, int c,int val)
  {
    row = r;
    col = c;
    if (start[row][col]==false)
    {
    board[row][col] = val;
    }
    else
    {
    System.out.println("This value cannot be changed. Enter another row or column.");
    }
  }
  public boolean checkRow(int r,int val)
  {
    row=r;
    value=val;
    int count=0;
    for(col=0;col<board[row].length;col++)
    {
      if(board[row][col]==value)
      {
        count++;
      }
    }
    if(count>1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean checkColumn(int c,int val)
  {
    col=c;
    value=val;
    int count=0;
    for(row=0;row<board.length;row++)
    {
      if(board[row][col]==value)
      {
        count++;
      }
    }
    if(count>1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean checkSquare(int r, int c, int val)
  {
    value = val;
    int count=0;
    for(row=(r-r%3); row<(r+3);row++)
    {
      for(col=(c-c%3); col<(c+3); col++)
      {
        if(board[row][col]==value)
        
        count++;
        
      }
    }
    if(count>1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean checkPuzzle()
  {
    int count=0;
    for(row=0;row<board.length;row++)
    {
      for(col=0;col<board[row].length;col++)
      value = board[row][col];
      count = board[row][col]+= board[row][col];
    }
    if (count==45)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  public int getValueIn(int r,int c)
  {
    row = r;
    col = c;
    return board[row][col];
  }
  public boolean getAllowedValues(int r,int c)
  {
    row=r;
    col = c;
    boolean[]allowedVal=new boolean[9];
    for(int i=0; i<allowedVal.length;i++)
    {
      if (start[row][col]==false)
      {
        allowedVal[i]=true;
      }
      else
      {
        allowedVal[i]=false;
      }
    }
    return false;
  }
  public boolean isFull()
  {
    int v=0;
    for (row=0; row<board.length; row++)
    {
      for (col=0; col<board[row].length; col++)
      {
        if(board[row][col]!=0&&start[row][col]==false)
        {
          v=board[row][col];
        }
        else
        {
          v=0;
        }
      }
    }
    if (v==0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  public void reset()
  {
    for(int row=0; row<board.length; row++)
      for(int col=0; col<board.length; col++)
      {
        if(start[row][col]==false)
        addGuess(row,col,0);
      }
  }
  public String toString()
  {
    String string="";
    for (row=0; row<board.length; row++)
    {
      for (col=0; col<board[row].length; col++)
      {
      string=string+String.format("%5s",board[row][col]);
      }
      string=(string+"\n");
    }
    return string;
  }
}  
