/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.jdbc;

import com.butanclub.dao.ConciertoDAO;
import com.butanclub.model.Concierto;
import com.butanclub.model.Entrada;
import com.butanclub.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Luis
 */
@Repository
public class ConciertoDAOjdbc implements ConciertoDAO {

    private static final String connPoolName = "java:comp/env/jdbc/ButanClub";  //Tomcat
    private static final String[] autoField = {"id"};
    private static final String SQL_BUSCACON = "SELECT * FROM Conciertos where id=?";
    private static final String SQL_BUSCATODOS = "SELECT * FROM Conciertos";
    private static final String SQL_CREA = "INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES (?, ?, ?,?,?,?,? )";
    private static final String SQL_ACTUALIZA = "UPDATE Conciertos set  pass=?, nombre=?, apellidos=?, correo=?, fnac=?, tlfn=?, tipousuario=?WHERE id=?";
    private static final String SQL_BORRA = "DELETE FROM Conciertos WHERE id=?";
    private static final String SQL_BORRA_ENTRADA = "DELETE FROM Entradas WHERE id=?";
    private static final String SQL_CONCIERTOSUSUARIO = "SELECT * FROM Conciertos WHERE id in (SELECT DISTINCT concierto FROM Entradas WHERE usuario=?)";
    private static final String SQL_BUSCAPROXIMOSCONIERTOS = "SELECT * FROM (SELECT * FROM BUTAN.CONCIERTOS  order by fecha asc ) conciertos FETCH FIRST 3 ROWS ONLY";
    @Autowired
    private DataSource ds = null;

    public ConciertoDAOjdbc() {
//        if (ds == null) {
//            try {
//                Context context = new InitialContext();
//                ds = (DataSource) context.lookup(connPoolName);
//            } catch (NamingException ex) {
//                Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    private Concierto conciertoMapper(ResultSet rs) throws SQLException {
        Concierto c;
        c = new Concierto(
                rs.getInt("id"),
                rs.getString("imagen"),
                rs.getString("nombre"),
                rs.getString("artista"),
                Float.parseFloat(rs.getString("precio")),
                rs.getString("fecha"),
                rs.getString("hora"),
                rs.getString("genero"));

        return c;
    }

    @Override
    public List<Concierto> buscaTodos() {
        List<Concierto> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCATODOS);
                ResultSet rs = stmn.executeQuery()) {
            while (rs.next()) {
                lista.add(conciertoMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean borra(Integer _id) {
        boolean borrado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BORRA);
                PreparedStatement stmn2 = conn.prepareStatement(SQL_BORRA_ENTRADA)) {
            stmn.setInt(1, _id);            
            stmn2.setInt(1, _id);
            stmn2.executeUpdate();
            borrado = (stmn.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return borrado;
    }

    @Override
    public Concierto buscaConcierto(Integer _id) {
        Concierto c = null;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCACON)) {
            stmn.setInt(1, _id);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                c = conciertoMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public boolean crea(Concierto c) {
        boolean creado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CREA, autoField)) {
            try (ResultSet rs = stmn.getGeneratedKeys()) {
                //Get autogenerated field value
                if (rs != null && rs.next()) {
                    int nuevoId = rs.getInt(1); //RS has only one field with key value
                    c.setId(nuevoId);
                    creado = true;
                }
            } catch (Exception ex) {
                Logger.getLogger(ConciertoDAOjdbc.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            stmn.setString(1, "concierto9.jpg");
            stmn.setString(2, c.getNombre());
            stmn.setString(3, c.getArtista());
            stmn.setFloat(4, c.getPrecio());
            stmn.setString(5, c.getFecha());
            stmn.setString(6, c.getHora());
            stmn.setString(7, c.getGenero());

            stmn.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ConciertoDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return creado;
    }

    @Override
    public boolean guarda(Concierto c) {
        boolean actualizado = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CREA)) {
            stmn.setString(1, c.getImagen());
            stmn.setString(2, c.getNombre());
            stmn.setString(3, c.getArtista());
            stmn.setFloat(4, c.getPrecio());
            stmn.setString(5, c.getFecha());
            stmn.setString(6, c.getHora());
            stmn.setString(7, c.getGenero());
            stmn.setInt(8, c.getId());

            if (stmn.executeUpdate() == 1) {
                actualizado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConciertoDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return actualizado;

    }

    @Override
    public List<Concierto> buscaConciertosUsuario(String usuario) {
        List<Concierto> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_CONCIERTOSUSUARIO)) {
            stmn.setString(1, usuario);

            try (ResultSet rs = stmn.executeQuery()) {
                while (rs.next()) {
                    lista.add(conciertoMapper(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public List<Concierto> buscaProximosConciertos() {
        List<Concierto> lista = new ArrayList<>();
        try (Connection conn = ds.getConnection();
                PreparedStatement stmn = conn.prepareStatement(SQL_BUSCAPROXIMOSCONIERTOS);
                ResultSet rs = stmn.executeQuery()) {
            while (rs.next()) {
                lista.add(conciertoMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
