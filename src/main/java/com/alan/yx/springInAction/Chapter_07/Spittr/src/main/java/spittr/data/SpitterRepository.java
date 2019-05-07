package com.alan.yx.springInAction.Chapter_07.Spittr.src.main.java.spittr.data;


import com.alan.yx.springInAction.Chapter_07.Spittr.src.main.java.spittr.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
