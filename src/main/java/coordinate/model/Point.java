package coordinate.model;

import java.util.Objects;

public class Point {

    private final int x ;
    private final int y ;
    public final String EXCESS_ERROR_MESSAGE = "입력 범위를 초과하였습니다.";
    public static final int MIN = 1;
    public static final int MAX = 24;

    public Point(int x, int y) {
        checkRange(x,y);
        this.x = x;
        this.y = y;
    }


    private void checkRange(int x, int y){
        if(excessCheck(x)){
            throw new IllegalArgumentException(EXCESS_ERROR_MESSAGE);
        }
        if(excessCheck(y)){
            throw new IllegalArgumentException(EXCESS_ERROR_MESSAGE);
        }
    }

    private boolean excessCheck(int a) {
        return a>MAX||a<MIN;
    }

    public double calculateDistance(Point point){
       return Math.sqrt(Math.pow(this.x - point.x,2) +
                Math.pow(this.y - point.y, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, EXCESS_ERROR_MESSAGE);
    }
}
