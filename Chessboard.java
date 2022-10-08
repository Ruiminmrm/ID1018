import java.util.*;//
import static java.lang.System.out;

public class Chessboard
{
	public static class Field
	{
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;

		public Field(char row, byte column)
		{
			this.row = row;
			this.column = column;
		}

		public void put (Chesspiece piece)
		{
			this.piece = piece;
		}

		public Chesspiece take()
		{
			this.piece = null;
			return this.piece;
		}

		public void mark()
		{
			this.marked = true;
		}

		public void unmark()
		{
			this.marked = false;
		}

		public String toString()
		{
			String s = (marked) ? "xx" : "--";
			return (piece == null) ? s : piece.toString();
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 0;

	private Field[][] fields;

	public Chessboard()
	{
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;

		for(int r = 0; r < NUMBER_OF_ROWS; r++)
		{
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++)
			{
				fields[r][c] = new Field(row, column);
			}
		}
	}

	public String toString()
	{
		StringBuilder utseende = new StringBuilder();
		utseende.append("    1  2  3  4  5  6  7  8\n\n");
		for(int i = 0; i < NUMBER_OF_ROWS; i++)
		{
			utseende.append((char) (i + FIRST_ROW) + " ");
			for(int j = 0; j < NUMBER_OF_COLUMNS; j++)
			{
				utseende.append(" " + fields[i][j]);
			}
			utseende.append("\n\n");
		}
		return utseende.toString();
	}

	public boolean isValidField(char row, byte column)
	{
		if(row >= 97 && row <= 104 && column <= 7 && column >= 0)
			return true;
	    else
		    return false;
	}

	public abstract class Chesspiece
	{
		private char color; // w - white, b - black
		private char name; // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn
		protected char row = 0;
		protected byte column = -1;

		protected Chesspiece(char color, char name)
		{
			this.color = color;
			this.name = name;
		}

		public String toString()
		{
			return "" + color + name;
		}

		public boolean isOnBoard()
		{
			return Chessboard.this.isValidField(row, column);
		}

		public void moveTo (char row, byte column) throws NotValidFieldException
		{
			if (!Chessboard.this.isValidField(row, column))
				 throw new NotValidFieldException("Bad field: " + row + column);

			this.row = row;
			this.column = column;

			int r =  row - FIRST_ROW;
			int c =  column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put(this);
		}

		public void moveOut()
		{
			if(isOnBoard())
			{
				int r =  row - FIRST_ROW;
			    int c =  column - FIRST_COLUMN;
				Chessboard.this.fields[r][c].take();
			}
		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();
	}

	public class Pawn extends Chesspiece//pawn gå rakt fram 2 rader i början , efteråt 1 rad
	{
		public Pawn(char color, char namn)
		{
			super(color, namn);
		}

		public void markReachableFields()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
			    int r = row - FIRST_ROW;
			    int c = col - FIRST_COLUMN;
			    Chessboard.this.fields[r][c].mark ();
			}
		}

		public void unmarkReachableFields()
		{
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
			     int r = row - FIRST_ROW;
			     int c = col - FIRST_COLUMN;
			     Chessboard.this.fields[r][c].unmark ();
			}
		}
	}

	public class Rook extends Chesspiece //gå rakt
	{
		public Rook(char color, char name)
		{
			super(color, name);
		}

		public void markReachableFields()
		{
			// Går längst med hela raden och märker den eller går längst med hela kolumnen och märker den
			for(byte j = 0; j <= NUMBER_OF_COLUMNS; j++)
			    if (Chessboard.this.isValidField (row,j) && (j != column))//ska till nån annat kolumn som inte är den som står just nu
			    {
		            int r = row - FIRST_ROW;
		            int c = j - FIRST_COLUMN;
		            Chessboard.this.fields[r][c].mark();
				}
		    for(char i = 'a'; i <= 'h'; i++)
		        if (Chessboard.this.isValidField (i,column) && (i != row))
		        {
		            int r = i - FIRST_ROW;
					int c = column - FIRST_COLUMN;
		            Chessboard.this.fields[r][c].mark();
				}
		}

		public void unmarkReachableFields()
		{
		    for(byte j = 0; j <= NUMBER_OF_COLUMNS; j++)
		    {
			    if (Chessboard.this.isValidField (row,j) && (j != column))
			    {
		            int r = row - FIRST_ROW;
		            int c = j - FIRST_COLUMN;
		            Chessboard.this.fields[r][c].unmark();
				}
			}
		    for(char i = 'a'; i <= 'h'; i++)
		    {
		        if (Chessboard.this.isValidField (i,column) && (i != row))
		        {
		            int r = i - FIRST_ROW;
					int c = column - FIRST_COLUMN;
		            Chessboard.this.fields[r][c].unmark();
			    }
			}
		}
	}

	public class Knight extends Chesspiece
	{

		public Knight(char color, char name)
		{
			super(color, name);
		}
		int[] movement = {-2,-1,-1,-2,2,1,1,2,-2,-1};//flyttning i rad och i column
		public void markReachableFields()
		{
			for(int i = 0; i < NUMBER_OF_COLUMNS;i++)
			{
				char ro = (char)(row + movement[i]);
				byte co = (byte)(column + movement[i+2]);
				if (Chessboard.this.isValidField (ro,co))
				{
					int r = ro - FIRST_ROW;
					int c = co - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
		}
		public void unmarkReachableFields()
		{
			for(int i = 0; i < NUMBER_OF_COLUMNS;i++)
			{
				char ro = (char)(row + movement[i]);
				byte co = (byte)(column + movement[i+2]);
				if (Chessboard.this.isValidField (ro,co))
				{
					int r = ro - FIRST_ROW;
					int c = co - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
		}
	}

    public class Bishop extends Chesspiece
    {
        public Bishop(char color , char name)
        {
            super(color, name);
        }

        int[] movement = {1, -1, -1, 1, 1};

        public void markReachableFields()
        {
            for (int i = 1; i < 8; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (Chessboard.this.isValidField((char) (row + i*movement[j]),(byte) (column + i*movement[j+1])))
                    {
                        int r = (char) (row + i*movement[j]) - FIRST_ROW;
                        int c = (byte) (column + i*movement[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }
        }

        public void unmarkReachableFields ()
        {
            for (int i = 1; i < 8; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (Chessboard.this.isValidField((char) (row + i*movement[j]),(byte) (column + i*movement[j+1])))
                    {
                        int r = (char) (row + i*movement[j]) - FIRST_ROW;
                        int c = (byte) (column + i*movement[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }
	    }
    }
	public class Queen extends Chesspiece
	{
		public Queen(char color, char name)
		{
			super(color, name);
		}
		int[] movement = {1, 1, -1, -1, 1};
		public void markReachableFields()//gå som rook
		{
			for(byte j = 0; j <= NUMBER_OF_COLUMNS; j++)
			{
				if (Chessboard.this.isValidField (row,j) && (j != column))
				{
					int r = row - FIRST_ROW;
					int c = j - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
			for(char i = 'a'; i <= 'h'; i++)
			{
				if (Chessboard.this.isValidField (i,column) && (i != row))
				{
					int r = i - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
			for (int i = 1; i < 8; i++)//gå som bishop
			{
				for (int j = 0; j < 4; j++)
				{
					if (Chessboard.this.isValidField((char) (row + i*movement[j]),(byte) (column + i*movement[j+1])))
					{
						int r = (char) (row + i*movement[j]) - FIRST_ROW;
						int c = (byte) (column + i*movement[j+1]) - FIRST_COLUMN;
						Chessboard.this.fields[r][c].mark();
					}
				}
            }
		}

		public void unmarkReachableFields()
	    {
			for(byte j = 0; j <= NUMBER_OF_COLUMNS; j++)
			{
				if (Chessboard.this.isValidField (row,j) && (j != column))
				{
					int r = row - FIRST_ROW;
					int c = j - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for(char i = 'a'; i <= 'h'; i++)
			{
				if (Chessboard.this.isValidField (i,column) && (i != row))
				{
					int r = i - FIRST_ROW;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}
			for (int i = 1; i < 8; i++)//gå som bishop
			{
				for (int j = 0; j < 4; j++)
				{
					if (Chessboard.this.isValidField((char) (row + i*movement[j]),(byte) (column + i*movement[j+1])))
					{
						int r = (char) (row + i*movement[j]) - FIRST_ROW;
						int c = (byte) (column + i*movement[j+1]) - FIRST_COLUMN;
						Chessboard.this.fields[r][c].unmark();
					}
				}
            }
	    }
	}

	public class King extends Chesspiece
	{
		public King(char color, char name)
		{
			super(color, name);
		}
		int[] movement1 = {0,1,1,1,0,-1,-1,-1,0,1};
		public void markReachableFields()
		{
			for (int i = 0; i < 8; i++)
			{
				if (Chessboard.this.isValidField((char)(row + movement1[i]),(byte)(column + movement1[i+2])))
				{
					int r = (char)(row + movement1[i]) - FIRST_ROW;
					int c = (byte)(column + movement1[i+2]) - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}

		}
		public void unmarkReachableFields()
		{
			for (int i = 0; i < 8; i++)
			{
				if (Chessboard.this.isValidField((char)(row + movement1[i]),(byte)(column + movement1[i+2])))
				{
					int r = (char)(row + movement1[i]) - FIRST_ROW;
					int c = (byte)(column + movement1[i+2]) - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
			}

	    }
    }
}