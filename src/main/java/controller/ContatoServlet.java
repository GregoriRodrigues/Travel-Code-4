package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import modelos.Contato;

@WebServlet(urlPatterns = { "/contato", "/contato-create", "/contato-edit", "/contato-update", "/contato-delete" })
public class ContatoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContatoDAO contatoDAO;

    public ContatoServlet() {
        super();
        contatoDAO = new ContatoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/contato-create":
                showCreateForm(request, response);
                break;
            case "/contato-edit":
                showEditForm(request, response);
                break;
            case "/contato-update":
                updateContato(request, response);
                break;
            case "/contato-delete":
                deleteContato(request, response);
                break;
            default:
                listContatos(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contato> contatos = contatoDAO.read();
        request.setAttribute("contatos", contatos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/contato/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/contato/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contato existingContato = contatoDAO.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/contato/edit.jsp");
        request.setAttribute("contato", existingContato);
        dispatcher.forward(request, response);
    }

    private void updateContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mensagem = request.getParameter("mensagem");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String assunto = request.getParameter("assunto");

        Contato contato = new Contato();
        contato.setID_Contato(id);
        contato.setMensagem(mensagem);
        contato.setEmail(email);
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setAssunto(assunto);

        contatoDAO.update(contato);
        response.sendRedirect("contato");
    }

    private void deleteContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        contatoDAO.delete(id);
        response.sendRedirect("contato");
    }
}
