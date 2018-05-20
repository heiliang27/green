package com.green.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.green.common.datasource.DruidProperties;

@Configurable
@EnableTransactionManagement(order = 2) // 由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan(basePackages = {"com.green.**.mapper"})    // @MapperScan可以指定要扫描的Mapper类的包的路径
public class MybatisConfig {
	
	@Autowired
	DruidProperties druidProperties;
	 /**
     * 另一个数据源
     */
    private DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println("MybatisConfig.dataSource--加载-------------------------");
        druidProperties.config(dataSource);
        return dataSource;
    }
}
