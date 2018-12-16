package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureNotFoundException;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.OccupiedWayException;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BishopBlackTest {
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
}