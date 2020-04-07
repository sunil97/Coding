package backtracking;

public class sudokuValid {

	public static void main(String[] args) {
		
		int x =(int) 88.8;
		byte b = (byte) 100l;
		long xt = (byte)100;
		int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
			  if(solveSudoku(board,board.length)) {
				  System.out.println("true");
			  }else
				  System.out.println("false");
	}

	private static boolean solveSudoku(int[][] board, int n) {
		boolean isEmpty = false;
		int currRow = -1,currCol=-1; 
		for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]==0)
					{
						currRow =i;
						currCol =j;
						isEmpty=true;
						break;
					}
				}
				if(isEmpty)
					break;
			}
		if(!isEmpty) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}
		for(int num = 1;num<=9;num++) {
			if(isSafe(currRow,currCol,num,n,board)) {
				board[currRow][currCol] = num;
				if(solveSudoku(board, n)) {
					return true;
				}
				else {
					board[currRow][currCol]=0;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int currRow, int currCol, int num, int n, int[][] board) {
			for(int i=0;i<n;i++) 
				if(board[currRow][i]==num)
					return false;
			for(int i=0;i<n;i++) 
				if(board[i][currCol]==num)
					return false;
			int boxSize = (int) Math.sqrt(n);
			int startRow = currRow - currRow%boxSize;
			int startCol = currCol - currCol%boxSize;
			for(int i=startRow;i<boxSize+startRow;i++) {
				for(int j= startCol ;j<boxSize+startCol;j++) {
					if(board[i][j]==num)
						return false;
				}
			}
		return true;
	}

}
