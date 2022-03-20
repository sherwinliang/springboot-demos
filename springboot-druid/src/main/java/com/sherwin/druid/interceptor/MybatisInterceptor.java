package com.sherwin.druid.interceptor;

import com.alibaba.druid.pool.DruidPooledStatement;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/* @description: mybatis拦截器，对结果进行拦截，需要返回java map结果集时处理重名字段
 * @author: Sherwin Liang
 * @timestamp: 2022/3/20 13:40
*/
@Intercepts({@Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class})})
public class MybatisInterceptor implements Interceptor {
    private static final Logger logger= LoggerFactory.getLogger(MybatisInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object arg0 = invocation.getArgs()[0];
        PreparedStatementProxyImpl preparedStatement = null;
        //因为使用了Druid，需要从DruidPooledStatement中获取到jdbc的preparedStatement
        if(arg0 instanceof DruidPooledStatement){
            DruidPooledStatement druidPooledStatement = (DruidPooledStatement) arg0;
            if(druidPooledStatement.getStatement() instanceof PreparedStatement)
                preparedStatement = (PreparedStatementProxyImpl) druidPooledStatement.getStatement();
        }
        if(preparedStatement == null)
            return invocation.proceed();
        String sql = preparedStatement.getSql();
        //获取参数，符合标志描述就处理map返回类型
        if(!sql.endsWith("9=?")){
            return invocation.proceed();
        }
        List<Map<String, Object>> result = new ArrayList<>();
        //处理结果集，只需要结果不为空的数据字段
        try{
            ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
            ResultSet rs = preparedStatement.getResultSet();
            int count = resultSetMetaData.getColumnCount();
            String columnName = null;
            while(rs.next()){
                Map<String, Object> resultMap = new HashMap<>();
                for(int i=1;i<=count;i++){
                    columnName = resultSetMetaData.getColumnName(i);
                    if(rs.getObject(i) != null){
                        resultMap.put(columnName, rs.getObject(i));
                    }
                }
                result.add(resultMap);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        logger.warn(invocation.toString());
        return result;
    }
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }
    @Override
    public void setProperties(Properties properties) {
        logger.warn(properties.toString());
    }
}
