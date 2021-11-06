package coordinate.model;

import java.util.List;

public class Square extends Figure{

    public static final String RESULT_MESSAGE="사각형 넓이는 ";

    public Square(List<Point> points) {
        super(points,RESULT_MESSAGE);
    }



    @Override
    public double calculate() {
        return getPoints().get(0).calculateDistance(getPoints().get(1))
                * getPoints().get(1).calculateDistance(getPoints().get(2));
    }
}
