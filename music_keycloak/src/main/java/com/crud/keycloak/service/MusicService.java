package com.crud.keycloak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.keycloak.model.Music;

@Service
public interface MusicService {
	List<Music> getAllMusic();
	Music getMusicById(long musicId);
	Music createMusic(Music music);
	Music updateMusic(Music music);
	List<Music> getMusicByUploader(String musicUploader);
	void deleteMusic(long id);
}