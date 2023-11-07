package controller;

import dao.RecebeContatoDAO;
import modelos.Contato;
import modelos.Destino;
import modelos.RecebeContato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/recebecontato")
public class RecebeContatoServlet extends HttpServlet {
    private RecebeContatoDAO recebeContatoDAO = new RecebeContatoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateRecebeContato(request, response);
                break;
            case "delete":
                deleteRecebeContato(request, response);
                break;
            case "list":
            default:
                listRecebeContatos(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createRecebeContato(request, response);
                break;
            case "update":
                updateRecebeContato(request, response);
                break;
            default:
                listRecebeContatos(request, response);
                break;
        }
    }

    private void listRecebeContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RecebeContato> recebeContatos = recebeContatoDAO.read();
        request.setAttribute("recebeContatos", recebeContatos);
        request.getRequestDispatcher("/recebecontato/index.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você deve preencher com as informações necessárias para exibir o formulário de criação
        request.getRequestDispatcher("/recebecontato/create.jsp").forward(request, response);
    }

    private void createRecebeContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Aqui você deve implementar a lógica para criar um novo RecebeContato
        // e redirecionar de volta para a página de listagem
        response.sendRedirect(request.getContextPath() + "/recebecontato?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você deve preencher com as informações necessárias para exibir o formulário de edição
        request.getRequestDispatcher("/recebecontato/edit.jsp").forward(request, response);
    }

    private void updateRecebeContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Aqui você deve implementar a lógica para atualizar um RecebeContato
        // e redirecionar de volta para a página de listagem
        response.sendRedirect(request.getContextPath() + "/recebecontato?action=list");
    }

    private void deleteRecebeContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Aqui você deve implementar a lógica para excluir um RecebeContato
        // e redirecionar de volta para a página de listagem
        response.sendRedirect(request.getContextPath() + "/recebecontato?action=list");
    }
}
