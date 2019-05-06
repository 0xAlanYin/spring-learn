package com.alan.yx.springInAction.Chapter_06.thymeleaf.src.main.java.spittr.data;

import com.alan.yx.springInAction.Chapter_06.jsp.src.main.java.spittr.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
