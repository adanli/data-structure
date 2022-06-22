package demo.structure;

import demo.structure.tree.Node;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {
    private final List<Integer> list = new ArrayList<>();
    private Node<Integer> node = new Node<>(null);

    private final Integer[] arr = new Integer[]{
//            6, 12, 18, 25, 31, 37, 43, 50, 56, 62, 68, 75, 82, 88, 96
//            0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99, 100, 101, 102, 103, 104
            62, 88, 58, 47, 35, 73, 51, 99, 37, 93
    };

    @Before
    public void init() {
        list.addAll(Arrays.asList(arr));
    }

    @Test
    public void binarySearchTest() {
        System.out.println(binarySearch(16));
    }

    @Test
    public void insertSearchTest() {
        System.out.println(insertSearch(16));
    }

    /**
     * 二分法
     * @param dest
     * @return
     */
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

    /**
     * 插值查找
     */
    private Integer insertSearch(int dest) {
        int left = 0;
        int right = list.size()-1;
        int mid = BigDecimal.valueOf(left).add(
                (BigDecimal.valueOf(dest).subtract(BigDecimal.valueOf(list.get(left))))
                        .divide(BigDecimal.valueOf(list.get(right)).subtract(BigDecimal.valueOf(list.get(left))), 2, RoundingMode.HALF_UP)
                        .multiply(BigDecimal.valueOf(right).subtract(BigDecimal.valueOf(left)))
        ).intValue();
//        int mid = left + (dest - list.get(left))/(list.get(right)-list.get(left))*(right - left);

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
//            mid = left + (dest - list.get(left))/(list.get(right)-list.get(left))*(right - left);
            mid = BigDecimal.valueOf(left).add(
                    (BigDecimal.valueOf(dest).subtract(BigDecimal.valueOf(list.get(left))))
                            .divide(BigDecimal.valueOf(list.get(right)).subtract(BigDecimal.valueOf(list.get(left))), 2, RoundingMode.HALF_UP)
                            .multiply(BigDecimal.valueOf(right).subtract(BigDecimal.valueOf(left)))
            ).intValue();
            times++;
        }
        System.out.println("查询了" + times + "次");
        return -1;
    }

    /**
     * 构建二叉查找树
     * 如果值比当前结点小，则找左结点，否则找右结点
     * 如果找到的结点是空的，则构建结点，否则继续查找
     */
    @Before
    public void constructTree() {
        for(int i=0; i<arr.length; i++) {
            insertTreeNode(node, arr[i]);
        }
    }

    private void insertTreeNode(Node<Integer> _node, Integer num) {
        if(_node.getData() == null) _node.setData(num);
        else {
            if(num.compareTo(_node.getData()) < 0) {
                if(_node.getLeftNode() == null) _node.setLeftNode(new Node<>(null));
                insertTreeNode(_node.getLeftNode(), num);
            } else {
                if(_node.getRightNode() == null) _node.setRightNode(new Node<>(null));
                insertTreeNode(_node.getRightNode(), num);
            }
        }
    }

    /**
     * 中序遍历
     */
    @Test
    public void midVisitTest() {
        midVisit(node);
    }

    private void midVisit(Node<Integer> node) {
        if(node == null) return;
        if(node.getLeftNode() != null) midVisit(node.getLeftNode());
        System.out.println(node.getData());
        if(node.getRightNode() != null) midVisit(node.getRightNode());
    }

    int times = 0;

    /**
     * 二叉树查找
     */
    @Test
    public void treeSelectTest() {
        System.out.println(treeSelect(node, 93));
        System.out.println("查找了" + times + "次");
    }

    /**
     * 查到即返回元素结点
     * @param _node
     * @param num
     * @return
     */
    private Node<Integer> treeSelect(Node<Integer> _node, Integer num) {
        times++;
        if(_node == null) return null;
        if(_node.getData() == null) return null;
        if(num.compareTo(_node.getData()) == 0) return _node;
        if(num.compareTo(_node.getData()) < 0) {
            return treeSelect(_node.getLeftNode(), num);
        } else {
            return treeSelect(_node.getRightNode(), num);
        }
    }

    /**
     * 二叉树插入元素
     */
    @Test
    public void insertTreeNodeTest() {
        insertTreeNode(node, 95);
        midVisit(node);
    }

}
