// "static void main" must be defined in a public class.

class ThreadDemo implements Runnable
{
    //Thread Object
    Thread t;
    
    //Constructor
    ThreadDemo(String name)
    {
        t=new Thread(this,name);
        t.start();
    }
    
    //Run method implementation
    public void run()
    {
        try
        {
            System.out.println("Child Thread "+t.getName()+" is processing the task");
            t.sleep(100);
        }catch(Exception e)
        {
            System.out.println("Exeption in child thread");
        }
        
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Hi I am Main thread");
        System.out.println("Now spawning the child threads");
        long start=System.currentTimeMillis();
        ThreadDemo td1=new ThreadDemo("ONE");
        ThreadDemo td2=new ThreadDemo("TWO");
        ThreadDemo td3=new ThreadDemo("THREE");
        ThreadDemo td4=new ThreadDemo("FOUR");
        ThreadDemo td5=new ThreadDemo("FIVE");
        try
        {
            td1.t.join();
            td2.t.join();
            td3.t.join();
            td4.t.join();
            td5.t.join();
            
        }catch(Exception e)
        {
            System.out.println("Exception in joining threads");
        }
        long end=System.currentTimeMillis();
        System.out.println("---------------------------------------------");
        System.out.println("Multi-Threaded execution time -> "+(end-start));
        System.out.println("---------------------------------------------");
        start=System.currentTimeMillis();
        for(int i=0;i<5;i++)
        {
            try
            {
                System.out.println("Single thread pricessing task "+i);
            Thread.sleep(100);
            }catch(Exception e)
            {
                System.out.println("Exeption in main thread");
            }
        }
        end=System.currentTimeMillis();
        System.out.println("---------------------------------------------");
        System.out.println("Single-Threaded execution time -> "+(end-start));
        System.out.println("---------------------------------------------");
    }
}
