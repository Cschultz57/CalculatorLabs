package edu.wctc.calculatorlabs.controller;

import edu.wctc.calculatorlabs.model.CalculatorService;
import edu.wctc.calculatorlabs.model.CalculatorType;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carson
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/calc"})
public class CalculatorController extends HttpServlet {

    private static final String HOME_PAGE = "/index.jsp";
    private static final String RESULT_PAGE = "/calculationResult.jsp";
    private static final String ERROR_MSG_ATR = "errMsg";

    private static final String CALC_TYPE = "calcType";
    private static final String CALC_TYPE_RECT_AREA = "rectArea";
    private static final String CALC_TYPE_CIRCLE_AREA = "circleArea";
    private static final String CALC_TYPE_RIGHT_TRI_HYP = "rightTriangleHypotenuse";
    private static final String RESULTS_CHECK = "resultsCheck";

    private static final String RECT_AREA_ANSWER = "msgAreaRect";
    private static final String CIRCLE_AREA_ANSWER = "msgAreaCircle";
    private static final String RIGHT_TRI_HYP_ANSWER = "msgRightTriangleHypotenuse";

    private static final String WIDTH_INPUT = "width";
    private static final String LENGTH_INPUT = "length";
    private static final String RADIUS_INPUT = "radius";
    private static final String SIDE_A_INPUT = "sideA";
    private static final String SIDE_B_INPUT = "sideB";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String destination = HOME_PAGE;
        String calcType = request.getParameter(CALC_TYPE);
        CalculatorService calcServ = new CalculatorService();
        String answer;
        try {
            if (calcType.equalsIgnoreCase(CALC_TYPE_RECT_AREA)) {
                String length = request.getParameter(LENGTH_INPUT);
                String width = request.getParameter(WIDTH_INPUT);
                String check = request.getParameter(RESULTS_CHECK);
                String[] values = {length, width};
                answer = calcServ.getAnswerForType(values, CalculatorType.RECTANGLE_AREA);
                if (check != null ){
                    destination = RESULT_PAGE;
                }
                request.setAttribute(RECT_AREA_ANSWER, answer);
                

            } else if (calcType.equalsIgnoreCase(CALC_TYPE_CIRCLE_AREA)) {
                String radius = request.getParameter(RADIUS_INPUT);
                String[] values = {radius};
                answer = calcServ.getAnswerForType(values, CalculatorType.CIRCLE_AREA);

                request.setAttribute(CIRCLE_AREA_ANSWER, answer);

            } else if (calcType.equalsIgnoreCase(CALC_TYPE_RIGHT_TRI_HYP)) {
                String sideA = request.getParameter(SIDE_A_INPUT);
                String sideB = request.getParameter(SIDE_B_INPUT);
                String[] values = {sideA, sideB};
                answer = calcServ.getAnswerForType(values, CalculatorType.RIGHT_TRIANGLE_HYPOTENUSE);

                request.setAttribute(RIGHT_TRI_HYP_ANSWER, answer);

            }
        } catch (Exception e) {
            destination = HOME_PAGE;
            request.setAttribute(ERROR_MSG_ATR, e.getMessage());
        }

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
