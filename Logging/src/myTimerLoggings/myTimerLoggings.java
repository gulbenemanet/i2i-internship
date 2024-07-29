package myTimerLoggings;
import org.apache.logging.log4j.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {

	private static Logger testLogger = LogManager.getLogger(myTimerLoggings.class.getName());
	static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	public static void main(String[] args) {

		debug();
		info();
		error();
		
	}
	public static void debug() {
		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	    	@Override
	        public void run() {
	    		testLogger.debug("Debug Log Time: " + sdf.format(Calendar.getInstance().getTime()));
	        }
	     }, 0, 1000); 		
    }
	public static void info() {
		Timer timer = new Timer();
	     timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                Calendar now = Calendar.getInstance();
	                now.set(Calendar.SECOND, 0);
	                testLogger.info("Info Log Time: " + sdf.format(now.getTime()));
	            }
	        }, 0, 60000);
    }
	public static void error() {
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar now = Calendar.getInstance();
                now.set(Calendar.MINUTE, 0);
                now.set(Calendar.SECOND, 0);
                testLogger.error("Error Log Time: " + sdf.format(now.getTime()));
            }
        }, 0, 3600000); 

    }
}