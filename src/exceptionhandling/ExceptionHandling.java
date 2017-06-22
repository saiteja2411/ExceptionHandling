package exceptionhandling;


/*  *checked exception: these are checked at the compile time and if no handling is present then it shows the error.
                       it shows " Uncompilable source code - unreported exception java.io.FileNotFoundException; must be caught or declared to be thrown"
                       - must be surrounded by try catch or throws should be used.
                       ex- FileNotFound, 
    *Un-checked exception: these are not checked at the compile time, rather while program is running if it throws the exception then handling is done.
                       ex- ArithmeticException,DivideByZero , NullPointedException
    *all Errors are checked exceptions, Exceptions have Checked and Unchecked, All Runtime Exceptions are Unckecked.
    *try MUST have either catch or finally. 
    *User defined exceptions must be catched immediately [OR] in the hirarchy of calling functions[throws must be present]
    *Throws Usage: For user defined exceptions when you use throw new myException then u MUST use Throws MyException in the function signature.
                   but for inbuilt exceptions no need to throw explicitly write directly in function, [OR] if you are throwing explicitly then no
                   need for writing throws.
    *when try is used and exception is present in it, then the next lines in try donot execute. but if that exception is caught then other code,
            below try catch will continue executing.
    *finally: executes for sure for any type of exception. whether it is caught by user or by JVM.
    *catch or finally cannot exist without a try.
    *userdefined exceptions are checked exceptions.
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class abs{
    
    public void acc(){
        
    }
    public abstract void withdrw();
}

public class ExceptionHandling {

    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        try {
            Scanner filescr = new Scanner(new File("xxx"));  // checked exception. 
            System.out.println("after file not found");
        } catch (FileNotFoundException ex) {
            System.out.println("FILE not found exception caught");
        }
        finally{
           System.out.println("In Finally Block");
        }
        
        
        int i = scr.nextInt();
       
            function1(i);
        
    }
    
    public static void function1(int i)  {
        try{
            ddd();
            
        }catch(Exception e){
            try{
                throw new Exception();
            }
            catch(Exception ex){
                System.out.println("nested exception inside catch block");
            }
            
            //System.out.println("exception Caught");
        }
    }
    
    public static void ddd() {
        //sum(5,1,2,3,4);
        throw new NullPointerException();
    }
    
    static public void sum(int b, int ...a){
        System.out.println(b+ a[2]);
    }

}

class MyException extends Exception {

    MyException(String str) {
        super(str);
    }

    String display(){
        return "Please enter a number greater than zero";
    }
}
