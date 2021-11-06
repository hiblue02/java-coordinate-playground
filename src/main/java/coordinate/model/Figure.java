package coordinate.model;

import java.util.List;

public abstract class Figure implements Coordinate{
    public static final String ERROR_FIGURE_NULL = "올바른 좌표값이 아닙니다." ;
    private final List<Point> points;
    private final String RESULT_MESSAGE;

    public Figure(List<Point> points, String RESULT_MESSAGE) {
        if(points==null || points.isEmpty()){
            throw new IllegalArgumentException(ERROR_FIGURE_NULL);
        }

        this.points = points;
        this.RESULT_MESSAGE = RESULT_MESSAGE;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String getResult() {
        return RESULT_MESSAGE+calculate();
    }

    public boolean contain(int x, int y){
        return points.contains(new Point(x,y));
    }
}
