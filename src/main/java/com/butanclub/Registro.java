/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub;

import com.butanclub.dao.UsuarioDAO;
import com.butanclub.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pedro Luis
 */
@Controller
@RequestMapping("/registro")
@SessionAttributes("usuario")
public class Registro {

    @Autowired
    private UsuarioDAO usuarios;

    public Registro() {

    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        model.addAttribute("svlURL", request.getContextPath() + request.getServletPath() + "/registro");
        model.addAttribute("listadoUsuarios", usuarios.buscaTodos().toArray());
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String regitroUsuarioGET(@ModelAttribute("usuario") Usuario usu, ModelMap model) {
        model.addAttribute("usuario", usu);
        return "usuarios/RegistroUsuario";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String ewgistroUsuarioPOST(@ModelAttribute("usuario") Usuario usu, ModelMap model) {
        usuarios.crea(usu);
        return "usuarios/NuevoUsuario";

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
