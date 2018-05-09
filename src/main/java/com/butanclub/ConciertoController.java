/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub;

import com.butanclub.dao.ConciertoDAO;
import com.butanclub.dao.EntradaDAO;/*
import com.butanclub.jdbc.ConciertoDAOjdbc;
import com.butanclub.jdbc.EntradaDAOjdbc;*/
import com.butanclub.model.Concierto;
import com.butanclub.model.Entrada;/*
import com.butanclub.model.Usuario;*/
import java.io.IOException;
import java.util.List;/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;*/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/conciertos")
@SessionAttributes("usuario")    //  -- Identifica el usuario del contexto de sesion
public class ConciertoController {

    @Autowired
    private EntradaDAO entradas;
    @Autowired
    private ConciertoDAO conciertos;

    public ConciertoController() {
    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        model.addAttribute("svlURL", request.getContextPath() + request.getServletPath() + "/conciertos");
        model.addAttribute("listadoConciertos", conciertos.buscaTodos().toArray());

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String proximosconciertos(ModelMap model) {
        List<Concierto> proximosConciertos = conciertos.buscaProximosConciertos();
        model.addAttribute("listadoProximosConciertos", proximosConciertos);
        return "conciertos/inicio";

    }

    @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public String listado(ModelMap model) {
        List<Concierto> listaConciertos = conciertos.buscaTodos();
        model.addAttribute("listadoConciertos", listaConciertos);
        return "conciertos/conciertos";
    }

    @RequestMapping(value = "/solicitarSala", method = RequestMethod.GET)
    public String solicitarSala(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Concierto c = new Concierto();
        if (validaConcierto(request, c)) {
            conciertos.crea(c);

        }
        return "redirect:/main/usuarios";
    }

    @RequestMapping(value = "/comprarEntrada", method = RequestMethod.POST)
    public String compraEntrada(ModelMap model, HttpServletRequest request) {
        int idconcierto = Integer.parseInt(request.getParameter("idconcierto"));

        Concierto c = conciertos.buscaConcierto(idconcierto);
        model.addAttribute("conciertoCompra", c);
        return "conciertos/comprar-entrada";
    }

    @RequestMapping(value = "/ConfirmacionCompra", method = RequestMethod.POST)
    public String confirmacioncompra(ModelMap model, HttpServletRequest request) {
        String usuario = request.getParameter("usuario-comprador");
        int idConcierto = Integer.parseInt(request.getParameter("concierto-comprado"));
        int cantidad = Integer.parseInt(request.getParameter("numero-entradas"));

        Concierto c = conciertos.buscaConcierto(idConcierto);
        model.addAttribute("conciertoCompra", c);

        Entrada entrada = new Entrada(usuario, idConcierto, cantidad);
        entradas.crea(entrada);
        model.addAttribute("entrada", entrada);

        return "conciertos/ConfirmacionCompra";
    }

    private boolean validaConcierto(HttpServletRequest request, Concierto c) {
        c.setNombre(request.getParameter("nombre"));
        c.setArtista(request.getParameter("artista"));
        c.setFecha(request.getParameter("fecha"));
        c.setGenero(request.getParameter("genero"));
        c.setHora(request.getParameter("hora"));

        c.setPrecio(Integer.parseInt(request.getParameter("precio")));

        return true;
    }

}
