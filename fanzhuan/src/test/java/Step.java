import org.junit.Test;

public class Step {
    @Test
    public void test(){
        System.out.print(f(6));
    }
    public int f(int n) {

        if(n==1 || n==2){
            return n;
        }
        return f(n-2)+f(n-1);
    }
}
