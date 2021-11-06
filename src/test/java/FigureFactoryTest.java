import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Point;
import coordinate.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {

    @Test
    public void getLineDistance() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10,10));
        points.add(new Point(14,15));
        Figure figure = FigureFactory.create(points);
        assertEquals("두 점 사이 거리는 6.4031242374328485" ,figure.getResult());
    }

    @Test
    public void getSquareArea() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10,10));
        points.add(new Point(22,10));
        points.add(new Point(22,18));
        points.add(new Point(10,18));
        Figure figure = FigureFactory.create(points);
        OutputView outputView = new OutputView();
        outputView.printGraph(figure);
        assertEquals("사각형 넓이는 96.0" ,figure.getResult());
    }

    @Test
    public void getTriangleArea() {

        List<Point> points = new ArrayList<>();
        points.add(new Point(10,10));
        points.add(new Point(14,15));
        points.add(new Point(20,8));
        Figure figure = FigureFactory.create(points);
        assertEquals("삼각형 넓이는 29.0" ,figure.getResult());
    }
}