package com.alan.yx.springInAction.Chapter_13.caching.src.main.java.spittr.db;

import com.alan.yx.springInAction.Chapter_13.caching.src.main.java.spittr.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * Repository interface with operations for {@link Spittle} persistence.
 *
 * @author habuma
 */
public interface SpittleRepository {

    long count();

    @Cacheable("spittleCache")
    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    @Cacheable(value = "spittleCache",
            unless = "#result.message.contains('NoCache')",
            condition = "#id>=10")
    Spittle findOne(long id);

    @CachePut(value = "spittleCache", key = "#result.id")
    Spittle save(Spittle spittle);

    @Cacheable("spittleCache")
    List<Spittle> findBySpitterId(long spitterId);

    @CacheEvict(value = "spittleCache", condition = "")
    void delete(long id);

}
