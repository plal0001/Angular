/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.jdbc;
import com.butanclub.dao.UsuarioDAO;
import com.butanclub.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Luis
 */
@Repository
public class UsuarioDAOjdbc implements UsuarioDAO {

    private static final String connPoolName = "java:comp/env/jdbc/ButanClub";  //Tomcat

    private static final String SQL_BUSCAUSU = "SELECT * FROM Usuarios where usuario=?";
    private static final String SQL_BUSCATODOS = "SELECT * FROM Usuarios";
    private static final String SQL_CREA = "INSERT INTO Usuarios VALUES (?, ?, ?,?,?,?,?,? )";
    private static final String SQL_ACTUALIZA = "UPDATE Usuarios set  pass=?, nombre=?, apellidos=?, correo=?, fnac=?, tlfn=?, tipousuario=?WHERE usuario=?";
    private static final String SQL_BORRA = "DELETE FROM Usuarios WHERE usuario=?";
    private static final String SQL_BORRA_ENTRADA = "DELETE FROM Entradas WHERE usuario=?";

    @Autowired
    private DataSource ds ;

    public UsuarioDAOjdbc() {
//        if (ds == null) {
//            try {
//                Context context = new InitialContext();
//                ds = (DataSource) context.lookup(connPoolName);
//            } catch (NamingException ex) {
//                Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    private Usuario usuarioMapper(ResultSet rs) throws SQLException {
        Usuario u;
        u = new Usuario(rs.getString("usuario"),
                rs.getString("pass"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("correo"),
                rs.getString("tlfn"),
                rs.getString("tipousuario"),
                rs.getString("fnac"));

        return u;
    }

    @Override
    public boolean comprobarUsuario(String _usu) {
        boolean encontrado = false;
        Usuario u = null;

        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAUSU)) {
            stmn.setString(1, _usu);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                u = usuarioMapper(rs);
                if (u.getUsuario() == null ? _usu == null : u.getUsuario().equals(_usu)) {
                    encontrado = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return encontrado;
    }

    @Override
    public Usuario buscaUsuario(String _usu) {
        Usuario u = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAUSU)) {
            stmn.setString(1, _usu);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                u = usuarioMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public List<Usuario> buscaTodos() {
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCATODOS);
                ResultSet rs = stmn.executeQuery()) {
            while (rs.next()) {
                lista.add(usuarioMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean crea(Usuario u) {
        boolean creado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CREA)) {
            stmn.setString(1, u.getUsuario());
            stmn.setString(2, u.getContraseña());
            stmn.setString(3, u.getNombre());
            stmn.setString(4, u.getApellidos());
            stmn.setString(5, u.getCorreo());            
            stmn.setString(6, u.getfNacimiento());
            stmn.setInt(7, Integer.parseInt(u.getTelefono()));
            stmn.setString(8, u.getTipoUsuario());

            stmn.executeUpdate();
            creado = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return creado;
    }

    @Override
    public boolean guarda(Usuario u) {
        boolean actualizado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_ACTUALIZA)) {
            stmn.setString(1, u.getContraseña());
            stmn.setString(2, u.getNombre());
            stmn.setString(3, u.getApellidos());
            stmn.setString(4, u.getCorreo());            
            stmn.setString(5, u.getfNacimiento());
            stmn.setInt(6, Integer.parseInt(u.getTelefono()));
            stmn.setString(7, u.getTipoUsuario());
            stmn.setString(8, u.getUsuario());
            if (stmn.executeUpdate() == 1) {
                actualizado = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizado;
    }

    @Override
    public boolean borra(String _usu) {
        boolean borrado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BORRA);
                PreparedStatement stmn2 = conn.prepareStatement(SQL_BORRA_ENTRADA)) {
            stmn.setString(1, _usu);
            stmn2.setString(1, _usu);
            stmn2.executeUpdate();
            borrado = (stmn.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return borrado;
    }
}
