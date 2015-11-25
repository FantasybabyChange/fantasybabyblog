/*package com.fantasybabymg.db;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

*//**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 *//*
public class MybatisSessionFactory {

    *//** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     *//*
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static InputStream inputStream = null;
	private static SqlSessionFactoryBuilder builder = null; 
	private static SqlSessionFactory factory = null; 
	static {
    	try {
    		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    		builder = new SqlSessionFactoryBuilder();
    		factory = builder.build(inputStream);
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
    private MybatisSessionFactory() {
    }
	
	*//**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     *//*
    public static SqlSession getSession() {
    	SqlSession session = (SqlSession) threadLocal.get();

		if (session == null){
			if (factory == null) {
				rebuildSessionFactory();
			}
			session = (factory != null) ? factory.openSession()
					: null;
			threadLocal.set(session);
		}

        return session;
    }

	*//**
     *  Rebuild hibernate session factory
     *
     *//*
	public static void rebuildSessionFactory() {
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    		builder = new SqlSessionFactoryBuilder();
    		factory = builder.build(inputStream);
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	*//**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     *//*
    public static void closeSession(){
        SqlSession session = (SqlSession) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
//            session.clearCache();
            session.close();
        }
    }

	*//**
     *  return session factory
     *
     *//*
	public static SqlSessionFactory getSessionFactory() {
		return factory;
	}
}*/