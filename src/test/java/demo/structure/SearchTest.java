package demo.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchTest {
    private List<Integer> list = new ArrayList<>();

    @Before
    public void init() {
        list.add(6);
        list.add(12);
        list.add(18);
        list.add(25);
        list.add(31);
        list.add(37);
        list.add(43);
        list.add(50);
        list.add(56);
        list.add(62);
        list.add(68);
        list.add(75);
        list.add(82);
        list.add(88);
        list.add(96);
    }

    @Test
    public void binaryTest() {
        System.out.println(binarySearch(18));
    }

    private Integer binarySearch(int dest) {
        int left = 0;
        int right = list.size()-1;
        int mid = (left + right)/2;

        int times = 1;

        while (left <= right) {
            if(dest == list.get(mid)) {
                System.out.println("查询了" + times + "次");
                return mid;
            }
            if(dest < list.get(mid)) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right)/2;
            times++;
        }
        System.out.println("查询了" + times + "次");
        return -1;
    }

}
