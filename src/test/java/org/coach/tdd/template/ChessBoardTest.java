package org.coach.tdd.template;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Created by 41988 on 2017/6/3.
 */
public class ChessBoardTest {
    private ChessBoard chessBoard;

    @Test
    public void testGetLengthShouldReturnLength() throws Exception {
        chessBoard = new ChessBoard(4, 4);
        assertThat(chessBoard.getLength(), is(4));
    }

    @Test
    public void testGetWidthShouldReturnWidth() throws Exception {
        chessBoard = new ChessBoard(12, 13);
        assertThat(chessBoard.getWidth(), is(13));
    }

    @Test
    public void testGetAroundAliveCountShouldReturnAroundAliveCount() throws Exception {
        chessBoard = new ChessBoard(12, 13);
        chessBoard.getCell(0, 0).setSatus(true);
        assertThat(chessBoard.getAroundAliveCount(chessBoard.getCell(0, 1)), is(1));
        assertThat(chessBoard.getAroundAliveCount(chessBoard.getCell(1, 1)), is(1));
        assertThat(chessBoard.getAroundAliveCount(chessBoard.getCell(1, 0)), is(1));
        assertThat(chessBoard.getAroundAliveCount(chessBoard.getCell(3, 3)), is(0));
    }

    @Test
    public void testGetCellShouldReturnCell() throws Exception {
        chessBoard = new ChessBoard(12, 13);
        assertThat(chessBoard.getCell(0, 0), is(GameCell.class));
    }

    @Test
    public void testUpdate() throws Exception {
        chessBoard = new ChessBoard(12, 13);
        chessBoard.getCell(0, 0).setSatus(true);
        chessBoard.update();
        assertEquals(chessBoard.getCell(0, 0).getStatus(), new ChessBoard(12, 13).getCell(0, 0).getStatus());
    }

    @Test
    public void testNextStatus() throws Exception {
        chessBoard = new ChessBoard(12, 13);
        chessBoard.getCell(0, 0).setSatus(true);
        assertThat(chessBoard.nextStatus(0, chessBoard.getCell(0, 0)), is(false));
        assertThat(chessBoard.nextStatus(0, chessBoard.getCell(0, 1)), is(false));
        assertThat(chessBoard.nextStatus(0, chessBoard.getCell(1, 0)), is(false));
    }
}
