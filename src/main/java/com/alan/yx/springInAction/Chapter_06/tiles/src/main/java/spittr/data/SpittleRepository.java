package com.alan.yx.springInAction.Chapter_06.tiles.src.main.java.spittr.data;

import java.util.List;

import com.alan.yx.springInAction.Chapter_06.jsp.src.main.java.spittr.Spittle;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
