package coordinate.model;

import java.util.List;

public class Triangle extends Figure{
    
    public static final String RESULT_MESSAGE="삼각형 넓이는 ";

    public Triangle(List<Point> points) {
        super(points, RESULT_MESSAGE);
    }


    @Override
    public double calculate() {
        double a = getPoints().get(0).calculateDistance(getPoints().get(1));
        double b = getPoints().get(1).calculateDistance(getPoints().get(2));
        double c = getPoints().get(2).calculateDistance(getPoints().get(0));

        return Math.sqrt(4*(Math.pow(a,2)*Math.pow(b,2))
                -Math.pow(Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,2),2))/4;
    }
}
