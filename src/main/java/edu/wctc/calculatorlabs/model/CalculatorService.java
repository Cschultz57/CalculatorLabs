package edu.wctc.calculatorlabs.model;

/**
 *
 * @author Carson
 */
public class CalculatorService {

    private static final double MIN_INPUT = 0.0;
    private static final String INVALID_INPUT_ERROR = "Error: Valid numerical input must be provided and must be greater than 0";
    private static final double SQUARED = 2;

    public final String getAnswerForType(String[] values, CalculatorType calcType) {
        String answer = null;
        switch (calcType) {
            case RECTANGLE_AREA:
                try {
                    answer = calculateAreaOfRectangle(values[0], values[1]);
                } catch (Exception e) {
                    answer = INVALID_INPUT_ERROR;
                }
                break;
            case CIRCLE_AREA:
                try {
                    answer = calculateAreaOfCircle(values[0]);
                } catch (Exception e) {
                    answer = INVALID_INPUT_ERROR;
                }
                break;
            case RIGHT_TRIANGLE_HYPOTENUSE:
                try {
                    answer = calculateHypotenuseOfRightTriangle(values[0], values[1]);
                } catch (Exception e) {
                    answer = INVALID_INPUT_ERROR;
                }
                break;
            default:
                break;
        }
        return answer;
    }

    public final String calculateAreaOfRectangle(String length, String width) throws NumberFormatException, IllegalArgumentException {
        if (Double.parseDouble(length) < MIN_INPUT || Double.parseDouble(width) < MIN_INPUT || width.isEmpty() || width == null || length.isEmpty() || length == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        return Double.toString(Double.parseDouble(length) * Double.parseDouble(width));
    }

    public final String calculateAreaOfCircle(String radius) throws NumberFormatException, IllegalArgumentException {
        if (Double.parseDouble(radius) < MIN_INPUT || radius.isEmpty() || radius == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        return Double.toString(Math.PI * (Math.pow(Double.parseDouble(radius), SQUARED)));
    }

    public final String calculateHypotenuseOfRightTriangle(String sideA, String sideB) throws NumberFormatException, IllegalArgumentException {
        if (Double.parseDouble(sideA) < MIN_INPUT || Double.parseDouble(sideB) < MIN_INPUT || sideA.isEmpty() || sideB.isEmpty() || sideA == null || sideB == null) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        return Double.toString(Math.sqrt(Math.pow(Double.parseDouble(sideA), SQUARED) + Math.pow(Double.parseDouble(sideB), SQUARED)));
    }
}
