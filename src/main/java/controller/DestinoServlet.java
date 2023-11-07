package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import modelos.Destino;

@WebServlet(urlPatterns = { "/destino", "/destino-create", "/destino-edit", "/destino-update", "/destino-delete" })
public class DestinoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DestinoDAO destinoDAO = new DestinoDAO();

    public DestinoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/destino":
                read(request, response);
                break;
            case "/destino-create":
                create(request, response);
                break;
            case "/destino-edit":
                edit(request, response);
                break;
            case "/destino-update":
                update(request, response);
                break;
            case "/destino-delete":
                delete(request, response);
                break;
            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Destino> listaDestinos = destinoDAO.read();
        request.setAttribute("listaDestinos", listaDestinos);
        RequestDispatcher rd = request.getRequestDispatcher("/views/destinos/index.jsp");
        rd.forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int idPromocao = Integer.parseInt(request.getParameter("idPromocao"));

        // Crie um objeto Destino com os parâmetros
        Destino novoDestino = new Destino();
        novoDestino.setNome_Destino(nome);
        novoDestino.setDescricao(descricao);
        novoDestino.setID_Promocao(idPromocao);

        // Chame o método create do DestinoDAO para inserir o novo destino no banco de dados
        destinoDAO.create(novoDestino);

        // Redirecione de volta à página de listagem de destinos
        response.sendRedirect("destino");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID do destino a ser editado a partir dos parâmetros da solicitação
        int id = Integer.parseInt(request.getParameter("id"));

        // Consulte o destino com base no ID
        Destino destino = destinoDAO.readById(id);

        // Defina o destino como um atributo da solicitação
        request.setAttribute("destino", destino);

        // Encaminhe a solicitação para a página de edição
        RequestDispatcher rd = request.getRequestDispatcher("/views/destinos/edit.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int idPromocao = Integer.parseInt(request.getParameter("idPromocao"));

        // Consulte o destino existente com base no ID
        Destino destinoExistente = destinoDAO.readById(id);

        // Atualize os atributos do destino com os novos valores
        destinoExistente.setNome_Destino(nome);
        destinoExistente.setDescricao(descricao);
        destinoExistente.setID_Promocao(idPromocao);

        // Chame o método update do DestinoDAO para atualizar o destino
        destinoDAO.update(destinoExistente);

        // Redirecione de volta à página de listagem de destinos
        response.sendRedirect("destino");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o ID do destino a ser excluído a partir dos parâmetros da solicitação
        int id = Integer.parseInt(request.getParameter("id"));

        // Chame o método delete do DestinoDAO para excluir o destino
        destinoDAO.delete(id);

        // Redirecione de volta à página de listagem de destinos
        response.sendRedirect("destino");
    }
}
