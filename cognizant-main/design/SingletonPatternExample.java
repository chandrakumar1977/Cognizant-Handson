class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("Logger instance is created");
    };
    public static Logger GetInstance(){
        if(instance == null){
            instance=new Logger();
        }
        return instance;
    }
    public void log(String message){
        System.out.println("Log: "+message);
    }
}
    class SingletonPatternExample{
        public static void main(String[] args){
            Logger logger1=Logger.GetInstance();
            Logger logger2=Logger.GetInstance();
            logger1.log("First greetings!");
            logger2.log("Second greetings!");

            if(logger1==logger2){
                System.out.println("Both uses same objects and follows the singleton pattern");
            }else{
                System.out.println("Both uses different objects ");
            }
        }
    }
