package com.bobo.repository;

import com.bobo.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 通过年龄查询女生
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
