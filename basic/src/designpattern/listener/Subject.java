package designpattern.listener;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> birds = new ArrayList<>();
	
	public void addListener(Bird bird){
		birds.add(bird);
	}
	
	public void removeListener(Observer bird){
		birds.remove(bird);
	}
	
	public void notifyBirds(String status){
		for(Observer bird : birds){
			if("open".equalsIgnoreCase(status)){
				bird.breakfast();
			}else{
				bird.bed();
			}
		}
	}
}
