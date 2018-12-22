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
public class KnightBlack extends Figure {

    public KnightBlack(final Cell position) {
        super(position);
    }


    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (impossibleMoveKnight(source, dest)) {
            throw new ImpossibleMoveException("Конь может ходить только буквой Г.");
        }
        return new Cell[] { dest };
    }

    private boolean impossibleMoveKnight(Cell source, Cell dest) {
        boolean rst = true;
        if (dest.x == source.x + 2 && dest.y == source.y + 1 ||
            dest.x == source.x + 2 && dest.y == source.y - 1 ||
            dest.x == source.x - 2 && dest.y == source.y + 1 ||
            dest.x == source.x - 2 && dest.y == source.y - 1 ||
            dest.x == source.x + 1 && dest.y == source.y + 2 ||
            dest.x == source.x + 1 && dest.y == source.y - 2 ||
            dest.x == source.x - 1 && dest.y == source.y + 2 ||
            dest.x == source.x - 1 && dest.y == source.y - 2) {
            rst = false;
        }
        return rst;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
