package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class LogicTest {

    /**
     * Черный слон ходит по диагонали на право вверх.
     */
    @Test
    public void whenBlackBishopMoveRightUp() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.D7);
        assertThat(result, is(true));
    }

    /**
     * Черный слон ходит по диагонали на право вниз.
     */
    @Test
    public void whenBlackBishopMoveRightDown() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.H5);
        assertThat(result, is(true));
    }

    /**
     * Черный слон ходит по диагонали на лево вверх.
     */
    @Test
    public void whenBlackBishopMoveLeftUp() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.E2);
        assertThat(result, is(true));
    }

    /**
     * Черный слон ходит по диагонали на лево вниз.
     */
    @Test
    public void whenBlackBishopMoveLeftDown() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.H3);
        assertThat(result, is(true));
    }

    /**
     * Слон пытается пойти на на лево.
     */
    @Test
    public void whenBlackBishopMoveLeft() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.G4, Cell.G3);
        assertThat(result, is(false));
    }

    /**
     * Ход для слона закрыт.
     */
    @Test
    public void whenBlackBishopMoveLeftDownInvalid() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        BishopWhite bishopWhite = new BishopWhite(Cell.H3);
        logic.add(bishopBlack);
        logic.add(bishopWhite);
        boolean result = logic.move(Cell.G4, Cell.H3);
        assertThat(result, is(false));
    }

    /**
     * Фигура в начальной клетке не найдена
     */
    @Test
    public void whenBlackBishopNotFound() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        logic.add(bishopBlack);
        boolean rst = logic.move(Cell.H3, Cell.G4);
        assertThat(rst, is(false));
    }

    /**
     * Черная пешка ходит на клетку вперед.
     */
    @Test
    public void whenBlackPawnMove() {
        Logic logic = new Logic();
        PawnBlack pawnBlack = new PawnBlack(Cell.G2);
        logic.add(pawnBlack);
        boolean result = logic.move(Cell.G2, Cell.G1);
        assertThat(result, is(true));
    }

    /**
     * Черная пешка пытается пойти на лево.
     */
    @Test
    public void whenBlackPawnMoveLeft() {
        Logic logic = new Logic();
        PawnBlack pawnBlack = new PawnBlack(Cell.G2);
        logic.add(pawnBlack);
        boolean result = logic.move(Cell.G2, Cell.H2);
        assertThat(result, is(false));
    }

    /**
     * Черная пешка пытается пойти по диагонали.
     */
    @Test
    public void whenBlackPawnMoveLeftUp() {
        Logic logic = new Logic();
        PawnBlack pawnBlack = new PawnBlack(Cell.G2);
        logic.add(pawnBlack);
        boolean result = logic.move(Cell.G2, Cell.H1);
        assertThat(result, is(false));
    }

    /**
     * Черный король идет на клетку вперед.
     */
    @Test
    public void whenBlackKingMoveUp() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.G1);
        assertThat(result, is(true));
    }

    /**
     * Черный король идет на клетку назад.
     */
    @Test
    public void whenBlackKingMoveDown() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G1);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G1, Cell.G2);
        assertThat(result, is(true));
    }

    /**
     * Черный король идет на клетку вбок.
     */
    @Test
    public void whenBlackKingMoveLeft() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.H2);
        assertThat(result, is(true));
    }

    /**
     * Черный король идет назад по диагонали.
     */
    @Test
    public void whenBlackKingMoveLeftDown() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.H1);
        assertThat(result, is(true));
    }

    /**
     * Король пытается пойти на несколько клеток.
     */
    @Test
    public void whenBlackKingMoveTwoSteps() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.E2);
        assertThat(result, is(false));
    }

    /**
     * Черная ладья идет на лево.
     */
    @Test
    public void whenBlackRookMoveLeft() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.D2);
        assertThat(rst, is(true));
    }

    /**
     * Черная ладья идет на право.
     */
    @Test
    public void whenBlackRookMoveRight() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.D6);
        assertThat(rst, is(true));
    }

    /**
     * Черная ладья идет вперед.
     */
    @Test
    public void whenBlackRookMoveUp() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.B4);
        assertThat(rst, is(true));
    }

    /**
     * Черная ладья идет назад.
     */
    @Test
    public void whenBlackRookMoveDown() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.F4);
        assertThat(rst, is(true));
    }

    /**
     * Черная ладья пытается сходить по диагонали.
     */
    @Test
    public void whenBlackRookMoveDiagonal() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.G1);
        assertThat(rst, is(false));
    }

    /**
     * Черная королева идет вперед на несколько клеток.
     */
    @Test
    public void whenBlackQeenMoveUp() {
        Logic logic = new Logic();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        logic.add(qeenBlack);
        boolean rst = logic.move(Cell.D4, Cell.B4);
        assertThat(rst, is(true));
    }

    /**
     * Черная королева идет в лево на пару клеток.
     */
    @Test
    public void whenBlackQeenMoveLeft() {
        Logic logic = new Logic();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        logic.add(qeenBlack);
        boolean rst = logic.move(Cell.D4, Cell.D2);
        assertThat(rst, is(true));
    }

    /**
     * Черная королева идет по диагонали.
     */
    @Test
    public void whenBlackQeenMoveDiagonal() {
        Logic logic = new Logic();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        logic.add(qeenBlack);
        boolean rst = logic.move(Cell.D4, Cell.F6);
        assertThat(rst, is(true));
    }

    /**
     * Черная королева пытается пойти как конь.
     */
    @Test
    public void whenBlackQeenMoveLikeKnight() {
        Logic logic = new Logic();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        logic.add(qeenBlack);
        boolean rst = logic.move(Cell.D4, Cell.E6);
        assertThat(rst, is(false));
    }

    /**
     * Конь делает ход буков Г направо вверх.
     */
    @Test
    public void whenBlackKnightMoveUpRight() {
        Logic logic = new Logic();
        KnightBlack knightBlack = new KnightBlack(Cell.D4);
        logic.add(knightBlack);
        boolean rst = logic.move(Cell.D4, Cell.B5);
        assertThat(rst, is(true));
    }

    /**
     * Конь делает ход буквой Г налево вниз.
     */
    @Test
    public void whenBlackKnightMoveLeftDown() {
        Logic logic = new Logic();
        KnightBlack knightBlack = new KnightBlack(Cell.D4);
        logic.add(knightBlack);
        boolean rst = logic.move(Cell.D4, Cell.E2);
        assertThat(rst, is(true));
    }

    /**
     * Конь пытается пойти не буквой Г.
     */
    @Test
    public void whenBlackKnightMoveUp() {
        Logic logic = new Logic();
        KnightBlack knightBlack = new KnightBlack(Cell.D4);
        logic.add(knightBlack);
        boolean rst = logic.move(Cell.D4, Cell.C4);
        assertThat(rst, is(false));
    }
}