//还是别人牛逼啊，这题纯copy的了
class Solution {
public Node connect(Node root) {
    if(root==null)
        return root;
    Node cur=root;
    while(cur!=null){           //控制cur到下一层的循环
        Node dumm=new Node();   //创建一个虚拟头结点(每一层都会创建)
        Node tail=dumm;         //维护一个尾节点指针（初始化是虚拟节点）

        while(cur!=null){        //控制cur同一层的循环
            if(cur.left!=null){  //判断cur的左节点是否为空，不为空时就是cur的下一层的第一个节点了
                tail.next=cur.left;
                tail=tail.next;
            }
            if(cur.right!=null){  //判断cur的右节点是否为空，此时不为空时就是cur的下一层的第一个节点了
                tail.next=cur.right;
                tail=tail.next;
            }
            cur=cur.next;         //cur同层移动到下一位置
        }
        cur=dumm.next;            //内循环结束，开始cur的下一层
    }
    return root;
}
}