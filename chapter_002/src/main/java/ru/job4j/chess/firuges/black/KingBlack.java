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
public class KingBlack extends Figure {

    public KingBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(source.y == dest.y + 1 && source.x == dest.x ||
                source.y == dest.y - 1 && source.x == dest.x ||
                source.y == dest.y && source.x == dest.x + 1 ||
                source.y == dest.y && source.x == dest.x - 1 ||
                source.y == dest.y + 1 && source.x == dest.x + 1 ||
                source.y == dest.y + 1 && source.x == dest.x - 1 ||
                source.y == dest.y - 1 && source.x == dest.x - 1 ||
                source.y == dest.y - 1 && source.x == dest.x + 1)) {
            throw new ImpossibleMoveException("Король может ходить только на одну клетку.");
        }
        return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
