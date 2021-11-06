package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final String INPUT_POINT_MESSAGE = "좌표를 입력하세요.";
    public static final String ERROR_INVALID_ACCURACY = "올바르지 않은 좌표값입니다.";
    public static final String POINT_DELIMITER  = "-";
    public static final String XY_DELIMITER = "\\d";
    private static final String ERROR_DUPLICATE = "중복된 좌표가 있습니다.";
    private static Scanner scanner = new Scanner(System.in);

    public Figure inputPoints(){
        System.out.println(INPUT_POINT_MESSAGE);
        return inputPoints(scanner.nextLine());

    }

    private Figure inputPoints(String nextLine) {
       checkAccuracy(nextLine);
       List<Point> points = generatePoints(nextLine);
       return FigureFactory.create(points);
    }

    private List<Point> generatePoints(String nextLine) {
        List<Point> points = new ArrayList<>();
        String[] stringPoints = nextLine.split(POINT_DELIMITER);
        for(String string : stringPoints){
            String[] str = string.split(XY_DELIMITER);
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            points.add(new Point(x,y));
        }

        checkDuplicate(points);

        return points;
    }

    private void checkDuplicate(List<Point> points) {
        if(points.size() != new HashSet<>(points).size()){
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void checkAccuracy(String nextLine) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
        Matcher matcher = pattern.matcher(nextLine);
        if(!matcher.matches()){
            throw new IllegalArgumentException(ERROR_INVALID_ACCURACY);
        }
    }
}
