package coordinate.model;

import coordinate.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    public static final int MAX = 24;
    public static FigureFactory figureFactory = null;
    public static final String ERROR_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
    public static Figure figure;

    public static final int SIZE_OF_LINE = 2;
    public static final int SIZE_OF_TRIANGLE = 3;
    public static final int SIZE_OF_SQUARE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

    static{
        classifier.put(SIZE_OF_LINE, Line::new);
        classifier.put(SIZE_OF_TRIANGLE, Triangle::new);
        classifier.put(SIZE_OF_SQUARE, Square::new);
    }



    public static Figure create( List<Point> points){
        if(points == null){
            throw new IllegalArgumentException(Figure.ERROR_FIGURE_NULL);
        }
        if(isInvalidSize(points)){
            throw new IllegalArgumentException(ERROR_FIGURE_CREATION);
        }
        return createFigure(points);
    }

    private static boolean isInvalidSize(List<Point> points) {
        return points.size() > SIZE_OF_SQUARE || points.size() < SIZE_OF_LINE;
    }


    public static Figure createFigure(List<Point> points){
        return classifier.get(points.size()).apply(points);
    }

}
