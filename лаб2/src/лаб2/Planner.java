package лаб2;
import java.util.ArrayList; 
import java.util.Random; 
 
public class Planner { 
 private static ArrayList<Process> processes; 
 private static ArrayList<Thread> threads; 
 private static Random rand = new Random(); 
 
 public Planner() { 
 processes = new ArrayList<Process>(); 
 threads = new ArrayList<Thread>(); 
 Random random = new Random(); 
 int count = random.nextInt(8) + 2; 
 for (int i = 0; i < count; i++) { 
 threads.add(new Thread(i, rand.nextInt(10) + 2, 4)); 
 } 
 getInfo(); 
 } 
 
 private static void getInfo() { 
 for (var thr : threads) { 
 System.out.println(thr.getDescription() + "Quantity time= " + thr.getQuantTime()); 
 } 
 System.out.println(); 
 } 
 
 public void start() { 
 int count = 0; 
 while (threads.size() != 0) { 
 for (int i = 0; i < threads.size(); i++) { 
 while (threads.get(i) == null) { 
 i++; 
 if (i == threads.size()) { 
 i = 0; 
 break; 
 } 
 } 
 count = threads.get(i).quant(); 
 while (count > 0 && i < threads.size()) { 
 while (threads.get(i) == null) { 
 i++; 
 if (i >= threads.size()) { 
 i = 0; 
 break; 
 } 
 } 
 System.out.println(threads.get(i).getDescription() + " quant = " + threads.get(i).getQuantTime()); 
 if (threads.get(i).getQuantTime() >= 0) { 
 System.out.println(threads.get(i).decreaseTime()); 
 if (threads.get(i).getQuantTime() == 0) { 
 System.out.println(threads.get(i).getDescription() + " завершил свою работу"); 
 threads.remove(i); 
 count = 0; 
 } 
 } 
 i++; 
 if (count > 0 && i == threads.size()) 
 i = 0; 
 } 
 i = -1; 
 System.out.println(); 
 } 
 } 
 } 
}
