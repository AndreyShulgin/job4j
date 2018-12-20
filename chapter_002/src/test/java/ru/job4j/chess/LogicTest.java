package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureNotFoundException;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.OccupiedWayException;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class LogicTest {
    @Test
    public void whenBlackBishopMoveRightUp() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.D7);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackBishopMoveRightDown() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.H5);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackBishopMoveLeftUp() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.E2);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackBishopMoveLeftDownValid() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.H3);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackBishopMoveLeft() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.G3);
        assertThat(result, is(false));
    }

    @Test
    public void whenBlackBishopMoveLeftDownInvalid() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        BishopWhite bishopWhite = new BishopWhite(Cell.H3);
        logic.add(bishopBlack);
        logic.add(bishopWhite);
        boolean result = logic.move(Cell.G4, Cell.H3);
        assertThat(result, is(false));
    }
    @Test
    public void whenBlackPawnMove() {
        Logic logic = new Logic();
        PawnBlack pawnBlack = new PawnBlack(Cell.G2);
        logic.add(pawnBlack);
        boolean result = logic.move(Cell.G2, Cell.G1);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackKingMoveUp() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.G1);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackKingMoveDown() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G1);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G1, Cell.G2);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackKingMoveLeft() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.H2);
        assertThat(result, is(true));
    }

    @Test
    public void whenBlackKingMoveLeftDown() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.H1);
        assertThat(result, is(true));
    }
}