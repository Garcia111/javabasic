二叉堆
    二叉堆本质上是一种完全二叉树，分为最大堆和最小堆两种类型；
    最大堆：任何一个父节点的值都大于等于它的左右孩子节点的值；堆顶是整个堆中的最大元素；
    最小堆：任何一个父节点的值都小于等于它的左右孩子节点的值；堆顶是整个堆中的最小元素；

    插入节点：
    1.插入的位置是完全二叉树的最后一个位置；
    2.让新节点与其父节点进行比较，然后进行上浮；

    删除节点：
    1.删除处于堆顶的节点；
    2.将堆的最后一个节点补到原本堆顶的位置；
    3.将新的堆顶与其左右孩子进行比较，进行下沉；


    构建二叉堆
    构建二叉堆就是将一个无序的完全二叉树调整为二叉堆，本质上就是让所有非叶子节点依次下沉；
    从最后一个非叶子节点开始，与其左右孩子比较进行下沉，直到最后比较的是根节点


    注意：二叉堆虽然是一颗完全二叉树，但是其存储方式并不是链式存储，而是顺序存储，存储在数组中；
         假如父节点的下标是parent，那么左孩子的下标就是2*parent+1;右孩子的下标是2*parent+2









