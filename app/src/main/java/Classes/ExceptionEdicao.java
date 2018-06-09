package Classes;

public class ExceptionEdicao extends Exception{

    public ExceptionEdicao(String msg){
        super(msg);
    }

    public ExceptionEdicao(String msg, Throwable cause){
        super(msg,cause);
    }
}
