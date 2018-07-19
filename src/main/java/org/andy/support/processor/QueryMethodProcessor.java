package org.andy.support.processor;

import org.andy.support.DaoMethodProcessor;
import org.andy.support.annotation.Query;

import antlr.collections.List;

public class QueryMethodProcessor extends DaoMethodProcessor<Query> {

	@Override
	public Object process() {
		// TODO Auto-generated method stub
		String queryString = annotation.value();
		org.hibernate.Query query = hibernateDao.createQuery(queryString);
		return query.list();
	}

}
