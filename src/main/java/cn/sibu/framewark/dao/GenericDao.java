package cn.sibu.framewark.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    int insert(T t);

    T selectOne(PK id);

    int update(T t);

    int delete(PK id);

    List<T> loadAll();

}
