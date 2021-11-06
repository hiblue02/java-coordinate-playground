package coordinate.model;

import java.util.List;

public class Line extends Figure{

    public static final String RESULT_MESSAGE="두 점 사이 거리는 ";

    public Line(List<Point> points) {
        super(points, RESULT_MESSAGE);
    }



    @Override
    public double calculate() {
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String getResult() {
        return RESULT_MESSAGE+calculate();
    }
}
