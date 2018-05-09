/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro Luis
 * @param <T>
 * @param <K>
 */
@Repository
public interface GenericDAO<T, K> {

    //public T buscaID(K id);
    public List<T> buscaTodos();

    public boolean crea(T u);

    public boolean guarda(T u);

    public boolean borra(K id);

}
