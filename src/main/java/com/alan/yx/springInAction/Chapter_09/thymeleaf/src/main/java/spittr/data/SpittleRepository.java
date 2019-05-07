package com.alan.yx.springInAction.Chapter_09.thymeleaf.src.main.java.spittr.data;

import com.alan.yx.springInAction.Chapter_09.thymeleaf.src.main.java.spittr.Spittle;

import java.util.List;


public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
