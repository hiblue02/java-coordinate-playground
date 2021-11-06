package coordinate.view;

import coordinate.model.Figure;

public class OutputView {

    private static final int MAX = 24;
    private static final String BLANK = "    ";
    private static final String X_HORIZON = "----";
    private static final String Y_VERTICAL = "|";
    private static final String POINT = "●";
    private static final String CENTER_ZERO = "+";
    private static final String NUMBER_FORMAT = "%4d";


    public void printGraph(Figure figure) {

        printSection(figure);
        printHorizon();
        printXaxis();

    }

    private void printXaxis() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x <= MAX; x++) {
            stringBuilder.append(showAxisNumber(x));
        }
        System.out.println(stringBuilder);
    }

    private String showAxisNumber(int a) {
        if (Math.floorMod(a, 2) == 0){
            return String.format(NUMBER_FORMAT, a);
        }
        return BLANK;
    }

    private void printHorizon() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BLANK);
        stringBuilder.append(CENTER_ZERO);

        for (int x = 1; x <= MAX; x++) {
            stringBuilder.append(X_HORIZON);
        }
        System.out.println(stringBuilder);
    }

    private void printSection(Figure figure) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = MAX; y >= 1; y--) {
            stringBuilder.append(showAxisNumber(y));
            stringBuilder.append(Y_VERTICAL);
            for (int x = 1; x <= MAX; x++) {
                stringBuilder.append(showPoint(x,y, figure));
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private String showPoint(int x, int y, Figure figure) {
        if(figure.contain(x, y)) return  POINT;
        return BLANK;
    }

}
