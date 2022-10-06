public class DiziStack {
    int[] dizi;
    int size, top;

    DiziStack(int size){
        this.size = size;
        this.dizi = new int[size];
        top = -1;
    }

    public boolean DoluMu(){
        return (this.top == this.size-1);
    }

    public boolean BosMu(){
        return (this.top == -1);
    }

    public void push(int data){
        if(this.DoluMu())
            System.out.println("Stack dolu!");
        else{
            this.top++;
            this.dizi[this.top] = data;
        }
    }

    public int pop(){
        if(this.BosMu()){
            System.out.println("Stack bos!");
            return -1;
        }
        else{
            int a = this.dizi[this.top];
            this.top--;
            System.out.println(a+" cikarildi.");
            return a;
        }
    }

    public boolean search(int data){
        if(this.BosMu()){
            System.out.println("Stack bos! Aranan eleman bulunamadi.");
            return false;
        }
        else{
            for(int i = this.top ; i >= 0; i--){
                if(this.dizi[i] == data) {
                    System.out.println("Aranan eleman "+(i+1)+". sirada bulundu");
                    return true;
                }
            }
            System.out.println("Aranan eleman bulunamadi.");
            return false;
        }
    }

    public void printStack(){
        if(this.BosMu())
            System.out.println("Stack bos!");
        else{
            System.out.println("**");
            for(int i = this.top; i >= 0; i--){
                System.out.println(this.dizi[i]);
            }
            System.out.println("**");
        }
    }

}
