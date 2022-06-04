package com.crud.keycloak.controller;

import java.util.List;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.keycloak.model.Music;
import com.crud.keycloak.service.MusicService;

@RestController 
public class MusicController{
	
	@Autowired
	private MusicService musicService;
	
	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}


	//List all music records
	@GetMapping("/music")
	@RolesAllowed("admin")
	//Admin: vibhooti
	//Admin Password: vibhooti
	public ResponseEntity<?> getAllMusic(){
		return ResponseEntity.ok().body(musicService.getAllMusic());
	}

	//Get music by Id	
	@GetMapping("/music/{musicId}")
	@RolesAllowed("admin")
	//Admin: vibhooti
	//Admin Password: vibhooti
	public Music getMusicById(@PathVariable long musicId){
		return musicService.getMusicById(musicId);
	}
	
	//Get all music specific to a Uploader
	@GetMapping("/music/uploader/{musicUploader}")
	@RolesAllowed("user")
	//User1: vibhooti	Password: vibhooti
	//User2: aditi		Password: aditi
	public List<Music> getMusicByUploader(@PathVariable String musicUploader){
		return musicService.getMusicByUploader(musicUploader);
	}
	
	//Create a new music record
	@PostMapping("/music")
	public ResponseEntity<?> createMusic(@RequestBody Music music){
		return ResponseEntity.ok().body(this.musicService.createMusic(music));
	}
	
	//Update music record by music Id
	@PutMapping("/music/{id}")
	public ResponseEntity<Music> updateMusic(@PathVariable long id, @RequestBody Music music){
		music.setId(id);
		return ResponseEntity.ok().body(this.musicService.updateMusic(music));
	}
	
	//Delete music record by music Id
	@DeleteMapping("/music/{id}")
	public ResponseEntity<String> deleteMusic(@PathVariable long id){
		this.musicService.deleteMusic(id);
		return new ResponseEntity<String>("Music deleted successfully.", HttpStatus.OK);
	}
}