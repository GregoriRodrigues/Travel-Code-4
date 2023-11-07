package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PromocaoDAO;
import modelos.Promocao;

@WebServlet(urlPatterns = { "/promocao", "/promocao-create", "/promocao-edit", "/promocao-update", "/promocao-delete" })
public class PromocaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PromocaoDAO promocaoDAO;

    public PromocaoServlet() {
        super();
        promocaoDAO = new PromocaoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/promocao-create":
                showCreateForm(request, response);
                break;
            case "/promocao-edit":
                showEditForm(request, response);
                break;
            case "/promocao-update":
                updatePromocao(request, response);
                break;
            case "/promocao-delete":
                deletePromocao(request, response);
                break;
            default:
                listPromocoes(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listPromocoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = promocaoDAO.read();
        request.setAttribute("promocoes", promocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/promocao/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/promocao/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Promocao existingPromocao = promocaoDAO.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/promocao/edit.jsp");
        request.setAttribute("promocao", existingPromocao);
        dispatcher.forward(request, response);
    }

    private void updatePromocao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String detalhes = request.getParameter("detalhes");
        String dataInicio = request.getParameter("dataInicio");
        String dataFim = request.getParameter("dataFim");

        Promocao promocao = new Promocao();
        promocao.setID_Promocao(id);
        promocao.setDetalhes_Promocao(detalhes);
        promocao.setData_Inicio(dataInicio);
        promocao.setData_Fim(dataFim);

        promocaoDAO.update(promocao);
        response.sendRedirect("promocao");
    }

    private void deletePromocao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        promocaoDAO.delete(id);
        response.sendRedirect("promocao");
    }
}
