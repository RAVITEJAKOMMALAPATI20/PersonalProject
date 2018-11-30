/**
 * 
 */
package com.moviecentral.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moviecentral.pojos.PlayHistory;
import com.moviecentral.services.PlayService;


/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/play")
public class PlayController {
	
	
	@Autowired
	private PlayService playService;
	
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveplayHistory")
public PlayHistory savePlayHistory(@RequestBody PlayHistory playHistory) {
	
System.out.println(playHistory.getUser());
	
	
	PlayHistory resPlayHistory=playService.savePlayHistory(playHistory);

		
		
		return resPlayHistory;
	}
	
	
	@GetMapping("/getUserPlayHistory")
	public List<PlayHistory> getUserPlayHistory(String username) {
		List<PlayHistory>  reslistUserSubscription =playService.getUserPlayHistoryService(username);
		return reslistUserSubscription;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getToptenUsersNumberOfPlays")
	public List<Object> getToptenUsers(String duration){
		List<Object>  res= playService.getToptenUsersService(duration);
		return res;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/gettoptenMovieNumberOfPlays")
	public List<Object> getTopMovieNumberOfPlays(String duration){
		List<Object>  res= playService.getTopMovieNumberOfPlaysService(duration);
		return res;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getMovieNumberOfPlays")
	public List<Object> getMoviePlayCount(String duration){
		List<Object>  res= playService.getMoviePlayCountService(duration);
		return res;
	}

}


