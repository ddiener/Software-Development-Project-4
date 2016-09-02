package edu.uga.cs1302.mp3files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;

public class MP3File {
    

    public String pathname, author, date, album, title;
    
    public MP3File() {
	pathname = "No pathname given.";
	author = "No author given.";
	date = "No date given.";
	album = "No album name given.";
	title = "No title given.";
    }
    
    public MP3File(String pathname) {
	try {
	    FileInputStream fis        = new FileInputStream( pathname );
	    BufferedInputStream bis    = new BufferedInputStream(fis);
	    AudioFileFormat mpegFormat = AudioSystem.getAudioFileFormat(bis);
	    Map properties             = mpegFormat.properties();

	    if(((String) properties.get( "author" )).equals(null))
		author = "No author given.";
	    else
		author = ((String) properties.get( "author" ));
	                
	    if(((String) properties.get( "album" )).equals(null) )
		album = "No album name given.";
	    else
		album = ((String) properties.get( "album"));
	    
	    if(((String) properties.get( "title" )).equals(null) )
		title = "No title given.";
	    else
		title = (String) properties.get( "title" );
	               
	    if(((String) properties.get( "date" )).equals(null) )
		date = "No date given.";
	    else
		date = (String) properties.get( "date" );
	}
	catch( ArrayIndexOutOfBoundsException oobe ) {
	    System.err.println( "Usage: java PrintMP3Properties file.mp3" );
	}
	catch( Exception e ) {
	    System.out.println(e); 
	}

	
    }
    
    public String getPath() {
	return pathname;
    }
    
    public void setPath(String pathname) {
	if(!pathname.equals(null))
	    this.pathname = pathname;
    }
    
    public String getAuthor() {
	return author;
    }
    
    public void setAuthor(String author) {
	if(!author.equals(null))
	    this.author = author;
    }
    
    public String getAlbum() {
	return album;
    }
    
    public void setAlbum(String album) {
	if(!album.equals(null))
	    this.album = album;
    }
    
    public String getDate() {
	return date;
    }
    
    public void setDate(String date) {
	if(!date.equals(null))
	    this.date = date;
    }
    
    public String getTitle() {
	return title;
    }
    
    public void setTitle(String title) {
	if(!title.equals(null))
	    this.title = title;
    }
    
    public String toString() {
	 String tempString = "Information about: " + pathname + "\n" + "-------------------------- " + "\n" +
	     "Author: " + getAuthor() + "\n" + "Album:  " + getAlbum() + "\n" + "Title:  " + getTitle() +
	     "\n" + "Date:   " + getDate();
	 return tempString;
    }
    
    public boolean equals(Object anObject) {
	if(anObject instanceof MP3File) {
	    if(album.equals(((MP3File)anObject).getAlbum()) && title.equals(((MP3File)anObject).getTitle()) &&
	       author.equals(((MP3File)anObject).getAuthor()) && date.equals(((MP3File)anObject).getDate()))
		return true;
	    else
		return false;
	}
	else
	    return false;
    }
    
    public void play() {
	Scanner keyboard = new Scanner(System.in);
	MP3Player player = new MP3Player();
	boolean stop = false;
	String selection = null;
	
	while( !stop ) {

	    // start playing this file
	    player.play( this.getPath() );
	    // but wait until it finishes, or is interrupted by the user
	    player.waitForPlaybackFinish();

	    // now, check what to do next
	    System.out.println( "Enter 'q' to quit the loop, or any other char to continue" );

	    selection = keyboard.next();
	    if( selection.equals( "q" ) )
		stop = true;
	}

    }
}
