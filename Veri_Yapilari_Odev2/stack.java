
/**
 *
 * @author Efe
 */
public class stack {
    private int top, size;
    private String[] st;
    
    public stack(int size){
        this.top = -1;
        this.size = size;
        st = new String[size];
    }
    
    public int getTop() {
        return this.top;
    }
    
    public boolean isFull(){
        return top == size-1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void push(String text){
        if(!isFull()){
            top++;
            st[top] = text;
        }
    }
    
    public String pop(){
        if(!isEmpty()){
            String a = st[top];
            top--;
            return a;
        }
        return "null";
    }
    
    public void clear(){
        top = -1;
    }
}
