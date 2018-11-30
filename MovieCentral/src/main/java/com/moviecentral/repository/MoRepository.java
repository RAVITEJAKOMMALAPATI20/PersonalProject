/**
 * 
 */
package com.moviecentral.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.moviecentral.pojos.MovieElastic;

/**
 * @author ravitejakommalapati
 *
 */
@Repository
public interface MoRepository extends ElasticsearchRepository<MovieElastic, String> {
	
}
