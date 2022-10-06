public class BagliListeStack {
    int size, sayac;
    Node top;

    BagliListeStack(int size){
        this.size = size;
        this.sayac = 0;
    }

    public boolean isFull(){
        return (this.sayac == size);
    }

    public boolean isEmpty(){
        return (this.sayac == 0);
    }

    public void push(int data){
        Node eklenecek = new Node(data);

        if(this.isFull())
            System.out.println("Stack dolu!");
        else{
            if(this.isEmpty())
                top = eklenecek;
            else{
                eklenecek.next = top;
                top = eklenecek;
            }
            sayac++;
        }
    }

    public int pop(){
        if(this.isEmpty()){
            System.out.println("Stack bos!");
            return -1;
        }
        else{
            int a = this.top.data;
            this.top = this.top.next;
            sayac--;
            System.out.println(a+" cikarildi.");
            return a;
        }
    }

    public boolean search(int data){
        if(this.isEmpty()){
            System.out.println("Stack bos! Aranan eleman bulunamadi.");
            return false;
        }
        else{
            Node temp = this.top;
            int cnt = 0;
            while(temp != null){
                if(temp.data == data){
                    System.out.println("Aranan eleman "+(size-cnt)+". sirada bulundu");
                    return true;
                }
                cnt++;
                temp = temp.next;
            }
            System.out.println("Aranan eleman bulunamadi.");
            return false;
        }
    }

    public void printStack(){
        if(this.isEmpty())
            System.out.println("Stack bos!");
        else{
            Node temp = this.top;

            System.out.println("**");
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println("**");
        }
    }
}
