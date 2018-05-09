/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.dao;

import com.butanclub.model.Entrada;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose Manuel Navarro
 */
@Repository
public interface EntradaDAO extends GenericDAO<Entrada, Integer> {

    public Entrada bucaEntrada(Integer _id);

    public List<Entrada> buscaTodos(String _usuario);

}
