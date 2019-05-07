package com.alan.yx.springInAction.Chapter_10.jdbc.src.main.java.spittr.db;

import com.alan.yx.springInAction.Chapter_10.jdbc.src.main.java.spittr.domain.Spitter;

import java.util.List;


/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

  long count();
  
  Spitter save(Spitter spitter);
  
  Spitter findOne(long id);

  Spitter findByUsername(String username);

  List<Spitter> findAll();

}
