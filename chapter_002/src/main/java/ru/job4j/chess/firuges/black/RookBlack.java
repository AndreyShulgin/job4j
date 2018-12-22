package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack extends Figure {

    public RookBlack(final Cell position) {
        super(position);    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if ((dest.x - source.x) != 0) {
            steps = new Cell[Math.abs(dest.x - source.x)];
        } else {
            steps = new Cell[Math.abs(dest.y - source.y)];
        }
        int deltaX = dest.x - source.x > 0 ? 1 : -1;
        int deltaY = dest.y - source.y > 0 ? 1 : -1;
        if (impossibleMoveRook(source, dest)) {
            throw new ImpossibleMoveException("Ладья может ходить только по прямой.");
        }
        if (source.x == dest.x) {
            for (int index = 0; index < steps.length; index++) {
                steps[index] = Cell.values()[source.y + deltaY * (index + 1) + source.x * 8];
            }
        } else {
            for (int index = 0; index < steps.length; index++) {
                steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + source.y];
            }
        }
        return steps;
    }

    public boolean impossibleMoveRook(Cell source, Cell dest) {
        boolean rst = true;
        if ((source.x == dest.x && source.y != dest.y || source.x != dest.x && source.y == dest.y)) {
            rst = false;
        }
        return rst;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
