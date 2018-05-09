/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.dao;

import com.butanclub.model.Concierto;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Luis
 */
@Repository
public interface ConciertoDAO extends GenericDAO<Concierto, Integer> {

    public Concierto buscaConcierto(Integer id);

    public List<Concierto> buscaConciertosUsuario(String usuario);

    public List<Concierto> buscaProximosConciertos();
}
