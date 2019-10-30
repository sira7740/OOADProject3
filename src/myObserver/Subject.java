package myObserver;

/*
 * Interface Subject
 * This allows us to create template for our store details
 */


interface Subject {
	public void registerObserver(Observer o); 
    public void unregisterObserver(Observer o); 
    public void notifyObservers(); 

}
