package com.alan.yx.springInAction.Chapter_16.spitter_api_content_negotiation.src.main.java.spittr.data;


import com.alan.yx.springInAction.Chapter_16.spitter_api_content_negotiation.src.main.java.spittr.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
