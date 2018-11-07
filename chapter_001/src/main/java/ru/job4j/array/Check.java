package ru.job4j.array;

/**Check.
 * @author Andrey Shulgin (neonod404@gmail.com).
 */
public class Check {

    /**
     * Метод проверяет из чего состоит массив Boolean.
     * @param data - метод.
     * @return возвращает true если массив состоит только из True или False. И False если нет.
     */
    public boolean mono(boolean[] data) {
      for (int index = 1; index < data.length; index++) {
          if (data[index] != data[index - 1]) {
              return false;
          }
       }
        return true;
    }
}
