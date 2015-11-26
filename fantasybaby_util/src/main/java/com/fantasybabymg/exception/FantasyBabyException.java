package com.fantasybabymg.exception;

import org.apache.log4j.Logger;

/**
 * 
 * @author FantasyBaby
 *
 */
public class FantasyBabyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -357369403994605794L;
	private Logger _log ;
	public FantasyBabyException() {
	}
	public FantasyBabyException(String message,Class<?> _class) {
		super(message);
		_log = Logger.getLogger(_class);
		_log.error(message);
		_log.error(message);
	}
	public FantasyBabyException(Exception e,Class<?> _class) {
		super(e);
		_log = Logger.getLogger(_class);
		_log.error(e.getMessage());
		_log.error(e.getStackTrace());
	}

}
