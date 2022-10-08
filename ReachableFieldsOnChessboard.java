class Eu4ReachableFieldsOnChessboard
{
	public static void main(String[] args)
						throws NotValidFieldException
	{
		Chessboard chessBoard = new Chessboard();

	    Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
		pieces[0] = chessBoard.new Pawn ('w', 'P');
		pieces[1] = chessBoard.new Rook ('b', 'R');
		pieces[2] = chessBoard.new Knight ('w', 'N');
		pieces[3] = chessBoard.new Bishop ('w', 'B');
		pieces[4] = chessBoard.new Queen ('w', 'Q');
        pieces[5] = chessBoard.new King ('b', 'K');


		// Show all the pieces and their markings
		for (Chessboard.Chesspiece piece : pieces)
		{
			piece.moveTo('d', (byte) (3));
			piece.markReachableFields();
			System.out.println(chessBoard + "\n");
			piece.unmarkReachableFields();
			System.out.println(chessBoard + "\n");
			piece.moveOut();
		}
    }
}

