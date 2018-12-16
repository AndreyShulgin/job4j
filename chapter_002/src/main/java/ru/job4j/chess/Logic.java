package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            Cell[] steps = this.figures[index].way(source, dest);
            this.wayNoValidate(source, steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        } catch (FigureNotFoundException ffe) {
            System.out.println(ffe.getLocalizedMessage());
        } catch (ImpossibleMoveException ime) {
            System.out.println(ime.getLocalizedMessage());
        } catch (OccupiedWayException owe) {
            System.out.println(owe.getLocalizedMessage());
        }
        return rst;
    }
    private void wayNoValidate(Cell source, Cell[] steps ) {
        if (this.findBy(source) == - 1) {
            throw new FigureNotFoundException("Вы нажали на пустую ячейку.");
        }
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                throw new OccupiedWayException("Ход закрыт.");
            }
        }
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position.equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}