/**
 * 
 */
package com.moviecentral.utils;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;
import com.moviecentral.pojos.MovieElastic;

/**
 * @author ravitejakommalapati
 *
 */


@Component
public class SearchQueryBuilder {
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	public List<MovieElastic> getAll(String text){
		
		QueryBuilder query= QueryBuilders.boolQuery()
				        .should(QueryBuilders.queryStringQuery(text)
						.lenient(true)
						.field("title")
						.field("actors")
						.field("director")
						).should(QueryBuilders.queryStringQuery("*"+text+"*")
								.lenient(true)
								.field("title")
								.field("actors")
								.field("director")
						   		);
		NativeSearchQuery build =new NativeSearchQueryBuilder().withQuery(query).withPageable(PageRequest.of(0, 5)).build();
		
		List<MovieElastic> res= elasticsearchTemplate.queryForList(build, MovieElastic.class);
		return res;
	}
public List<MovieElastic> getAllwithGenre(String text){
		
		QueryBuilder query= QueryBuilders.boolQuery().
				should(QueryBuilders.
						queryStringQuery(text)
						.lenient(true)
						.field("genre")
						).should(QueryBuilders.queryStringQuery("*"+text+"*")
								.lenient(true)
								.field("genre")
								);
		NativeSearchQuery build =new NativeSearchQueryBuilder().withQuery(query).build();
		List<MovieElastic> res= elasticsearchTemplate.queryForList(build, MovieElastic.class);
		return res;
	}
}
