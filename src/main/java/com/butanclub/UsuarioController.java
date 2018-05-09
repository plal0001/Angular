/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub;

import com.butanclub.dao.UsuarioDAO;
import com.butanclub.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.butanclub.dao.ConciertoDAO;
import com.butanclub.model.Concierto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarios;
    @Autowired
    private ConciertoDAO conciertos;

    public UsuarioController() {

    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        model.addAttribute("svlURL", request.getContextPath() + request.getServletPath() + "/usuarios");
        model.addAttribute("listadoConciertos", conciertos.buscaTodos().toArray());
        model.addAttribute("listadoUsuarios", usuarios.buscaTodos().toArray());
    }

    @RequestMapping(value = "/edita", method = RequestMethod.GET)
    public String edita(ModelMap model, HttpServletRequest request) {
        String usuarioEdita = request.getParameter("usuario-edita");
        Usuario usu = usuarios.buscaUsuario(usuarioEdita);
        model.addAttribute("usuario", usu);
        return "usuarios/EditaUsuario";
    }

    @RequestMapping(value = "/borra", method = RequestMethod.GET)
    public String borra(ModelMap model, HttpServletRequest request) {
        String usuarioBorra = request.getParameter("usuario-borra");
        usuarios.borra(usuarioBorra);
        List<Usuario> lu = usuarios.buscaTodos();
        model.addAttribute("listadoUsuarios", lu);
        return "redirect:.";
    }

    @RequestMapping(value = "/RegistroUsuario", method = RequestMethod.GET)
    public String registroUsuario(ModelMap model) {
        Usuario usu = new Usuario();
        model.addAttribute("usuario", usu);
        return "usuarios/RegistroUsuario";
    }

    @RequestMapping(value = "/borraConcierto", method = RequestMethod.GET)
    public String borraConcierto(ModelMap model, HttpServletRequest request) {
        int conciertoBorra = Integer.parseInt(request.getParameter("concierto-borra"));
        conciertos.borra(conciertoBorra);
        return "redirect:.";
    }

    @RequestMapping(value = "/acceso", method = RequestMethod.GET)
    public String acceso(ModelMap model, HttpServletRequest request) {
        List<Concierto> lc = conciertos.buscaTodos();
        model.addAttribute("listadoconciertos", lc);
        Usuario usuario = usuarios.buscaUsuario(request.getRemoteUser());
        String IdUsuario = usuario.getUsuario();
        List<Concierto> lcu = conciertos.buscaConciertosUsuario(IdUsuario);
        model.addAttribute("listadoConciertosUsuario", lc);
        List<Usuario> lu = usuarios.buscaTodos();
        model.addAttribute("listadoUsuario", lu);
        model.addAttribute("log", usuario);
        return "usuarios/infoUsuarioAdministrador";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String poorDefecto(ModelMap model, HttpServletRequest request) {
        String url = "redirect:.";
        List<Concierto> lc = conciertos.buscaTodos();
        model.addAttribute("listadoconciertos", lc);
        Usuario usuario = usuarios.buscaUsuario(request.getRemoteUser());
        String IdUsuario = usuario.getUsuario();
        List<Concierto> lcu = conciertos.buscaConciertosUsuario(IdUsuario);
        model.addAttribute("listadoConciertosUsuario", lcu);
        List<Usuario> lu = usuarios.buscaTodos();
        model.addAttribute("listadoUsuario", lu);
        model.addAttribute("log", usuario);
        if (request.isUserInRole("Registrado")) {

            url = "usuarios/infoUsuario";
        }
        if (request.isUserInRole("Artista")) {

            url = "usuarios/infoUsuarioArtista";
        }
        if (request.isUserInRole("Administrador")) {

            url = "usuarios/infoUsuarioAdministrador";
        }
        return url;
    }

    @RequestMapping(value = "/edita", method = RequestMethod.POST)
    public String editaPOST(ModelMap model, HttpServletRequest request) {
        Usuario usu = new Usuario();
        if (validaUsuario(request, usu)) {
            usu.setTipoUsuario(request.getParameter("tipoUsuario"));
            usuarios.guarda(usu);
            List<Usuario> lu = usuarios.buscaTodos();
            model.addAttribute("listadoUsuarios", lu);
            return "usarios/infoUsuario";
        }
        return "redirect:.";
    }

    @RequestMapping(value = "/RegistroUsuario", method = RequestMethod.POST)
    public String registroUsuarioPOST(ModelMap model, HttpServletRequest request) {
        Usuario usu = new Usuario();
        if (validaUsuario(request, usu)) {
            usuarios.crea(usu);
            model.addAttribute("usuario", usu);
            return "usuarios/NuevoUsuario";
        }
        return "redirect:.";
    }

    private boolean validaUsuario(HttpServletRequest request, Usuario usu) {
        usu.setApellidos(request.getParameter("apellidos"));
        usu.setContraseña(request.getParameter("pass"));
        usu.setCorreo(request.getParameter("email"));
        usu.setNombre(request.getParameter("nombre"));
        usu.setTelefono(request.getParameter("tlfn"));
        usu.setTipoUsuario("Registrado");
        usu.setUsuario(request.getParameter("usuario"));
        usu.setfNacimiento(request.getParameter("fecha"));

        return true;
    }
}
