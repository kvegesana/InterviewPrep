  class TreeLinkNode {
      int val;
      TreeLinkNode left;
      TreeLinkNode right;
      TreeLinkNode next;
      TreeLinkNode(int x) {
       val = x;
       left=null;
       right=null;
       next = null;
      }
 }

 public class Solution {
    public void connect(TreeLinkNode A) {
    	if(A == null) return;
    	TreeLinkNode p = A;
    	p.next = null;
    	while(p != null){
    		TreeLinkNode q = p;
    		while(q != null){
    			if(q.left != null){
    				if(q.right != null){
    					q.left.next = q.right;
    				}
    				else{
    					q.left.next = nextRight(q);
    				}
    			}
    			if(q.right != null){
    				q.right.next = nextRight(q);
    			}
    			q = q.next;
    		}
    		if(p.left != null){
    			p = p.left;
    		}
    		else if(p.right != null){
    			p = p.right;
    		}
    		else{
    			p = nextRight(p);
    		}
    	}
    }
    static TreeLinkNode nextRight(TreeLinkNode node){
    	TreeLinkNode temp = node.next;
    	while(temp != null){
    		if(temp.left != null) return temp.left;
    		if(temp.right != null) return temp.right;
    		temp = temp.next;
    	}
    	return null;
    }
}