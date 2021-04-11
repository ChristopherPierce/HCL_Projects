package com.web.store.music_store.service;

import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.AlbumGenre;
import com.web.store.music_store.repository.AlbumGenreRepository;

@Service
public class AlbumGenreService {
	
	
	
	@Autowired
	AlbumGenreRepository repo;
	
	public void create(AlbumGenre obj) {
		repo.save(obj);
	}
	
	//This function has been modified
	public Iterable<AlbumGenre> read() throws ParseException{
		return breakList(0, (int)repo.count()-1, (List<AlbumGenre>)repo.findAll(), "name");
	}
	
	public void update(int id, String name, String artist, String price, Date release_date, String genre_name) {
		AlbumGenre album = repo.findById(id).get();
		album.setName(genre_name);
		album.setArtist(artist);
		album.setPrice(price);
		album.setRelease_date(release_date);
		album.setGenre_name(genre_name);
		repo.save(album);
	}
	
	public void delete(int id) {
		repo.delete(repo.findById(id).get());
	}
	
	//This function has been modified
	public List<AlbumGenre> search(String column, String value) throws ParseException {
		List<AlbumGenre> albums = (List<AlbumGenre>)repo.findAll();
		List<AlbumGenre> sortedAlbums;
		if(column.equals("name")) {
			sortedAlbums = albums.stream().filter(album->album.getName().equals(value)).collect(Collectors.toList()); 
			sortedAlbums = breakList(0,sortedAlbums.size()-1, sortedAlbums, "artist");
		} else if(column.equals("artist")) {
			sortedAlbums = albums.stream().filter(album->album.getArtist().equals(value)).collect(Collectors.toList());
			sortedAlbums = breakList(0,sortedAlbums.size()-1, sortedAlbums, "name");
		} else {
			sortedAlbums = albums.stream().filter(album->album.getGenre_name().equals(value)).collect(Collectors.toList());
			sortedAlbums = breakList(0,sortedAlbums.size()-1, sortedAlbums, "name");
		}
		return sortedAlbums;
	}
	public AlbumGenre find(int id) {
		AlbumGenre album = repo.findById(id).get();
		return album;
	}
	
	//This function has been added
	private List<AlbumGenre> breakList(int startIndex, int endIndex, List<AlbumGenre> albums, String column)
	    {
	       if (startIndex < endIndex)
	       {          
	           int midIndex = (startIndex + endIndex) / 2;
	           breakList(startIndex, midIndex, albums, column);
	           breakList(midIndex + 1, endIndex, albums, column);
	           combineLists(startIndex, midIndex, endIndex, albums, column);
	       }
	       return albums;
	   }
	
	//This function has been added
	private void combineLists(int startIndex, int midIndex, int endIndex, List<AlbumGenre> albums, String column)
	   {
	       AlbumGenre[] leftArray  = new AlbumGenre[midIndex - startIndex + 1];
	       AlbumGenre[] rightArray = new AlbumGenre[endIndex - midIndex];
	       for (int i = 0; i < leftArray.length; i++)
	           leftArray[i] = albums.get(startIndex + i);
	       for (int i = 0; i < rightArray.length; i++)
	           rightArray[i] = albums.get(midIndex + 1 + i);
	       int leftIndex = 0, rightIndex = 0;
	       int tempIndex = startIndex;    
	       while (leftIndex < leftArray.length && rightIndex < rightArray.length) { 
	    	   if(column.equals("name")) {
	    		   if (leftArray[leftIndex].getName().compareTo(rightArray[rightIndex].getName()) <= 0) albums.set(tempIndex++, leftArray[leftIndex++]);
	    		   else albums.set(tempIndex++, rightArray[rightIndex++]);   
	    	   } else if(column.equals("artist")) {
	    		   if (leftArray[leftIndex].getArtist().compareTo(rightArray[rightIndex].getArtist()) <= 0) albums.set(tempIndex++, leftArray[leftIndex++]);
	    		   else albums.set(tempIndex++, rightArray[rightIndex++]);   
	    	   } else {
	    		   if (leftArray[leftIndex].getGenre_name().compareTo(rightArray[rightIndex].getGenre_name()) <= 0) albums.set(tempIndex++, leftArray[leftIndex++]);
	    		   else albums.set(tempIndex++, rightArray[rightIndex++]);   
	    	   }
	       }  
	       while (leftIndex < leftArray.length) albums.set(tempIndex++, leftArray[leftIndex++]); 
	       while (rightIndex < rightArray.length) albums.set(tempIndex++, rightArray[rightIndex++]); 
	   }
}
