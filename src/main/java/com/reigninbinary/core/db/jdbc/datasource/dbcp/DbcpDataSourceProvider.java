package com.reigninbinary.core.db.jdbc.datasource.dbcp;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.reigninbinary.core.db.CoreDatabaseException;
import com.reigninbinary.core.db.jdbc.datasource.JdbcDataSourceConfig;
import com.reigninbinary.core.db.jdbc.datasource.JdbcDataSourceProvider;


public class DbcpDataSourceProvider implements JdbcDataSourceProvider {

	private static BasicDataSource dataSource;
    
    static {
    	dataSource = new BasicDataSource();
        
    	dataSource.setUrl(JdbcDataSourceConfig.getJdbcUrl());
    	dataSource.setUsername(JdbcDataSourceConfig.getJdbcUser());
    	dataSource.setPassword(JdbcDataSourceConfig.getJdbcPassword());
    	
    	// TODO: config these
    	dataSource.setMinIdle(5);
    	dataSource.setMaxIdle(10);
    	dataSource.setMaxOpenPreparedStatements(100);
    }

	@Override
	public DataSource getProviderDataSource() throws CoreDatabaseException {
		
		return dataSource;
	}
}
