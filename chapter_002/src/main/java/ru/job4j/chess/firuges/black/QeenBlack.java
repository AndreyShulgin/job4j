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
public class QeenBlack extends Figure {

    public QeenBlack(final Cell position) {
        super(position);    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        RookBlack rookBlack = new RookBlack(Cell.A2);
        Cell[] steps;
        int deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : -1;

        if (bishopBlack.impossibleMoveBishop(source, dest) && rookBlack.impossibleMoveRook(source, dest)) {
            throw new ImpossibleMoveException("Королева не может так ходить.");
        }
        if (Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x)) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            for (int index = 0; index < steps.length; index++) {
                steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))];
            }
        } else {
            if (dest.x - source.x != 0) {
                steps = new Cell[Math.abs(dest.x - source.x)];
                for (int index = 0; index < steps.length; index++) {
                    steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + source.y];
                }
            } else {
                steps = new Cell[Math.abs(dest.y - source.y)];
                for (int index = 0; index < steps.length; index++) {
                    steps[index] = Cell.values()[source.y + deltaY * (index + 1) + source.x * 8];
                }
            }
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
