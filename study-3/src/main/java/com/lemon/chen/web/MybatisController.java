package com.lemon.chen.web;

import com.lemon.chen.dao.bean.MbUserPO;
import com.lemon.chen.dao.mapper.MbUserPOMapper;
import com.lemon.chen.util.datasource.DynamicDataSource;
import com.lemon.chen.util.datasource.DynamicDataSourceContextHolder;
import com.lemon.chen.util.datasource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenhualong on 2016/11/23.
 * <p>
 * 这个控制器主要用来测试如何使用多数据源
 */

@Controller
@RestController
public class MybatisController {


    @Autowired
    private MbUserPOMapper mbUserPOMapper;


    /**
     * 指定数据源进行开发
     *
     * @return
     */
    @RequestMapping("/single")
    @TargetDataSource(name = "ds1")
    public String testOne() {

        return mbUserPOMapper.selectByPrimaryKey(1).toString();
    }

    /**
     * 进行分库的事务测试
     *
     * @return
     */
    @RequestMapping("/single2")
    @TargetDataSource(name = "ds1")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String testOne2() {

        MbUserPO po2 = new MbUserPO();
        po2.setUserid(1);
        po2.setAge(123);
        po2.setUsername("chenhualog");
        mbUserPOMapper.updateByPrimaryKey(po2);

        throw new RuntimeException("我是故意抛个第二个数据库的错");
    }


    /**
     * 测试正常的事务
     *
     * @return
     */
    @RequestMapping("/single3")
    @TargetDataSource(name = "ds1")
    @Transactional
    public String testOne3() {

        MbUserPO po2 = new MbUserPO();
        po2.setUserid(1);
        po2.setAge(123);
        po2.setUsername("chenhualog");
        mbUserPOMapper.updateByPrimaryKey(po2);

        return "success";

    }


    /**
     * 测试双库操作
     * @return
     */
    @RequestMapping("/single4")
    public String testOne4() {

        DynamicDataSourceContextHolder.setDataSourceType("dataSource");

        MbUserPO po = mbUserPOMapper.selectByPrimaryKey(1);

        System.out.println(po.toString()+"=========默认数据库查询");

        DynamicDataSourceContextHolder.setDataSourceType("ds1");

        MbUserPO p2 = mbUserPOMapper.selectByPrimaryKey(1);

        System.out.println(p2.toString()+"=========多余数据库查询");

        return "success";

    }

}
