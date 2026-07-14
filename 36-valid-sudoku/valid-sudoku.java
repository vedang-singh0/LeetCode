class Solution {
    public boolean isValidSudoku(char[][] board) {
        char n=' ';
        for(int i=0;i<9;i++)//wor 1 to 8
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    continue;//we will skip if, the input is '.'
                }
                n=board[i][j];
                if(isValid(board,i,j,n)==false)
                {
                    
                    return false;
                }
            }
            
        }  
        return true;      
    }
    public boolean isValid(char board[][],int row,int column,char num)
    {
        //iterating same row==> only change column
        for(int j=0;j<9;j++)
        {
            if(j==column)//remember these part to add always
            {
                continue;
            }
           if(board[row][j]==num)
           return false;
        }
        //if we come to the end of row, we need to change next row and column to constant
        for(int i=0;i<9;i++)
        {
            if(i==row)//remember these part to add always
            {
                continue;
            }
            if(board[i][column]==num)
            return false;
        }
        //for 3X3 grid
        int starting_row=row/3*3;//imagine grid as 0,1,2 row and column then you can click this idea
        int starting_col=column/3*3;
        //by these loops we iterate over those grid, in which we have our number
        for(int i=starting_row;i<starting_row+3;i++)
        {
            for(int j=starting_col;j<starting_col+3;j++)
            {
                if(i==row||j==column)//remember these part to add always
                {
                    continue;
                }
                if(board[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
}