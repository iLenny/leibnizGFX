package leibnizGFX;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
/**
 * 
 * @author Leibniz H. Berihuete
 * Created on 8/21/2016 <br>
 * This class acts as a preloader, and it will load the thing(s) that the initMethod contains.<br>
 * After loading, the showMethod will run.
 */
public class Loader {
	private Task<Void> task;
	private Runnable initMethod;
	private Runnable showMethod;
	
	/**
	 * Constructor(Runnable, Runnable)
	 * @param initMethod holds the thing(s) that you want to initialize/load
	 * @param showMethod holds the thing(s) that you want to show.
	 */
	public Loader(Runnable initMethod, Runnable showMethod) {
		this.initMethod = initMethod;
		this.showMethod = showMethod;
	}
	
	public void load() {
		startLoading(initMethod);
		startRunning(showMethod);
	}
	
	private void startLoading(Runnable initMethod) {
		task = new Task<Void>() {
			@Override protected Void call() throws InterruptedException {
				if(initMethod != null) {
					initMethod.run();
				}				
				return null;
			}		
		};
		new Thread(task).start();		
	}
	
	private void startRunning(Runnable showMethod) {
		task.stateProperty().addListener((Observable, oldState, newState)-> {
			System.out.println(task.getProgress());
			if(newState == Worker.State.SUCCEEDED) {
				if(showMethod != null) {
					showMethod.run();
				}
			}
		});
	}
}
