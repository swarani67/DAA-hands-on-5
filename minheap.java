import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class minheap<s extends Comparable<s>>
{
    List<s> dt;
    int LC_I(int k)
    {
        return (k<<1)+1;
    }
    int RC_I(int k)
    {
        return (k<<1)+2;
    }
    void heapify(int k)
    {
        int min=k;
        int lc= LC_I(k);
        int rc = RC_I(k);
        int heapSize = dt.size();
        if (lc< heapSize && dt.get(lc).compareTo(dt.get(min)) < 0)
        {
            min=lc;
        }
        if (rc<heapSize && dt.get(rc).compareTo(dt.get(min)) < 0)
        {
            min=rc;
        }

        if (min!= k)
        {
            s temp = dt.get(k);
            dt.set(k, dt.get(min));
            dt.set(min, temp);
            heapify(min);
        }
    }

    public void build(List<s> array)
    {
        dt=new ArrayList<>(array);
        for (int k = (dt.size() / 2) - 1; k>=0; k--)
        {
            heapify(k);
        }
    }

    public s pop()
    {
        if (dt.isEmpty())
        {
            return null;
        }
        s root=dt.get(0);
        dt.set(0, dt.get(dt.size() - 1));
        dt.remove(dt.size() - 1);
        heapify(0);
        return root;
    }

    public void print()
    {
        System.out.println("Min Heap: " + dt);
    }

    public static void main(String[] args)
    {
        minheap<Integer> mh = new minheap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("total elements in heap");
        int n = scanner.nextInt();
        List<Integer> data = new ArrayList<>();
        System.out.println("elements of heap:");
        for (int k=0;k<n;k++)
        {
            data.add(scanner.nextInt());
        }
        mh.build(data);
        mh.print();
        int RR=mh.pop();
        System.out.println("Removed_root of heap: "+RR);
        mh.print();

        scanner.close();
    }
}




total elements in heap 7
elements of heap:
4 10 3 5 1 7 9
Min Heap: [1, 4, 3, 5, 10, 7, 9]
Removed_root of heap: 1
Min Heap: [3, 4, 7, 5, 10, 9]
