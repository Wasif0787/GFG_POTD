class Solution {
    static Node first, middle, last, prev;
    public Node correctBST(Node root) {
        // code here.
        first = middle = last = prev = null;
 
        // Set the pointers to find out
        // two nodes
        correctBSTUtil( root );
 
        // Fix (or correct) the tree
        if( first != null && last != null )
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // Adjacent nodes swapped
        else if( first != null && middle !=
                                    null )
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        return root;
    }
    public static void correctBSTUtil( Node root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);
 
            // If this node is smaller than
            // the previous node, it's
            // violating the BST rule.
            if (prev != null && root.data <
                                prev.data)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }
 
                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }
 
            // Mark this node as previous
            prev = root;
 
            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }
}
