//日志记录器接口：抽象产品
interface Log {
    public void writeLog();
}

//数据库日志记录器：具体产品
class DatabaseLog implements Log {
    public void writeLog() {
        System.out.println("已选择数据库日志记录。");
    }
}

//文件日志记录器：具体产品
class FileLog implements Log {
    public void writeLog() {
        System.out.println("已选择文件日志记录。");
    }
}
class ConsoleLogger implements Log {
    public void writeLog() {
        System.out.println("已选择控制台日志记录。");
    }
}

//日志记录器工厂接口：抽象工厂
interface LogFactory {
    public Log createLog();
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLogFactory implements LogFactory {
    public Log createLog() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Log log = new DatabaseLog();
        //初始化数据库日志记录器，代码省略
        return log;
    }
}

//文件日志记录器工厂类：具体工厂
class FileLogFactory implements LogFactory {
    public Log createLog() {
        //创建文件日志记录器对象
        Log log = new FileLog();
        //创建文件，代码省略
        return log;
    }
}
class ConsoleLoggerFactory implements LogFactory {
    public Log createLog() {
        //创建文件日志记录器对象
        Log log = new ConsoleLogger();
        //创建文件，代码省略
        return log;
    }
}
public class ConsoleLog {
    public static void main(String args[]) {
        LogFactory factory;
        Log log1;
        factory = new FileLogFactory(); //可引入配置文件实现
        log1 = factory.createLog();
        log1.writeLog();
        Log log2;
        factory = new DatabaseLogFactory(); //可引入配置文件实现
        log2 = factory.createLog();
        log2.writeLog();
        Log log3;
        factory = new ConsoleLoggerFactory(); //可引入配置文件实现
        log3 =factory.createLog();
        log3.writeLog();
    }
}