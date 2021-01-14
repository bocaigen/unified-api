package com.bobo.service;

import com.bobo.repository.GirlRepository;
import com.bobo.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/5.
 */

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询的方法上不用添加事务
     */
    @Transactional
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("B");
        girlA.setName("赵丽颖");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(28);
        girlB.setCupSize("FGGGG");
        girlB.setName("赵雅芝");
        girlRepository.save(girlB);

    }

}
